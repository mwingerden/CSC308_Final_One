import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener, MouseListener, MouseMotionListener {
    private final Repository repository;

    public Controller() {
        this.repository = Repository.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("new")) {
            repository.newList();
        } else if (e.getActionCommand().equalsIgnoreCase("save")) {
            repository.saveList();
        } else if (e.getActionCommand().equalsIgnoreCase("load")) {
            repository.loadList();
        } else if (e.getActionCommand().equalsIgnoreCase("undo")) {
            repository.undo();
        } else if (e.getActionCommand().equalsIgnoreCase("about")) {
            repository.about();
        } else {
            repository.setCurrentDrawing(e.getActionCommand());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            repository.addText(e.getX(), e.getY());
        } else {
            repository.addDrawing(e.getX(), e.getY());
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
            repository.dragBlock(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
