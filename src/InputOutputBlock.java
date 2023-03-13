import java.awt.*;

public class InputOutputBlock extends CodeBlock {
    public InputOutputBlock(int x, int y) {
        super(x, y, 150, 75, Color.DARK_GRAY);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
    }
}
