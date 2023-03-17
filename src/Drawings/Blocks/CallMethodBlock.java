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
        Font font = new Font("Helvetica", Font.PLAIN, 22);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(text, x1 + (((x2 - x1) - fm.stringWidth(text)) / 2),
                y1 + (((y2 - y1) - fm.getHeight()) / 2) + fm.getAscent());
        g.drawLine(x1 + 10, y1, x1 + 10, y2);
        g.drawLine(x2 - 10, y1, x2 - 10, y2);
    }
}
