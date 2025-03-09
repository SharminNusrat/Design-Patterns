package access_control_proxy;

public class RealFile implements File{
	private String filename;
	
	public RealFile(String filename) {
		this.filename = filename;
		loadFromCloud();
	}
	
	private void loadFromCloud() {
		System.out.println("Loading file from cloud: " + filename);
	}
	
	@Override
	public void access(String user) {
		System.out.println("Accessing file: " + filename + " by user: " + user);
	}
}
