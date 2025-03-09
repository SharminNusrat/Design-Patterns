package guiComponentHierarchy;

public abstract class Component implements ComponentWithContextualHelp{
	protected Container container;
    protected String tooltipText;

    public void setContainer(Container container) {
        this.container = container;
    }

    public void setTooltipText(String tooltipText) {
        this.tooltipText = tooltipText;
    }

    @Override
    public void showHelp() {
        if (tooltipText != null) {
            System.out.println("Showing tooltip: " + tooltipText);
        } else if (container != null) {
            container.showHelp();
        }
    }
}
