package Blocks;

import java.awt.*;

public class VariableDeclarationBlock extends CodeBlock {
    public VariableDeclarationBlock(int x, int y) {
        super(x, y, x + 150, y + 75, Color.GREEN);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2 - x1, y2 - y1);
    }
}
