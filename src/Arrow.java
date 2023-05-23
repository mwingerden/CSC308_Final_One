
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
/**
 * This class is responsible for representing and drawing the arrow between two blocks.
 */
public class Arrow implements Draw {
    Block block1;
    Block block2;
    double phi;
    int barb;
    /**
     * This constructor method takes both block 1 and block 2 as parameters.
     *
     * @param shape1, the first incoming block
     * @param shape2, the second incoming block
     */
    public Arrow(Block shape1, Block shape2) {
        this.block1 = shape1;
        this.block2 = shape2;
        this.phi = Math.toRadians(40);
        this.barb = 20;
    }
    /**
     * The draw method draws the arrow by grabbing the center coordinates of both blocks.
     *
     * @param g, Graphics class
     */
    @Override
    public void draw(Graphics g) {
//        super.paintComponent(g);
//        int x1 = inBlock.getCenterX();
//        int y1 = inBlock.getCenterY();
//        int x2 = outBlock.getCenterX();
//        int y2 = outBlock.getCenterY();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
//        int w = inBlock.getCenterX() - outBlock.getCenterX();
//        int h = inBlock.getCenterY() - outBlock.getCenterY();
        Point p1 = new Point(block1.getCenterX(), block1.getCenterY());
        Point p2 = new Point(block2.getCenterX(), block2.getCenterY());
        g2.draw(new Line2D.Double(p1, p2));
        drawArrowHead(g2, p1, p2);
//        g.drawLine(x1, y1, x2, y2);
//        int centerX = (x1 + x2) / 2;
//        int centerY = (y1 + y2) / 2;
//        g.setColor(Color.BLACK);
//        g.fillPolygon(new int[] {centerX, centerX - 20, centerX + 20},
//                new int[] {centerY, centerY - 20, centerY + 20}, 3);

        //draw pointing part
//        int centerx = (x1 + x2) / 2;
//        int centery = (y1 + y2) / 2;
//        AffineTransform tx = new AffineTransform();
//        Polygon arrowHead = new Polygon();
//        arrowHead.addPoint(0, 20);
//        arrowHead.addPoint(-20, -20);
//        arrowHead.addPoint(20, -20);
//        tx.setToIdentity();
//        double angle = Math.atan2(y2 - y1, x2 - x1);
//        tx.translate(centerx * 2, centery * 2);
//        tx.rotate((angle - Math.PI / 2d));
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setTransform(tx);
//        g2.fill(arrowHead);
    }

    private void drawArrowHead(Graphics2D g2, Point p1, Point p2)
    {
        g2.setColor(Color.BLACK);
        double dy = p2.y - p1.y;
        double dx = p2.x - p1.x;
        double centerX = (double) ((p2.x - p1.x) / 2) + p1.x;
        double centerY = (double) ((p2.y - p1.y) / 2) + p1.y;
        double theta = Math.atan2(dy, dx);
        //System.out.println("theta = " + Math.toDegrees(theta));
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = centerX - barb * Math.cos(rho);
            y = centerY - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(centerX, centerY, x, y));
            rho = theta - phi;
        }
    }

    /**
     * getter method to return incoming block.
     * @return inBlock
     */
    Block getBlock2(){
        return this.block2;
    }
    /**
     * getter method to return outcoming block.
     * @return outBlock
     */
    Block getBlock1(){
        return this.block1;
    }
    /**
     * getter method to return the codeBlocks.
     * @return codeBlocks
     */
    ArrayList<Block> getCodeBlocks(){
        ArrayList<Block> codeBlocks =  new ArrayList<>();
        codeBlocks.add(block2);
        codeBlocks.add(block1);
        return codeBlocks;
    }
}
