package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ball extends Thread {

    private int x, y;
    private int dx, dy;
    private int radius;
    private Component container;
    private Color color;
    private int heig, weig;
    private CopyOnWriteArrayList<Producer> producers;
    //private Tunell tul;


    public Ball(int x, int y, int dx, int dy, int radius,
                Component container, Color color, CopyOnWriteArrayList<Producer> producers) {
        super();
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.container = container;
        this.color = color;
        this.producers = producers;
        //this.tul = tul;
    }

    synchronized public boolean step() {
        x += dx;
        y += dy;
        if(x + dx > container.getWidth()-radius || x + dx < radius) {
            dx = -dx;
        }

        if(y + dy > container.getHeight()-radius || y + dy < radius) {
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
                for (int i=0;i < producers.size(); i++) {
                    if ((producers.get(i).getX() >= x) && (producers.get(i).getX() <= x+2*radius)){
                        if ((producers.get(i).getY() >= y) && (producers.get(i).getY() <= y+2*radius)){
                            producers.get(i).stop();
                            producers.remove(i);
                            radius += 2;
                        }
                    }
                }
                Thread.sleep(40);
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
}