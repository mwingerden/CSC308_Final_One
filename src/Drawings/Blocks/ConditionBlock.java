package Drawings.Blocks;

import java.awt.*;
import java.awt.geom.Path2D;

public class ConditionBlock extends CodeBlock {
    public ConditionBlock(int x, int y) {
        super(x, y, x + 150, y + 75, 2, 2, Color.green, "");
        text = "";
    }

    @Override
    public void draw(Graphics g) {
        Path2D.Double parallelogram = new Path2D.Double();
        parallelogram.moveTo(x1 + ((double) (x2 - x1) / 2), y1);
        parallelogram.lineTo(x2, y1 + ((double) (y2 - y1) / 2));
        parallelogram.lineTo(x1 + ((double) (x2 - x1) / 2), y2);
        parallelogram.lineTo(x1, y1 + ((double) (y2 - y1) / 2));
        parallelogram.closePath();
        g.setColor(color);
        Graphics2D g2D = (Graphics2D) g;
        g2D.fill(parallelogram);
        g.setColor(Color.BLACK);
        g2D.draw(parallelogram);
        g.setColor(Color.BLACK);
        g.drawString(text, x1, y1);
    }
}
