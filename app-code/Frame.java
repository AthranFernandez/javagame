import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame {

    //makes a window -[ JFRAME ] and initializes it

    public boolean isRunning = false;
    public int w = 500, h = 500;

    public JButton jbtn;
    public JFrame jfr;

    public void Win_init() {

        // CODE: JAVAFRAME

        jfr = new JFrame("Code");
        jfr.add(new Game());
        jfr.setSize(new Dimension(w, h));
        jfr.setLocationRelativeTo(null);
        jfr.setResizable(false); //new border
        jfr.setFocusableWindowState(true);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);

        // CODE: JAVABUTTON

        jbtn = new JButton("Adding Panel");
        jbtn.setBounds(50, 50, 80, 35);
        jbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                NewWindow();
            }

        });

        jfr.add(jbtn, BorderLayout.SOUTH);
        jbtn.setVisible(true);

         // CODE: AUDIO
         try {
            URL url = this.getClass().getClassLoader().getResource("music.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip c = AudioSystem.getClip();

            c.open(audioInputStream);
            c.loop(Clip.LOOP_CONTINUOUSLY);

            FloatControl floatControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            floatControl.setValue(-10.0f);

        } catch (UnsupportedAudioFileException uafe) {
            uafe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }

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