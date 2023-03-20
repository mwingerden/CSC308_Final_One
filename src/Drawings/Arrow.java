package Drawings;

import Drawings.Blocks.CodeBlock;

import java.awt.*;
import java.awt.geom.Line2D;

public class Arrow implements Draw {
    private final CodeBlock block1;
    private final CodeBlock block2;

    public Arrow(CodeBlock block1, CodeBlock block2) {
        this.block1 = block1;
        this.block2 = block2;
    }

    @Override
    public void draw(Graphics g) {
        int x1 = block1.getX1() + ((block1.getX2() - block1.getX1()) / 2);
        int y1 = block1.getY1() + ((block1.getY2() - block1.getY1()) / 2);
        int x2 = block2.getX1() + ((block2.getX2() - block2.getX1()) / 2);
        int y2 = block2.getY1() + ((block2.getY2() - block2.getY1()) / 2);
        g.setColor(Color.BLACK);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(new Line2D.Float(x1, y1, x2, y2));

        //Draw ArrowHead
        double dy = y2 - y1;
        double dx = x2 - x1;
        double theta = Math.atan2(dy, dx);
        double phi = Math.toRadians(40);
        int barb = 20;
        double x, y, rho = theta + phi;
        Graphics2D g2 = (Graphics2D) g;
        for (int j = 0; j < 2; j++) {
            x = x1 + ((double) (x2 - x1) / 2) - barb * Math.cos(rho);
            y = y1 + ((double) (y2 - y1) / 2) - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(x1 + ((double) (x2 - x1) / 2), y1 + ((double) (y2 - y1) / 2), x, y));
            rho = theta - phi;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Arrow arrow)) {
            return false;
        }
        return (this.block1.equals(arrow.block1) && this.block2.equals(arrow.block2)) ||
                (this.block1.equals(arrow.block2) && this.block2.equals(arrow.block1));
    }

    public CodeBlock getBlock1() {
        return block1;
    }

    public CodeBlock getBlock2() {
        return block2;
    }
}
