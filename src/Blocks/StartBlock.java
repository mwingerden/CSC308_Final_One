package Blocks;

import java.awt.*;

public class StartBlock extends CodeBlock {
    public StartBlock() {
        super(0, 0, 60, 60, Color.WHITE);
        setText("Begin");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        g.drawString(text, x1 + 15, (y2 + y1) / 2);
    }
}
