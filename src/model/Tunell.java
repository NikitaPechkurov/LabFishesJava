package model;

import java.awt.*;

public class Tunell {

    private int x, y;
    private int dx, dy;
    private Component container;
    private Color color;

    public Tunell(int dx, int dy, Component container, Color color) {
        x = container.getWidth() / 2 - dx / 2;
        y = container.getHeight() / 2 - dy / 2;
        this.dx = dx;
        this.dy = dy;
        this.container = container;
        this.color = color;
    }

    public void paint(Graphics g) {
        x = container.getWidth() / 2 - dx / 2;
        y = container.getHeight() / 2 - dy / 2;
        g.setColor(color);
        g.fillRect(x, y, dx, dy);
    }

    public boolean IsTunell(int x1, int y1) {
        if (x1 > x && x1 < (x + dx) && y1 > y && y1 < (y + dy)) return true;
        else return false;
    }
}