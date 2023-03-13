import java.awt.*;

public class InstructionBlock extends CodeBlock {
    public InstructionBlock(int x, int y) {
        super(x, y, 150, 75, Color.GREEN);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
    }
}
