package document_approval;

public class LegalReviewer extends DocumentHandler{
	@Override
    public boolean processDocument(Document doc) {
        System.out.println("\nLegal Reviewer examining: " + doc.getTitle());
        System.out.println("Checking legal compliance...");
        System.out.println("Reviewing trademark usage...");

        // Simulate legal review
        if (doc.getContent().toLowerCase().contains("confidential")) {
            System.out.println("❌ Rejected: Contains confidential information!");
            return false;
        }

        System.out.println("✅ Legal review passed");
        return forwardToNext(doc);
    }
}
