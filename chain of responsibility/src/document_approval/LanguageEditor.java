package document_approval;

public class LanguageEditor extends DocumentHandler{
	@Override
	public boolean processDocument(Document doc) {
		System.out.println("\nLanguage Editor reviewing: " + doc.getTitle());
        System.out.println("Checking grammar and spelling...");
        System.out.println("Verifying writing style...");
        
        if(doc.getContent().length() < 10) {
        	System.out.println("Rejected: Content too short!");
        	return false;
        }
        
        System.out.println("Language check passed");
        return forwardToNext(doc);
	}
}
