import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingDemo extends JFrame implements ActionListener, MouseListener {

    private JButton clickButton;
    private JLabel mouseLabel;

    public EventHandlingDemo() {
        setTitle("Event Handling Example");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button with ActionListener
        clickButton = new JButton("Click Me");
        clickButton.addActionListener(this);
        add(clickButton);

        // Label with MouseListener
        mouseLabel = new JLabel("Hover or Click Here");
        mouseLabel.setPreferredSize(new Dimension(150, 50));
        mouseLabel.setOpaque(true);
        mouseLabel.setBackground(Color.LIGHT_GRAY);
        mouseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mouseLabel.addMouseListener(this);
        add(mouseLabel);

        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Button Clicked!");
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseLabel.setText("Mouse Clicked!");
        mouseLabel.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseLabel.setText("Mouse Entered");
        mouseLabel.setBackground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseLabel.setText("Mouse Exited");
        mouseLabel.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseLabel.setText("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseLabel.setText("Mouse Released");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventHandlingDemo());
    }
}
