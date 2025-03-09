package strategy;

public class Main {
	public static void main(String[] args) {
		Robot robot1 = new Robot("Robot1", new NormalBehavior());
        Robot robot2 = new Robot("Robot2", new AggressiveBehavior());
        Robot robot3 = new Robot("Robot3", new DefensiveBehavior());

        robot1.performBehavior();
        robot2.performBehavior();
        robot3.performBehavior();

        System.out.println("\nChanging behaviors dynamically...\n");

        robot1.setBehavior(new AggressiveBehavior());
//        robot2.setBehavior(new DefensiveBehavior());
//        robot3.setBehavior(new NormalBehavior());

        robot1.performBehavior();
        robot2.performBehavior();
        robot3.performBehavior();
    }
}