import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * TicTacToeGame
 */
public class TicTacToeGame extends MyJFrame {

    JPanel jPanel; // we want this to be accessible throughout the class
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    int ROWS = 3, COLUMNS = 3;
    String currentPlayer = "X";
    Font font;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem resetGameItem;
    int playerXWinCount = 0;
    int playerYWinCount = 0;
    int tieGameCount = 0;
    int buttonClickedCount = 0;

    // constructor which has no parameters
    public TicTacToeGame() {
        // call the parent classes constructor and pass in a title
        super("Tic Tac Toe Game");

        menuBar = new JMenuBar(); // create the menu bar
        menu = new JMenu("Game Options"); // create the menu
        resetGameItem = new JMenuItem("Reset Game"); // create the menu item 
        resetGameItem.addActionListener(e -> ResetGame()); // this registers a listener that will listen for clicks on this button

        menu.add(resetGameItem); // add the menu item to the menu
        menuBar.add(menu); // add the menu to the menu bar
        setJMenuBar(menuBar); // add the menu bar to the JFrame

        jPanel = new JPanel(); // needs to be instantiated
        // // jPanel.setLayout(new BorderLayout());

        // // jPanel.add(new JButton("OK"), BorderLayout.SOUTH);
        // // jPanel.add(new JButton("Cancel"), BorderLayout.CENTER);

        jPanel.setLayout(new GridLayout(ROWS, COLUMNS));
        // instantiating the FONT
        font = new Font(Font.SANS_SERIF, Font.ITALIC, 100);

        for (int i = 0; i < ROWS * COLUMNS; i++) {
            JButton btn = new JButton();
            btn.addActionListener(event -> ButtonClicked(event));
            // SET THE FONT on the BUTTON
            btn.setFont(font);
            buttons.add(btn);
            jPanel.add(btn);
        }

        setContentPane(jPanel);
        setVisible(true);
    }

    /**
     * Will reset the game. This involves resetting who the current player is
     * and resetting the text, color, and enabled status of each button
     */
    public void ResetGame() {
        currentPlayer = "X";
        for (int i = 0; i < buttons.size(); i++) {
            JButton btn = buttons.get(i);
            btn.setText("");
            btn.setBackground(null);
            btn.setEnabled(true);
            buttonClickedCount = 0;
        }
    }

    public void ButtonClicked(ActionEvent event) {

        JButton btnClicked = ((JButton) event.getSource());
        btnClicked.setText(currentPlayer);
        btnClicked.setEnabled(false);

        if (currentPlayer == "X") {
            btnClicked.setBackground(Color.RED);
        } else {
            btnClicked.setBackground(Color.GREEN);
        }

        boolean winnerFound = CheckWinner();

        if (winnerFound) {
            if(currentPlayer == "X") {
                playerXWinCount++;
            } else {
                playerYWinCount++;
            }

            JOptionPane.showMessageDialog(null, currentPlayer + " has won the game!\n\nPlayer X wins: " + playerXWinCount + "\nPlayer O wins: " + playerYWinCount + "\nTie game count: " + tieGameCount);

            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setEnabled(false);
            }
            
            
        }

        SwitchPlayer();
        buttonClickedCount++; 
        if (winnerFound == false && buttonClickedCount == 9) {
            tieGameCount++;
            JOptionPane.showMessageDialog(null, "The game results in a tie.\nRestart and try again.\n\nPlayer X wins: " + playerXWinCount + "\nPlayer O wins: " + playerYWinCount + "\nTie game count: " + tieGameCount);
        }
    }

    public void SwitchPlayer() {
        if (currentPlayer == "X") {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
    
    public boolean CheckWinner() {
        // first row
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(1).getText().equals(currentPlayer) &&
                buttons.get(2).getText().equals(currentPlayer)) {
            return true;
        }

        // second row
        if(buttons.get(3).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(5).getText().equals(currentPlayer)) {
            return true;
        }
        
        // third row
        if(buttons.get(6).getText().equals(currentPlayer) && buttons.get(7).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        // diagonal 1
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }
        
        // diagonal 2
        if(buttons.get(2).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 1 
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(3).getText().equals(currentPlayer) &&
                buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 2
        if(buttons.get(1).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) &&
                buttons.get(7).getText().equals(currentPlayer)) {
            return true;
        }
        
        // column 3
        if(buttons.get(2).getText().equals(currentPlayer) && buttons.get(5).getText().equals(currentPlayer) &&
        buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }  
            
        
        return false;
    }
}