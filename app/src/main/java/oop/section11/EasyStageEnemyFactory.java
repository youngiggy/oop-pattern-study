package oop.section11;

import java.util.List;

public class EasyStageEnemyFactory implements EnemyFactory {
    @Override
    public Boss createBoss() {
        return new StrongAttackBoss();
    }

    @Override
    public SmallFlight createSmallFlight() {
        return new DashSmallFlight();
    }

    @Override
    public Obstacle createObstacle() {
        return new RockObstacle();
    }
}
