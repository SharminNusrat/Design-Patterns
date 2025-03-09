package lab02;

import java.util.concurrent.atomic.AtomicInteger;

public class RusticChair implements Chair{
	private static final AtomicInteger idGenerator = new AtomicInteger(0);
	private final String uniqueId;
	
	public RusticChair() {
		this.uniqueId = Integer.toString(idGenerator.incrementAndGet());
	}
	
	@Override
	public String getDescription() {
		return "This is a rustic chair with unique id: " + uniqueId;
	}
	
	@Override
	public String getUniqueId() {
		return uniqueId;
	}
}
