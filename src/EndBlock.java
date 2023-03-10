import java.awt.*;

public class EndBlock extends CodeBlock {
    public EndBlock() {
        super(930, 870, 40, 40, Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2, y2);
    }
}
