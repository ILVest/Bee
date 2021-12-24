import java.awt.*;
import java.util.*;

public class Bees extends Rectangle{

    // Fields
    private double x, xStart;
    private double y, yStart;
    private double dx;
    private double dy;
    public double side;
    public double speed;
    public int num;
    public double angle;
    public Color color;
    private static Bees[] bee;

    Random random;

    // Constructor
    public Bees() {
        random = new Random();
        color = Color.YELLOW;
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

    public double getSide() {
        return side;
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
        final double xField = Panel.WIDTH;
        final double yField = Panel.HEIGHT;
        switch (num){
            case 1: angle = (calculateAngle(xStart, yStart, xField, yField));
                break;
            case 2: angle = (calculateAngle(xStart, yStart, xField, 0));
                break;
            case 3: angle = (calculateAngle(xStart, yStart, 0, yField));
                break;
            case 4: angle = (calculateAngle(xStart, yStart, 0, 0));
                break;
        }
        return angle;
    }

    public void move() {
        x += dx;
        y += dy;
        if(x < xStart && dx < xStart) {
            dx = -dx;
        }
        if(x > Panel.WIDTH && dx > 0) {
            dx = -dx;
        }
        if(x < xStart && dx < xStart) {
            dx = -dx;
        }
        if(x > xStart && dx > xStart) {
            dx = -dx;
        }
        if(x < 0 && dx < 0) {
            dx = -dx;
        }
        if(y < yStart && dy < yStart) {
            dy = -dy;
        }
        if(y > Panel.HEIGHT && dy > 0) {
            dy = -dy;
        }
        if(y < yStart && dy < yStart) {
            dy = -dy;
        }
        if(y < 0 && dy < 0) {
            dy = -dy;
        }
        if((x==xStart)||(y==yStart)){
            dx=0;dy=0;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - side), (int) (y - side), (int) side, (int) side);
    }

    public static Bees[] getBees() {
        if(bee==null) {

            System.out.println("Введите количество пчел: ");
            Scanner in = new Scanner(System.in);
            int a=in.nextInt();
            bee= new Bees[a]; }
        for (int i = 0; i <bee.length ; i++) {
            bee[i]= new Bees();
        }
        return bee;
    }

}