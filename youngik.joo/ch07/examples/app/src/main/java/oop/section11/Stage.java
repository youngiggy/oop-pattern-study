package oop.section11;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    Boss boss;
    List<Obstacle> obstacles = new ArrayList<>();
    List<SmallFlight> smallFlights = new ArrayList<>();
    private final int level;
    private final EnemyFactory enemyFactory;

    public Stage(int level, EnemyFactory enemyFactory) {
        this.level = level;
        this.enemyFactory = enemyFactory;
        boss = enemyFactory.createBoss();
        createSmallFlights();
        createObstacles();
    }

    private void createObstacles() {
        for (int i = 0; i < 5; i++) {
            obstacles.add(enemyFactory.createObstacle());
        }
    }

    private void createSmallFlights() {
        for (int i = 0; i < 5; i++) {
            smallFlights.add(enemyFactory.createSmallFlight());
        }
    }

    public Boss getBoss() {
        return boss;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<SmallFlight> getSmallFlights() {
        return smallFlights;
    }

    public String getStageName() {
        return "Stage : " + level;
    }
}
