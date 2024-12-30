package lab08;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem{

	private List<FileSystem> fileComponents; 
	private String name;
	
	public Folder(String name) {
		this.name = name;
		this.fileComponents = new ArrayList<>();
	}
	
	public void addComponent(FileSystem component) {
		fileComponents.add(component);
	}
	
	public void removeComponent(FileSystem component) {
		fileComponents.remove(component);
	}
	
	@Override
	public void search(String key) {
		System.out.println("Searching in folder: " + this.name);
		for(FileSystem component: fileComponents) {
			component.search(key);
		}
	}
}
