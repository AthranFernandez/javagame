import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    //makes a window -[ JFRAME ] and initializes it

    public boolean isRunning = false;
    public int w = 500, h = 500;

    public JButton jbtn;

    public void Win_init() {
        add(new Game());
        setSize(new Dimension(w, h));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        jbtn = new JButton("Adding Panel");
        jbtn.setBounds(50, 50, 80, 35);
        jbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                NewWindow();
            }
            
        });

        add(jbtn, BorderLayout.SOUTH);
        jbtn.setVisible(true);

    }

    public void NewWindow() {
        JFrame f = new JFrame("Add Existing Item");
        f.setSize(new Dimension(450, 650));  
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray);
        f.setVisible(true);
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