package strategy;

public class Robot {
	private String name;
    private RobotBehavior behavior;

    public Robot(String name, RobotBehavior initialBehavior) {
        this.name = name;
        this.behavior = initialBehavior;
    }

    public void setBehavior(RobotBehavior behavior) {
        this.behavior = behavior;
    }

    public void performBehavior() {
        System.out.print(name + " -> ");
        behavior.behave();
    }
}
