package lab02;

import java.util.concurrent.atomic.AtomicInteger;

public class RusticTable implements Table{
	private static final AtomicInteger idGenerator = new AtomicInteger(0);
	private final String uniqueId;
	
	public RusticTable() {
		this.uniqueId = Integer.toString(idGenerator.incrementAndGet());
	}
	
	@Override
	public String getDescription() {
		return "This is a rustic table with unique id: " + uniqueId;
	}
	
	@Override
	public String getUniqueId() {
		return uniqueId;
	}
}
