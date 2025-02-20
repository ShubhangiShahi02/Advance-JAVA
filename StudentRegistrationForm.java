import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(500, 400
        );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4, 10, 10));

        // Labels and input fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        // Submit button
        JButton submitButton = new JButton("Submit");

        // Adding components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderPanel);
        panel.add(new JLabel());  // Empty space
        panel.add(submitButton);

        // Add panel to frame
        frame.add(panel, BorderLayout.CENTER);

        // Button click event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = male.isSelected() ? "Male" : "Female";

                JOptionPane.showMessageDialog(frame, "Name: " + name + "\nAge: " + age + "\nGender: " + gender);
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
