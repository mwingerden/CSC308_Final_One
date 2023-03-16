package Drawings.Blocks;

import java.awt.*;

public class CallMethodBlock extends CodeBlock {
    public CallMethodBlock(int x, int y) {
        super(x, y, x + 150, y + 75, 1, 1, Color.CYAN, "");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
        g.drawString(text, x1, y1);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(x1 + 10, y1, x1 + 10, y2);
        g2D.drawLine(x2 - 10, y1, x2 - 10, y2);
    }
}
