package oop.section11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StageTest {
    @Test
    void Stage에_쉬운_레벨용_enemy들을_설정할_수_있다() {
        // Arrange
        int stageLevel = 1;
        var factory = new EasyStageEnemyFactory();
        Stage stage = new Stage(stageLevel, factory);

        // Act

        // Assert
        assertEquals("Stage : " + stageLevel, stage.getStageName());

        assertNotNull(stage.getBoss());
        assertTrue(stage.getSmallFlights().size() > 0);
        assertTrue(stage.getObstacles().size() > 0);
    }

    @Test
    void Stage에_어려운_레벨용_enemy들을_설정할_수_있다() {
        // Arrange
        int stageLevel = 2;
        var factory = new HardEnemyFactory();
        Stage stage = new Stage(stageLevel, factory);

        // Act

        // Assert
        assertEquals("Stage : " + stageLevel, stage.getStageName());

        assertNotNull(stage.getBoss());
        assertTrue(stage.getSmallFlights().size() > 0);
        assertTrue(stage.getObstacles().size() > 0);
    }
}
