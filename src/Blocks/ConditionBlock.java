package Blocks;

import java.awt.*;

public class ConditionBlock extends CodeBlock {
    public ConditionBlock(int x, int y) {
        super(x, y, x + 150, y + 75, Color.CYAN);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
    }
}
