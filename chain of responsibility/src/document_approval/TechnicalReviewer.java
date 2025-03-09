package document_approval;

public class TechnicalReviewer extends DocumentHandler{
	 @Override
	 public boolean processDocument(Document doc) {
		 System.out.println("\nTechnical Reviewer analyzing: " + doc.getTitle());
	     System.out.println("Checking technical accuracy...");
	        
	     if (doc.hasCodeSnippets()) {
	    	 System.out.println("Validating code snippets...");
	     }

	     // Simulate technical review
	     if (!doc.hasCodeSnippets() && doc.getContent().contains("technical")) {
	    	 System.out.println("❌ Rejected: Technical content needs code examples!");
	    	 return false;
	     }

	     System.out.println("✅ Technical review passed");
	     return forwardToNext(doc);
	 }
}