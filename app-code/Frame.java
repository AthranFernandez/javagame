import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    //makes a window -[ JFRAME ] and initializes it

    public boolean isRunning = false;
    public int w = 500, h = 500;

    public void Win_init() {
        add(new Game());
        setSize(new Dimension(w, h));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //new Object() that calls Win_init

    public static void main(String[] args) {
        Frame window = new Frame();
        window.Win_init();
        window.isRunning = true;
        if (window.isRunning) {
            System.out.println("Window has been made!");
        } else if (!window.isRunning) {
            try {
                throw new Exception("Cannot run WINDOW as the file may be modified and not saved or may have been deleted");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}