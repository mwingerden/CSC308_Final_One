package Drawings.Blocks;

import java.awt.*;
import java.awt.geom.Path2D;

public class InputOutputBlock extends CodeBlock {
    public InputOutputBlock(int x, int y) {
        super(x, y, x + 150, y + 75, Color.RED, "");
        text = "";
    }

    @Override
    public void draw(Graphics g) {
        Path2D.Double parallelogram = new Path2D.Double();
        parallelogram.moveTo(x1 + 25, y1);
        parallelogram.lineTo(x2, y1);
        parallelogram.lineTo(x2 - 25, y2);
        parallelogram.lineTo(x1, y2);
        parallelogram.closePath();
        g.setColor(color);
        Graphics2D g2D = (Graphics2D) g;
        g2D.fill(parallelogram);
        g.setColor(Color.BLACK);
        g2D.draw(parallelogram);
        g.setColor(Color.BLACK);
        Font font = new Font("Helvetica", Font.PLAIN, 22);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(text, x1 + (((x2 - x1) - fm.stringWidth(text)) / 2),
                y1 + (((y2 - y1) - fm.getHeight()) / 2) + fm.getAscent());
    }
}
