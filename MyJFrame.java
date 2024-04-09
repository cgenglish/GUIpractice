import javax.swing.JFrame;

public class MyJFrame extends JFrame {
    public MyJFrame(String title) {
        //dont need to call JFrame. whatever here because already 
        //within via inheritance and accessing it via extends and import
        super(title);
        MyJPanel jPanel = new MyJPanel();
        setContentPane(jPanel);
        setSize(550, 400); 
        setLocation(400, 200);
        setVisible(true);
}    
}
