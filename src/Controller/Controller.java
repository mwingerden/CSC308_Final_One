package Controller;

import javax.swing.*;
import java.awt.event.*;
import Model.Repository;

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
//        } else if (e.getActionCommand().equalsIgnoreCase("load")) {
//            repository.loadList();
        }
        else if (e.getActionCommand().equalsIgnoreCase("undo")) {
            repository.undo();
        } else if (e.getActionCommand().equalsIgnoreCase("about")) {
            repository.about();
        } else if (e.getActionCommand().equalsIgnoreCase("Teacher")) {
            repository.updatePanel("TeacherList");
        } else if (e.getActionCommand().equalsIgnoreCase("Student")) {
            repository.updatePanel("StudentList");
        } else if (e.getActionCommand().equalsIgnoreCase("Back")) {
            repository.updatePanel("StartUp");
        } else if (e.getActionCommand().equalsIgnoreCase("solve")) {
            repository.updatePanel("StudentDrawArea");
        }
        else if (e.getActionCommand().equalsIgnoreCase("edit") || e.getActionCommand().equalsIgnoreCase("new")) {
            repository.updatePanel("TeacherDrawArea");
        } else if (e.getActionCommand().indexOf("Problem") == 0){
            repository.loadList(e.getActionCommand());
        }
        else {
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
            repository.drag(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
