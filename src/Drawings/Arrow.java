package Drawings;

import Drawings.Blocks.CodeBlock;

import java.awt.*;
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

    public void addBlock(CodeBlock block) {
        if (codeBlocks.size() == 1) {
            if (!block.equals(codeBlocks.get(0))) {
                codeBlocks.add(block);
            }
        } else {
            codeBlocks.add(block);
        }
        if(codeBlocks.size() == 2) {
            CodeBlock first = codeBlocks.get(0);
            CodeBlock second = codeBlocks.get(1);
            this.x1 = first.getX1() + ((first.getX2() - first.getX1()) / 2);
            this.y1 = first.getY1() + ((first.getY2() - first.getY1()) / 2);
            this.x2 = second.getX1();
            this.y2 = second.getY1() + ((second.getY2() - second.getY1()) / 2);
        }
    }

    public int getBlocksSize() {
        return codeBlocks.size();
    }

    public List<CodeBlock> getCodeBlocks() {
        return codeBlocks;
    }
}
