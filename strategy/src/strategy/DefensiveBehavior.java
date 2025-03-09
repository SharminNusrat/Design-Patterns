package strategy;

public class DefensiveBehavior implements RobotBehavior{
	@Override
    public void behave() {
        System.out.println("Defensive Behavior: Taking a defensive position.");
    }
}
