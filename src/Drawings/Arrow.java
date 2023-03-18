package Drawings;

import Drawings.Blocks.CodeBlock;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Arrow implements Draw {
    private final Color color;
    private final List<CodeBlock> codeBlocks;
    private String text;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Arrow() {
        this.codeBlocks = new ArrayList<>();
        this.color = Color.BLACK;
        this.text = "";
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new Line2D.Float(x1, y1, x2, y2));
        Polygon arrowHead = new Polygon();
        AffineTransform tx = new AffineTransform();
        arrowHead.addPoint(0, 5);
        arrowHead.addPoint(-5, -5);
        arrowHead.addPoint(5, -5);
        tx.setToIdentity();
        double angle = Math.atan2(y2 - y1, x2 - x1);
        tx.translate(x1 + ((double) (x2 - x1) / 2), y1 + ((double) (y2 - y1) / 2));
        tx.rotate((angle - Math.PI / 2d));
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setTransform(tx);
        g2d.fill(arrowHead);
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

    public void addBlock(Draw drawing) {
        CodeBlock block = (CodeBlock) drawing;
        if (codeBlocks.size() == 1) {
            if (!block.equals(codeBlocks.get(0))) {
                codeBlocks.add(block);
                CodeBlock first = codeBlocks.get(0);
                CodeBlock second = codeBlocks.get(1);
                this.x1 = first.getX1() + ((first.getX2() - first.getX1()) / 2);
                this.y1 = first.getY1() + ((first.getY2() - first.getY1()) / 2);
                this.x2 = second.getX1() + ((second.getX2() - second.getX1()) / 2);
                this.y2 = second.getY1() + ((second.getY2() - second.getY1()) / 2);
            }
        } else {
            codeBlocks.add(block);
        }
    }

    public int getBlocksSize() {
        return codeBlocks.size();
    }

    public List<CodeBlock> getCodeBlocks() {
        return codeBlocks;
    }

    public void clearCodeBlocks() {
        codeBlocks.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Arrow arrow)) {
            return false;
        }
        return (arrow.color == this.color && arrow.x1 == this.x1 && arrow.y1 == this.y1
                && arrow.x2 == this.x2 && arrow.y2 == this.y2 && arrow.text.equals(this.text)) ||
                (arrow.color == this.color && arrow.x1 == this.x2 && arrow.y1 == this.y2
                        && arrow.x2 == this.x1 && arrow.y2 == this.y1 && arrow.text.equals(this.text));
    }
}
