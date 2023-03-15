import javax.swing.*;
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
        repository.updateOption(e.getActionCommand());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            drawArea.addText(e.getX(), e.getY());
        } else {
            drawArea.drawBlock(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            drawArea.dragBlock(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
