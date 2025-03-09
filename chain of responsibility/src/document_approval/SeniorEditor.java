package document_approval;

public class SeniorEditor extends DocumentHandler{
	@Override
    public boolean processDocument(Document doc) {
        System.out.println("\nSenior Editor reviewing: " + doc.getTitle());
        System.out.println("Performing final content review...");
        System.out.println("Checking brand voice alignment...");

        // Simulate final review
        if (doc.getContent().length() > 1000) {
            System.out.println("❌ Rejected: Article too long for our format!");
            return false;
        }

        System.out.println("✅ Final review passed");
        return true;
    }
}
