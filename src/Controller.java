import java.awt.event.*;

public class Controller implements ActionListener, MouseListener, MouseMotionListener {
    private final DrawArea drawArea;
    private final Repository repository;

    public Controller(DrawArea drawArea) {
        this.drawArea = drawArea;
        this.repository = Repository.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            System.out.println("New Selected");
        } else if (e.getActionCommand().equals("Save")) {
            System.out.println("Save Selected");
        } else if (e.getActionCommand().equals("Load")) {
            System.out.println("Load Selected");
        } else if (e.getActionCommand().equals("About")) {
            System.out.println("About Selected");
        } else {
            repository.setBlockToDraw(e.getActionCommand());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        drawArea.drawBlock(e.getX(), e.getY());
//        List<CodeBlock> codeBlocks = drawArea.getCodeBlocks();
//        for(CodeBlock codeBlock : codeBlocks) {
//            if(e.getX() > codeBlock.getX1() && e.getX() < codeBlock.getX2()
//                    && e.getY() > codeBlock.getY1() && e.getY() < codeBlock.getY2()) {
//                if(codeBlock.getColor() == Color.BLUE) {
//                    System.out.println("Command Block Test");
//                }
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        drawArea.drawBlock(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        drawArea.setX2Y2(e.getX(), e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        drawArea.dragging(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
