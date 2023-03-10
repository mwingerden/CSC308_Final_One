import java.awt.*;

public class IfBlock extends CodeBlock {
    public IfBlock(int x, int y, int width, int height) {
        super(x, y, width, height, Color.YELLOW);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(Math.min(x2, x1), Math.min(y2, y1), (x2 > x1) ? x2 - x1 : x1 - x2, (y2 > y1) ? y2 - y1 : y1 - y2);
        g.setColor(Color.BLACK);
        g.drawString("If", (x2 + x1) / 2, (y2 + y1) / 2);
    }
}
