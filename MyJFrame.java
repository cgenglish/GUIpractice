import javax.swing.JFrame;

public class MyJFrame extends JFrame {
    public MyJFrame(String title) {
        super(title);
        // MyJPanel panel = new MyJPanel();
        // setContentPane(panel);
        setSize(650, 450);
        setLocation(1000, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
