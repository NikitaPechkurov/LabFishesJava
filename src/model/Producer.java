package model;

import java.awt.*;

public class Producer extends Thread{
    private int x, y;
    private int dx, dy;
    private int radius;
    private Component container;
    private Color color;
    private int heig, weig;
    //private Tunell tul;


    public Producer(int x, int y, int dx, int dy, int radius,
                Component container, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.container = container;
        this.color = color;
        //this.tul = tul;
    }

    synchronized public boolean step() {//корм прилипает направо и вниз, надо только вниз
        //x += dx;
        y += dy;
        if (x >= container.getWidth() - radius) {
            x = container.getWidth() - radius;
            return false;
        }
        if (y >= container.getHeight() - radius) {
            y = container.getHeight() - radius;
            return false;
        }
        if (x < radius) {
            x = radius;
            dx = -dx;
        }
        if (y < radius) {
            y = radius;
            dy = -dy;
        }
        return true;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void run() {
        heig = container.getHeight();
        weig = container.getHeight();

        while (step()) {
            container.repaint();
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                return;
            }
        }
        /*if (tul.IsTunell())
        synchronized(tul) {
            container.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                return;
            }
        }*/

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
