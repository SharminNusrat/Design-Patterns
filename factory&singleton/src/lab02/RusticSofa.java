package lab02;

import java.util.concurrent.atomic.AtomicInteger;

public class RusticSofa implements Sofa{
	private static final AtomicInteger idGenerator = new AtomicInteger(0);
	private final String uniqueId;
	
	public RusticSofa() {
		this.uniqueId = Integer.toString(idGenerator.incrementAndGet());
	}
	
	@Override
	public String getDescription() {
		return "This is a rustic sofa with unique id: " + uniqueId;
	}
	
	@Override
	public String getUniqueId() {
		return uniqueId;
	}
}
