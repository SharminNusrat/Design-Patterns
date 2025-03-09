package access_control_proxy;

public class ProxyFile implements File{
	private String filename;
	private RealFile realFile;
	private String owner;
	
	public ProxyFile(String filename, String owner) {
		this.filename = filename;
		this.owner = owner;
	}
	
	@Override
	public void access(String user) {
		if(user.equals(owner) || user.equals("admin")) {
			if(realFile == null) {
				realFile = new RealFile(filename);
			}
			realFile.access(user);
		} 
		else {
			System.out.println("Access denied: User " + user + " is not authorized to access " + filename);
		}
	}
}
