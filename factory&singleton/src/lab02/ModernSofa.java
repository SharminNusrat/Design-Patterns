package lab02;

import java.util.concurrent.atomic.AtomicInteger;

public class ModernSofa implements Sofa{
	private static final AtomicInteger idGenerator = new AtomicInteger(0);
	private final String uniqueId;
	
	public ModernSofa() {
		this.uniqueId = Integer.toString(idGenerator.incrementAndGet());
	}
	
	@Override
	public String getDescription() {
		return "This is a modern sofa with unique id: " + uniqueId;
	}
	
	@Override
	public String getUniqueId() {
		return uniqueId;
	}
}
