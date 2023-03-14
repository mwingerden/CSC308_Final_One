package Drawings.Blocks;

import java.awt.*;

public class InstructionBlock extends CodeBlock {
    public InstructionBlock(int x, int y) {
        super(x, y, x + 150, y + 75, Color.RED);
        setText("");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
        g.setColor(Color.BLACK);
        g.drawString(text, x1, y1);
    }
}
