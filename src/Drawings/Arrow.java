package Drawings;

import java.awt.*;
import java.awt.geom.Line2D;

public class Arrow implements Draw {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;
    private String text;

    public Arrow(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = Color.BLACK;
        this.text = "";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getX1() {
        return this.x1;
    }

    @Override
    public int getY1() {
        return this.y1;
    }

    @Override
    public int getX2() {
        return this.x2;
    }

    @Override
    public int getY2() {
        return this.y2;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
