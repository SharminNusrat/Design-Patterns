package strategy;

public class NormalBehavior implements RobotBehavior{
	@Override
    public void behave() {
        System.out.println("Normal Behavior: Moving forward normally.");
    }
}
