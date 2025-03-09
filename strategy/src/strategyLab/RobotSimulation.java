package strategyLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Strategy interface for robot behaviors
interface RobotBehavior {
    void execute(Robot robot);
}

// Concrete behavior strategies
class AggressiveBehavior implements RobotBehavior {
    @Override
    public void execute(Robot robot) {
        System.out.println(robot.getId() + " is acting aggressively!");
        // Aggressive behavior logic: move towards nearby objects, potentially attack
        robot.setSpeed(2.0);
    }
}

class DefensiveBehavior implements RobotBehavior {
    @Override
    public void execute(Robot robot) {
        System.out.println(robot.getId() + " is in defensive mode!");
        // Defensive behavior logic: avoid obstacles, minimize exposure
        robot.setSpeed(0.5);
    }}

class NormalBehavior implements RobotBehavior {
    @Override
    public void execute(Robot robot) {
        System.out.println(robot.getId() + " is in normal mode.");
        // Normal behavior logic: standard movement, balanced approach
        robot.setSpeed(1.0);
    }
}

// Robot class using the strategy
class Robot {
    private String id;
    private double x, y;
    private double speed;
    private RobotBehavior currentBehavior;
    private List<Obstacle> nearbyObstacles;

    public Robot(String id, RobotBehavior initialBehavior) {
        this.id = id;
        this.currentBehavior = initialBehavior;
        this.nearbyObstacles = new ArrayList<>();
        this.x = 0;
        this.y = 0;
    }

    public void setBehavior(RobotBehavior behavior) {
        this.currentBehavior = behavior;
    }

    public void performBehavior() {
        currentBehavior.execute(this);
    }

    public void updatePosition(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void addNearbyObstacle(Obstacle obstacle) {
        nearbyObstacles.add(obstacle);
    }

    // Getters and setters
    public String getId() { return id; }
    public void setSpeed(double speed) { this.speed = speed; }
    public double getSpeed() { return speed; }
}

// Represents an obstacle in the environment
class Obstacle {
    private double x, y;
    private double size;

    public Obstacle(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}

// Simulation manager
public class RobotSimulation {
    public static void main(String[] args) {
        // Create robots with initial behaviors
        Robot robot1 = new Robot("R1", new AggressiveBehavior());
        Robot robot2 = new Robot("R2", new DefensiveBehavior());
        Robot robot3 = new Robot("R3", new NormalBehavior());

        List<Robot> robots = new ArrayList<>();
        robots.add(robot1);
        robots.add(robot2);
        robots.add(robot3);

        // Simulate behavior changes
        simulateBehaviorChanges(robots);
    }

    private static void simulateBehaviorChanges(List<Robot> robots) {
        Random random = new Random();

        // Simulate multiple iterations of behavior execution and potential changes
        for (int i = 0; i < 5; i++) {
            System.out.println("\nIteration " + (i + 1) + ":");
            
            for (Robot robot : robots) {
                // Randomly change behavior with some probability
                if (random.nextDouble() < 0.3) {
                    RobotBehavior[] behaviors = {
                        new AggressiveBehavior(), 
                        new DefensiveBehavior(), 
                        new NormalBehavior()
                    };
                    robot.setBehavior(behaviors[random.nextInt(behaviors.length)]);
                }

                // Execute current behavior
                robot.performBehavior();
            }
        }
    }
}