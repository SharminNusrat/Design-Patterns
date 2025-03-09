package document_approval;

public abstract class DocumentHandler {
	protected DocumentHandler nextHandler;
	
	public void setNextHandler(DocumentHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public abstract boolean processDocument(Document doc);
	
	protected boolean forwardToNext(Document doc) {
		if(nextHandler != null) {
			return nextHandler.processDocument(doc);
		}
		return true;
	}
}
