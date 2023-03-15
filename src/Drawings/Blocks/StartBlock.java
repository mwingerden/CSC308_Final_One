package Drawings.Blocks;

import java.awt.*;

public class StartBlock extends CodeBlock {
    public StartBlock(int x, int y) {
        super(x, y, x + 60, y + 60, Color.WHITE);
        text = "Begin";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);
        g.drawString(text, x1 + 15, (y2 + y1) / 2);
    }
}
