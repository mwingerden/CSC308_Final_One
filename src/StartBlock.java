import java.awt.*;

public class StartBlock extends CodeBlock {
    public StartBlock() {
        super(10, 10, 40, 40, Color.WHITE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2, y2);
    }
}
