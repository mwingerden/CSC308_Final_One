import java.awt.*;

public class CommandBlock extends CodeBlock {
    public CommandBlock(int x, int y, int width, int height) {
        super(x, y, Math.max(width, x + 50), Math.max(height, y + 50), Color.BLUE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(Math.min(x2, x1), Math.min(y2, y1), (x2 > x1) ? x2 - x1 : x1 - x2, (y2 > y1) ? y2 - y1 : y1 - y2);
        g.setColor(Color.BLACK);
        g.drawString("Command", (x2 + x1) / 2, (y2 + y1) / 2);
    }
}
