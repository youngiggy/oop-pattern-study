package oop.section11;

public class HardEnemyFactory implements EnemyFactory {
    @Override
    public Boss createBoss() {
        return new CloningBoss();
    }

    @Override
    public SmallFlight createSmallFlight() {
        return new MissileSmallFlight();
    }

    @Override
    public Obstacle createObstacle() {
        return new BombObstacle();
    }
}
