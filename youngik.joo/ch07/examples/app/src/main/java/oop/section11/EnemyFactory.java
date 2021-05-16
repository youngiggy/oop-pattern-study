package oop.section11;

public interface EnemyFactory {
    Boss createBoss();
    SmallFlight createSmallFlight();
    Obstacle createObstacle();
}
