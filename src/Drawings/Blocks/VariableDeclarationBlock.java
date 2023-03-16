package Drawings.Blocks;

import java.awt.*;

public class VariableDeclarationBlock extends CodeBlock {
    public VariableDeclarationBlock(int x, int y) {
        super(x, y, x + 150, y + 75, 1, 1, Color.LIGHT_GRAY, "");
        text = "";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(x1, y1 + 10, x2, y1 + 10);
        g2D.drawLine(x1 + 10, y1, x1 + 10, y2);
        g.drawString(text, x1, y1);
    }
}
