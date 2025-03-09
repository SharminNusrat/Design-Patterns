package strategy;

public class AggressiveBehavior implements RobotBehavior{
	@Override
    public void behave() {
        System.out.println("Aggressive Behavior: Attacking the target!");
    }
}
