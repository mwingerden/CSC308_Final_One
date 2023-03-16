package Drawings.Blocks;

import Drawings.Draw;

import java.awt.*;

public abstract class CodeBlock implements Draw {
    private final int incomingArrowLimit;
    private final int outgoingArrowLimit;
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;
    protected String text;
    private int incomingArrowCount;
    private int outgoingArrowCount;

    public CodeBlock(int x1, int y1, int x2, int y2, int incomingArrowLimit, int outgoingArrowLimit, Color color, String text) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.incomingArrowLimit = incomingArrowLimit;
        this.outgoingArrowLimit = outgoingArrowLimit;
        this.color = color;
        this.text = text;
    }

    abstract public void draw(Graphics g);

    public boolean contains(int x, int y) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }


//    public boolean checkIncomingArrowLimit() {
//        if (incomingArrowCount < incomingArrowLimit) {
//            incomingArrowCount++;
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkOutgoingArrowLimit() {
//        if (outgoingArrowCount < outgoingArrowLimit) {
//            outgoingArrowCount++;
//            return true;
//        }
//        return false;
//    }
//
//    public void resetCount() {
//        incomingArrowCount = 0;
//        outgoingArrowCount = 0;
//    }

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
