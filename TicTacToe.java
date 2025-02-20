import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
    JFrame frame;
    JButton[] buttons = new JButton[9];
    boolean playerY = true; // True -> Player X, False -> Player O

    public TicTacToe() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals("")) {
            return; // Ignore already clicked buttons
        }
        
        clickedButton.setText(playerY ? "X" : "O");
        clickedButton.setForeground(playerY ? Color.RED : Color.BLUE);
        
        if (checkWin()) {
            JOptionPane.showMessageDialog(frame, (playerY ? "X" : "O") + " wins!");
            resetGame();
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            resetGame();
        } else {
            playerY = !playerY; // Switch player turn
        }
    }

    private boolean checkWin() {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };
        
        for (int[] pattern : winPatterns) {
            if (!buttons[pattern[0]].getText().equals("") &&
                buttons[pattern[0]].getText().equals(buttons[pattern[1]].getText()) &&
                buttons[pattern[1]].getText().equals(buttons[pattern[2]].getText())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isDraw() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }
        playerY = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
