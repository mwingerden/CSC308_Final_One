import java.awt.*;

public class VariableDeclarationBlock extends CodeBlock {
    public VariableDeclarationBlock(int x, int y) {
        super(x, y, 150, 75, Color.CYAN);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
    }
}
