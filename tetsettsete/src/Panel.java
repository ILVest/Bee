import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    // Field
    static final int WIDTH = 400;
    static final int HEIGHT = 400;

    private Image image;
    private Graphics graphics;

    public static Drones[] drone;
    public static Bees[] bee;

    // Constructor
    public Panel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        bee = Bees.getBees();
        drone = Drones.getDrones();

        (new Thread(this)).start();
    }

    // Functions
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);

    }

    public void draw(Graphics g) {
        for (int i = 0; i < bee.length; i++) {
            bee[i].draw(g);
        }
        for (int i = 0; i < drone.length; i++) {
            drone[i].draw1(g);
        }
    }


    public void move() {
        for (int i = 0; i < bee.length; i++) {
            bee[i].move();
        }

    }
    public void move1() {
        for (int i = 0; i < drone.length; i++) {
            drone[i].move1();
        }

    }


    @Override
    public void run() {
// Game Loop

        long lastTime = System.nanoTime();
        double ns = 1000000000 / 60.0;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                move1();
                move();
                repaint();
                delta--;
            }
        }
    }
}