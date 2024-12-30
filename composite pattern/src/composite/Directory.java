package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

	private String name;
	private List<FileSystem> children = new ArrayList<>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	public void add(FileSystem component) {
		children.add(component);
	}
	
	public void remove(FileSystem component) {
		children.remove(component);
	}
	
	@Override
	public void display(String indent) {
		System.out.println(indent + "Directory: " + name);
		for(FileSystem child: children) {
			child.display(indent + " ");
		}
	}
}
