package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class PanelPaint extends Canvas{

    public CopyOnWriteArrayList<Ball> ball = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Producer> producers = new CopyOnWriteArrayList<>();
    //public Ball[] ball = new Ball[3];
    //public Tunell tul;

    /*public PanelPaint (){
        super();
        setBackground(Color.BLUE);
        //tul = new Tunell (200, 300, this, Color.RED);
        ball[0] = new Ball(15, 50,  1, 1, 15, this, Color.YELLOW);
        ball[1] = new Ball(10, 100,  2, 1, 10, this, Color.GREEN);
        ball[2] = new Ball(20, 150,  3, 1, 20, this, Color.RED);
    }*/

    public PanelPaint(int n,int n1){
        super();
        setBackground(Color.BLUE);
        for (int i = 0; i < n1; i++){
            int r1 = 5;
            producers.add(new Producer(rnd(r1,(1000-r1)),r1*2,rnd(1,5),rnd(1,5),r1,this,Color.BLACK));
            //y у producer был rnd(r1,(600-r1)).Стал только r1
        }
        for (int i = 0; i < n; i++){
            int r = rnd(15,40);
            ball.add(new Ball(rnd(r,(1000-r)),rnd(r,(600-r)),rnd(-5,5),rnd(-5,5),r,this,randomColor(),producers));
        }
    }

    private static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private Color randomColor(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Ball b: ball)
            b.paint(g);
        for (Producer p: producers)
            p.paint(g);
    }

}