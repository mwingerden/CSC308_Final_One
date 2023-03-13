import java.awt.*;

public class CallMethodBlock extends CodeBlock {
    public CallMethodBlock(int x, int y) {
        super(x, y, 150, 75, Color.ORANGE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
    }
}
