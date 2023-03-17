package Drawings.Blocks;

import java.awt.*;

public class EndBlock extends CodeBlock {
    public EndBlock(int x, int y) {
        super(x, y, x + 75, y + 75, 1, 0, Color.BLACK, "End");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2 - x1, y2 - y1);
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.WHITE);
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
        Font font = new Font("Helvetica", Font.PLAIN, 22);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        g.drawString(text, x1 + (((x2 - x1) - fm.stringWidth(text)) / 2),
                y1 + (((y2 - y1) - fm.getHeight()) / 2) + fm.getAscent());
    }
}
