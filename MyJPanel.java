import javax.swing.JPanel;
import java.awt.Graphics;


public class MyJPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World!", 20, 30);
        g.drawString("This is our Java Course", 50, 50);
    }
    
}
