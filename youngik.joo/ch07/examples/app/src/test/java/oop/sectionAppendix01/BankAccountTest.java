package oop.sectionAppendix01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    public void canCreateBankAccount() {
        // Arrange
        var accountBuilder = new BankAccount.Builder(1234L)
                .withOwner("Marge")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5);

        // Act

        // Assert
        assertDoesNotThrow(accountBuilder::build);

    }

}
