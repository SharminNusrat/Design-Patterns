package document_approval;

public class PlagiarismChecker extends DocumentHandler{
	@Override
    public boolean processDocument(Document doc) {
        System.out.println("\nPlagiarism Checker scanning: " + doc.getTitle());
        System.out.println("Running plagiarism detection...");
        
        if (doc.hasCitations()) {
            System.out.println("Verifying citations...");
        } else {
            System.out.println("❌ Rejected: No citations provided!");
            return false;
        }

        System.out.println("✅ Originality check passed");
        return forwardToNext(doc);
    }
}
