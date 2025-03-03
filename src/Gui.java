import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui game = new Gui();
            game.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].setPreferredSize(new Dimension(100, 100));
            buttons[i].addActionListener(new ButtonClickListener(i));
            frame.add(buttons[i]);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int index;

        public ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameOver || !buttons[index].getText().equals("")) {
                return; // Ignore the click if the game is over or the button is already clicked
            }

            buttons[index].setText(String.valueOf(currentPlayer));
            if (checkForWinner()) {
                JOptionPane.showMessageDialog(frame, currentPlayer + " Wins!");
                gameOver = true;
                return;
            }

            // Check for tie
            boolean tie = true;
            for (JButton button : buttons) {
                if (button.getText().equals("")) {
                    tie = false;
                    break;
                }
            }
            if (tie) {
                JOptionPane.showMessageDialog(frame, "It's a Tie!");
                gameOver = true;
                return;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean checkForWinner() {
        // Winning conditions: horizontal, vertical, diagonal
        int[][] winningConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical
                {0, 4, 8}, {2, 4, 6}  // diagonal
        };

        for (int[] condition : winningConditions) {
            if (buttons[condition[0]].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[condition[1]].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[condition[2]].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }
        return false;
    }
}
