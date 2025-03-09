// Support ticket class
class Ticket {
    private String description;
    private SupportLevel severity;

    public Ticket(String description, SupportLevel severity) {
        this.description = description;
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public SupportLevel getSeverity() {
        return severity;
    }
}

// Enum for different support levels
enum SupportLevel {
    BASIC,      // Password resets, account issues
    TECHNICAL,  // Configuration, performance issues
    DEVELOPER,  // Code-level bugs, database issues
    PRODUCT     // Feature requests, strategic decisions
}

// Abstract handler
abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected SupportLevel supportLevel;

    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleTicket(Ticket ticket);

    protected void escalateTicket(Ticket ticket) {
        if (nextHandler != null) {
            System.out.println("Escalating ticket to next level...\n");
            nextHandler.handleTicket(ticket);
        } else {
            System.out.println("This is the highest level of support. Ticket needs special attention.");
        }
    }
}

// Level 1 Support Handler
class HelpDeskSupport extends SupportHandler {
    public HelpDeskSupport() {
        this.supportLevel = SupportLevel.BASIC;
    }

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getSeverity() == SupportLevel.BASIC) {
            System.out.println("Help Desk handling ticket:");
            System.out.println("Performing basic troubleshooting for: " + ticket.getDescription());
            System.out.println("Issue resolved at Help Desk level\n");
        } else {
            System.out.println("Help Desk cannot handle this issue.");
            escalateTicket(ticket);
        }
    }
}

// Level 2 Support Handler
class TechnicalSupport extends SupportHandler {
    public TechnicalSupport() {
        this.supportLevel = SupportLevel.TECHNICAL;
    }

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getSeverity() == SupportLevel.TECHNICAL) {
            System.out.println("Technical Support handling ticket:");
            System.out.println("Performing advanced troubleshooting for: " + ticket.getDescription());
            System.out.println("Issue resolved at Technical Support level\n");
        } else {
            System.out.println("Technical Support cannot handle this issue.");
            escalateTicket(ticket);
        }
    }
}

// Level 3 Support Handler
class DeveloperSupport extends SupportHandler {
    public DeveloperSupport() {
        this.supportLevel = SupportLevel.DEVELOPER;
    }

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getSeverity() == SupportLevel.DEVELOPER) {
            System.out.println("Developer Support handling ticket:");
            System.out.println("Investigating code-level issue: " + ticket.getDescription());
            System.out.println("Issue resolved at Developer level\n");
        } else {
            System.out.println("Developer Support cannot handle this issue.");
            escalateTicket(ticket);
        }
    }
}

// Product Manager Handler
class ProductManager extends SupportHandler {
    public ProductManager() {
        this.supportLevel = SupportLevel.PRODUCT;
    }

    @Override
    public void handleTicket(Ticket ticket) {
        if (ticket.getSeverity() == SupportLevel.PRODUCT) {
            System.out.println("Product Manager handling ticket:");
            System.out.println("Evaluating product request: " + ticket.getDescription());
            System.out.println("Request being processed at Product Management level\n");
        } else {
            escalateTicket(ticket);
        }
    }
}

// Demo class
public class SupportTicketDemo {
    public static void main(String[] args) {
        // Create the chain of responsibility
        SupportHandler helpDesk = new HelpDeskSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler developerSupport = new DeveloperSupport();
        SupportHandler productManager = new ProductManager();

        // Set up the chain
        helpDesk.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(developerSupport);
        developerSupport.setNextHandler(productManager);

        // Create some test tickets
        Ticket passwordReset = new Ticket("Cannot reset password", SupportLevel.BASIC);
        Ticket performanceIssue = new Ticket("Application running slowly", SupportLevel.TECHNICAL);
        Ticket bugReport = new Ticket("Database connection failing", SupportLevel.DEVELOPER);
        Ticket featureRequest = new Ticket("Need new reporting feature", SupportLevel.PRODUCT);

        // Process the tickets
        System.out.println("Processing Password Reset Ticket:");
        helpDesk.handleTicket(passwordReset);

        System.out.println("Processing Performance Issue Ticket:");
        helpDesk.handleTicket(performanceIssue);

        System.out.println("Processing Bug Report Ticket:");
        helpDesk.handleTicket(bugReport);

        System.out.println("Processing Feature Request Ticket:");
        helpDesk.handleTicket(featureRequest);
    }
}