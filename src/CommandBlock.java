import java.awt.*;

public class CommandBlock extends CodeBlock {
    public CommandBlock(int x, int y) {
        super(x, y, 150,75, Color.GREEN);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1, y1, x2, y2);
//        g.setColor(Color.BLACK);
//        g.drawString("Command", (x2 + x1) / 2, (y2 + y1) / 2);
    }
}
