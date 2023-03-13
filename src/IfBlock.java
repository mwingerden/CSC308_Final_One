import java.awt.*;

public class IfBlock extends CodeBlock {
    public IfBlock(int x, int y) {
        super(x, y, 150,75, Color.YELLOW);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
//        g.setColor(Color.BLACK);
//        g.drawString("If", (x2 + x1) / 2, (y2 + y1) / 2);
    }
}
