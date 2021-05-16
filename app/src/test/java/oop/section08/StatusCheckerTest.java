package oop.section08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StatusCheckerTest {

    @Test
    void statusCheckerCanNotifyStatusObserver() {
        // Arrange
        StatusChecker sut = new StatusChecker();
        var status = new Status();

        var statusObserver = spy(StatusObserver.class);
        doNothing().when(statusObserver).onAbnormalStatus(status);
        sut.add(statusObserver);

        // Act
        sut.notifyStatus(status);

        // Assert
        verify(statusObserver).onAbnormalStatus(status);
    }

    @Test
    void statusCheckerDoNothingWhenNormal() {
        // Arrange
        var sut = new StatusChecker();
        var statusObserver = spy(StatusObserver.class);
        sut.add(statusObserver);

        var status = new Status();
        status.setNormal(true);

        // Act
        sut.check(status);

        // Assert
        verify(statusObserver, never()).onAbnormalStatus(status);
    }

    @Test
    void statusCheckerCanNotifyWhenNotNormal() {
        // Arrange
        var sut = new StatusChecker();

        var status = new Status();
        status.setNormal(false);

        var statusObserver = spy(StatusObserver.class);
        doNothing().when(statusObserver).onAbnormalStatus(status);
        sut.add(statusObserver);

        // Act
        sut.check(status);

        // Assert
        verify(statusObserver).onAbnormalStatus(status);
    }

    @Test
    void statusCheckerCanNotifyAllObserversWhenNotNormal() {
        // Arrange
        var sut = new StatusChecker();

        var status = new Status();
        status.setNormal(false);

        var emailSender = spy(StatusEmailSender.class);
        doNothing().when(emailSender).onAbnormalStatus(status);
        sut.add(emailSender);

        var messageSender = spy(StatusMessageSender.class);
        doNothing().when(messageSender).onAbnormalStatus(status);
        sut.add(messageSender);

        // Act
        sut.check(status);

        // Assert
        verify(emailSender).onAbnormalStatus(status);
        verify(messageSender).onAbnormalStatus(status);
    }
}
