package View;

import Drawings.Draw;
import Model.Repository;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DrawArea extends JPanel implements Observer {
    Repository repository;

    public DrawArea(String user) {
        if(user.equalsIgnoreCase("student")) {
            StudentDrawArea();
        }
        else if (user.equalsIgnoreCase("teacher")) {
            TeacherDrawArea();
        }
    }

    private void StudentDrawArea() {
        repository = Repository.getInstance();
        repository.addObserver(this);
        Controller controller = new Controller();
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(300, 300));
        addMouseListener(controller);
        addMouseMotionListener(controller);
        setLayout(new BorderLayout());
        add(new StatusBar(), BorderLayout.SOUTH);
        add(new MenuBar(), BorderLayout.NORTH);
    }

    private void TeacherDrawArea() {
        repository = Repository.getInstance();
        repository.addObserver(this);
        Controller controller = new Controller();
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(300, 300));
        addMouseListener(controller);
        addMouseMotionListener(controller);
        setLayout(new BorderLayout());
        add(new StatusBar(), BorderLayout.SOUTH);
        add(new MenuBar(), BorderLayout.NORTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Draw drawing : repository.getDrawings()) {
            drawing.draw(g);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
