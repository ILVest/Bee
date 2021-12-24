import java.awt.*;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Drones extends Rectangle{

    // Fields
    private double x, dx, xStart;
    private double y, dy, yStart;
    private Thread thread;
    public double side;
    public double speed;
    public int num;
    public double angle;
    public Color color;
    private static Drones[] drone;

    static Random random;

    // Constructor
    public Drones() {
        random = new Random();
        color = Color.WHITE;
        xStart = (Math.random() * (Panel.WIDTH - 300)) + 150;
        yStart = (Math.random() * (Panel.HEIGHT - 300)) + 150;
        x = xStart;
        y = yStart;
        side = (int) 10;
        speed = (int) 2;
        num = (int) ((Math.random() * 4) + 1);
        angle = Math.toRadians(getAngle(xStart, yStart, num, angle));
        dx = Math.sin(angle) * speed;
        dy = Math.cos(angle) * speed;
    }

    // Functions
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public static double calculateAngle(double x1, double y1, double x2, double y2)
    {
        double angle = Math.toDegrees(Math.atan2(x2 - x1, y2 - y1));
// Keep angle between 0 and 360
        angle = angle + Math.ceil( -angle / 360 ) * 360;

        return angle;
    }

    public static double getAngle(double xStart, double yStart, int num, double angle)
    {
        random = new Random();
        final double xField = Math.random()*600 + 1;
        final double yField = Math.random()*600 + 1;
        angle = (calculateAngle(xStart, yStart, xField, yField));
        return angle;
    }


    public void move1() {

        x += dx;
        y += dy;
        if (x < xStart && dx < xStart) {
            dx = -dx;
        }
        if (x > Panel.WIDTH && dx > 0) {
            dx = -dx;
        }
        if (x < xStart && dx < xStart) {
            dx = -dx;
        }
        if (x > xStart && dx > xStart) {
            dx = -dx;
        }
        if (x < 0 && dx < 0) {
            dx = -dx;
        }
        if (y < yStart && dy < yStart) {
            dy = -dy;
        }
        if (y > Panel.HEIGHT && dy > 0) {
            dy = -dy;
        }
        if (y < yStart && dy < yStart) {
            dy = -dy;
        }
        if (y < 0 && dy < 0) {
            dy = -dy;
        }
    }

    public void draw1(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - side), (int) (y - side), (int) side, (int) side);
    }

    public static Drones[] getDrones() {
        if(drone == null) {
            System.out.println("Введите количество трутней: ");
            Scanner in = new Scanner(System.in);
            int a=in.nextInt();
            drone = new Drones[a]; }
        for (int i = 0; i <drone.length ; i++) {
            drone[i]= new Drones();
        }
        return drone;
    }
}