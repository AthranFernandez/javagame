import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
* Author: Athran Fernandez
* Github-Files: github.com/AthranFernandez/javagame
*/

public class Game extends JPanel implements ActionListener, KeyListener {

    public int x = 0, y = 0, velx = 0, vely = 0;
    public boolean hitAnObject = false;
    public int spawnTime = 0;
    public Color c = Color.BLACK;
    Timer timer = new Timer(5, this);
    public JButton jButton;


    public Game() {
        timer.start();
        setBackground(Color.CYAN);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        Frame frame = new Frame();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillRect(x, y, 50, 50);
        g.drawString("X = " + x + "Y = " + y, 375, 25);

        // Random

        Random n = new Random();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(100, 100, 50, 49);
        if (g2.getClipBounds().intersects(g2d.getClipBounds())) {
            g2d.drawOval(n.nextInt(1, 443), n.nextInt(1, 432), 50, 49);
        }
        

    }

    public void actionPerformed(ActionEvent ae) {
        x += velx;
        y += vely;
        repaint();
    }

    public void left() {
        velx = -5;
        vely = vely + 0;
    }

    public void right() {
        velx = 5;
        vely = vely + 0;
    }

    public void up() {
        vely = -5;
        velx = velx + 0;
    }

    public void down() {
        vely = 5;
        velx = velx + 0;
    }
    public void stopMovement_UP() {
        vely = 0;
        velx = velx + 0;
    }
    public void stopMovement_DOWN() {
        vely = 0;
        velx = velx + 0;
    }
    public void stopMovement_LEFT() {
        velx = 0;
        vely = vely + 0;
    }
    public void stopMovement_RIGHT() {
        velx = 0;
        vely = vely + 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            left();
            if (x < 0) {
                x = 0;
            }
        }
        else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            right();
            if (x > 443)  {
                velx = 0;
                x = 443;
            }
        }
        else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            down();
            if (y > 386) {
                vely = 0;
                y = 386;            
            }
        }
        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            up();
            if (y < 0) {
                y = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { 
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            stopMovement_LEFT();
            if (x < 0) {
                x = 0;
            }
        }
        else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            stopMovement_RIGHT();
            if (x > 443) {
                velx = 0;
                x = 443;
            }
        }
        else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            stopMovement_DOWN();
            if (y > 386) {
                vely = 0;
                y = 386;
            }
        }
        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            stopMovement_UP();
            if (y < 0) {
                y = 0;
            }
        }
        
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.getBackground();
    }

}