package Drawings.Blocks;

import Drawings.Draw;

import java.awt.*;

public abstract class CodeBlock implements Draw {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;
    protected String text;

    public CodeBlock(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getX1() {
        return x1;
    }

    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public int getX2() {
        return x2;
    }

    @Override
    public int getY2() {
        return y2;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeBlock block)) {
            return false;
        }
        return block.color == this.color && block.x1 == this.x1 && block.y1 == this.y1
                && block.x2 == this.x2 && block.y2 == this.y2 && block.text.equals(this.text);
    }

}
