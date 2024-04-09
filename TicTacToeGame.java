import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TicTacToeGame extends MyJFrame{
    JPanel jPanel;
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    int ROWS = 3, COLUMNS = 3;
    String currentPlayer = "X";
    Font font;
    Font boldFont;

    //constructor which has no parameters
    public TicTacToeGame() {
        //call the parent constructor and pass in the name of the title
        super("Tic Tac Toe Game");
        jPanel = new JPanel(); // needs to be instantiated
        font = new Font(Font.SERIF, Font.ITALIC, 150);
        boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 200);
        // jPanel.setLayout(new BorderLayout());
        // jPanel.add(new JButton("Ok"), BorderLayout.EAST);
        // jPanel.add(new JButton("Cancel"), BorderLayout.WEST);
        jPanel.setLayout(new GridLayout(ROWS,COLUMNS));
        for(int i = 0; i < ROWS * COLUMNS; i++) {
            JButton btn = new JButton();
            btn.addActionListener(event -> ButtonClicked(event));
            btn.setFont(boldFont);
            buttons.add(btn);
            jPanel.add(btn);
        }
        
        
        setContentPane(jPanel);
        setVisible(true);

    }

    public void ButtonClicked(ActionEvent event) {
        JButton btnClicked = ((JButton)event.getSource());
        btnClicked.setText(currentPlayer);
        btnClicked.setEnabled(false);
        //System.out.println("Button Clicked"); //test to make sure working
        if(currentPlayer == "X") {
            btnClicked.setBackground(Color.BLUE);
            //do something
            currentPlayer = "O";
        } else {
            btnClicked.setBackground(Color.ORANGE);
            currentPlayer = "X";
            //do something else
        }
    }

    public boolean checkWinner() {
        //Across First Row Check
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(1).getText().equals(currentPlayer) && buttons.get(2).getText().equals(currentPlayer)) {
            return true;
        }
        //Across Second Row Check
        if(buttons.get(3).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) && buttons.get(5).getText().equals(currentPlayer)) {
            return true;
        }
        //Across Third Row Check
        if(buttons.get(6).getText().equals(currentPlayer) && buttons.get(7).getText().equals(currentPlayer) && buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }
        //Diagonal Top Left to Bottom Right Check
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) && buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }
        //Diagonal Top Right to Bottom Left Check
        if(buttons.get(3).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) && buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        //Down Left Column Check
        if(buttons.get(0).getText().equals(currentPlayer) && buttons.get(3).getText().equals(currentPlayer) && buttons.get(6).getText().equals(currentPlayer)) {
            return true;
        }
        //Down Middle Column Check
        if(buttons.get(1).getText().equals(currentPlayer) && buttons.get(4).getText().equals(currentPlayer) && buttons.get(7).getText().equals(currentPlayer)) {
            return true;
        }
        //Down Right Column Check
        if(buttons.get(2).getText().equals(currentPlayer) && buttons.get(6).getText().equals(currentPlayer) && buttons.get(8).getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }
}
