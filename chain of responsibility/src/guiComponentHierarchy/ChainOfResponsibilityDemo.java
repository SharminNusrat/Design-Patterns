package guiComponentHierarchy;

class Button extends Component {
    // Inherits showHelp() from Component
}

class Panel extends Container {
    private String modalHelpText;

    public void setModalHelpText(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelp() {
        if (modalHelpText != null) {
            System.out.println("Showing modal help: " + modalHelpText);
        } else {
            super.showHelp();
        }
    }
}

class Dialog extends Container {
    private String wikiPageURL;

    public void setWikiPageURL(String wikiPageURL) {
        this.wikiPageURL = wikiPageURL;
    }

    @Override
    public void showHelp() {
        if (wikiPageURL != null) {
            System.out.println("Opening wiki page: " + wikiPageURL);
        } else {
            super.showHelp();
        }
    }
}


public class ChainOfResponsibilityDemo {
	public static void main(String[] args) {
        // Create components
        Dialog dialog = new Dialog();
        dialog.setWikiPageURL("https://example.com/help");

        Panel panel = new Panel();
        panel.setModalHelpText("This is a modal help text for the panel.");

        Button button = new Button();
        button.setTooltipText("Click this button to submit.");

        // Build the hierarchy
        panel.add(button);
        dialog.add(panel);

        // Trigger help from different components
        System.out.println("Button help:");
        button.showHelp();

        System.out.println("\nPanel help:");
        panel.showHelp();

        System.out.println("\nDialog help:");
        dialog.showHelp();
    }
}
