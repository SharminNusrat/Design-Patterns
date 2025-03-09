package document_approval;

public class PublishingSystemDemo {
	public static void main(String[] args) {
        // Create the chain of responsibility
        DocumentHandler languageEditor = new LanguageEditor();
        DocumentHandler technicalReviewer = new TechnicalReviewer();
        DocumentHandler plagiarismChecker = new PlagiarismChecker();
        DocumentHandler legalReviewer = new LegalReviewer();
        DocumentHandler seniorEditor = new SeniorEditor();

        // Set up the chain
        languageEditor.setNextHandler(technicalReviewer);
        technicalReviewer.setNextHandler(plagiarismChecker);
        plagiarismChecker.setNextHandler(legalReviewer);
        legalReviewer.setNextHandler(seniorEditor);

        // Create test documents
        Document article1 = new Document(
            "Java Best Practices",
            "This is a technical article about Java programming...",
            true,  // has code snippets
            true   // has citations
        );

        Document article2 = new Document(
            "Confidential Tech Review",
            "This confidential article discusses...",
            true,
            true
        );

        // Process the documents
        System.out.println("Processing Article 1:");
        boolean result1 = languageEditor.processDocument(article1);
        System.out.println("\nFinal Result: " + (result1 ? "Article Approved! 🎉" : "Article Rejected ❌"));

        System.out.println("\n-----------------------------------");

        System.out.println("Processing Article 2:");
        boolean result2 = languageEditor.processDocument(article2);
        System.out.println("\nFinal Result: " + (result2 ? "Article Approved! 🎉" : "Article Rejected ❌"));
    }
}
