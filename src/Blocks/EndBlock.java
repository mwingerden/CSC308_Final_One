package Blocks;

import java.awt.*;

public class EndBlock extends CodeBlock {
    public EndBlock(int width, int height) {
        super(width, height, 60, 60, Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2, y2);
        g.setColor(Color.WHITE);
        g.drawString("End", x1 + 15, y1 + 30);
    }
}
