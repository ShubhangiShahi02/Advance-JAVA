import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MultiPanelComboApp extends JFrame {

    public MultiPanelComboApp() {
        setTitle("Multiple Panels with Compound Borders and Combo Boxes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(1, 3)); // 3 panels side by side

        // Create three panels with combo boxes
        add(createCustomPanel("Panel 1", new String[]{"Red", "Green", "Blue"}, Color.LIGHT_GRAY));
        add(createCustomPanel("Panel 2", new String[]{"Apple", "Banana", "Cherry"}, Color.WHITE));
        add(createCustomPanel("Panel 3", new String[]{"Cat", "Dog", "Bird"}, Color.PINK));

        setVisible(true);
    }

    private JPanel createCustomPanel(String title, String[] comboItems, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setLayout(new BorderLayout());

        // Create compound border: titled + empty
        Border outer = BorderFactory.createTitledBorder(title);
        Border inner = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compound = BorderFactory.createCompoundBorder(outer, inner);
        panel.setBorder(compound);

        // Add ComboBox
        JComboBox<String> comboBox = new JComboBox<>(comboItems);
        comboBox.setSelectedIndex(0);
        panel.add(comboBox, BorderLayout.NORTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiPanelComboApp());
    }
}
