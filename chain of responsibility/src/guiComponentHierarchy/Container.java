package guiComponentHierarchy;

import java.util.ArrayList;
import java.util.List;

class Container extends Component {
    protected List<Component> children = new ArrayList<>();

    public void add(Component child) {
        children.add(child);
        child.setContainer(this);
    }

    @Override
    public void showHelp() {
        if (tooltipText != null) {
            System.out.println("Showing container tooltip: " + tooltipText);
        } else if (container != null) {
            container.showHelp();
        }
    }
}
