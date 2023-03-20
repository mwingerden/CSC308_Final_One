package Drawings.Blocks;

import java.awt.*;

public class StartBlock extends CodeBlock {
    public StartBlock(int x, int y) {
        super(x, y, x + 75, y + 80, Color.WHITE, "Start", 0, 1);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2 - x1, y2 - y1);
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
        Font font = new Font("Helvetica", Font.PLAIN, 22);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(text, x1 + (((x2 - x1) - fm.stringWidth(text)) / 2),
                y1 + (((y2 - y1) - fm.getHeight()) / 2) + fm.getAscent());
    }
}
