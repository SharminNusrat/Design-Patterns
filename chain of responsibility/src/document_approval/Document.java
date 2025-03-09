package document_approval;

public class Document {
	private String content;
	private String title;
	private boolean hasCodeSnippets;
	private boolean hasCitations;
	
	public Document(String content, String title, boolean hasCodeSnippets, boolean hasCitations) {
		this.content = content;
		this.title = title;
		this.hasCodeSnippets = hasCodeSnippets;
		this.hasCitations = hasCitations;
	}

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}
	
	public boolean hasCodeSnippets() {
		return hasCodeSnippets;
	}
	
	public boolean hasCitations() {
		return hasCitations;
	}
}
