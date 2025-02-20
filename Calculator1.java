
 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
public class Calculator1 extends JPanel { 
    private JTextField display; 
    private StringBuilder input; 
    private double result; 
    private String operator; 
 
    public Calculator1() { 
        setLayout(new BorderLayout()); 
        input = new StringBuilder(); 
        result = 0; 
        operator = ""; 
         
        display = new JTextField(); 
        display.setEditable(false); 
        display.setFont(new Font("Arial", Font.BOLD, 50)); 
        display.setHorizontalAlignment(JTextField.RIGHT); 
        add(display, BorderLayout.NORTH); 
         
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setLayout(new GridLayout(5, 4, 4, 4)); 
         
        String[] buttons = { 
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "C", "+", 
            "<-", "=", "(" , ")" 
        }; 
         
        for (String text : buttons) { 
            JButton button = new JButton(text); 
            button.setFont(new Font("Arial", Font.BOLD, 18)); 
            button.addActionListener(new ButtonClickListener()); 
            buttonPanel.add(button); 
        } 
         
        add(buttonPanel, BorderLayout.CENTER); 
    } 
     
    private class ButtonClickListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) { 
            String command = e.getActionCommand(); 
             
            if (command.matches("[0-9]")) { 
                input.append(command); 
                display.setText(input.toString()); 
            } else if (command.equals("C")) { 
                input.setLength(0); 
                result = 0; 
                operator = ""; 
                display.setText(""); 
            } else if (command.equals("<-")) { 
                if (input.length() > 0) { 
                    input.deleteCharAt(input.length() - 1); 
                    display.setText(input.toString()); 
                } 
            } else if (command.equals("=")) { 
                if (!operator.isEmpty() && input.length() > 0) { 
                    double secondOperand = Double.parseDouble(input.toString()); 
                    switch (operator) { 
                        case "+": result += secondOperand; break; 
                        case "-": result -= secondOperand; break; 
                        case "*": result *= secondOperand; break; 
                        case "/": result /= secondOperand; break; 
                    } 
                    display.setText(String.valueOf(result)); 
                    input.setLength(0); 
                } 
            } else if (command.equals(".")) { 
                if (!input.toString().contains(".")) { 
                    input.append("."); 
                    display.setText(input.toString()); 
                } 
            } else { // Operator (+, -, *, /) 
                if (input.length() > 0) { 
                    result = Double.parseDouble(input.toString()); 
                    operator = command; 
                    input.setLength(0); 
                } 
            } 
        } 
    } 
     
    public static void main(String[] args) { 
        JFrame frame = new JFrame("Calculator1"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setSize(300, 500); 
frame.add(new Calculator1()); 
frame.setVisible(true); 
} 
} 