package View;

import Model.Repository;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PanelLayout extends JPanel implements Observer {
    Repository repository;

    public PanelLayout() {
        repository = Repository.getInstance();
        repository.addObserver(this);
        Controller controller = new Controller();
        addMouseListener(controller);
        addMouseMotionListener(controller);
        setLayout(new CardLayout());
        add(new StartUpPanel(), "StartUp");
        add(new DrawArea("teacher"), "TeacherDrawArea");
        add(new DrawArea("student"), "StudentDrawArea");
        add(new ListView("teacher"), "TeacherList");
        add(new ListView("student"), "StudentList");
    }

    @Override
    public void update(Observable o, Object arg) {
        String panel = (String) arg;
        CardLayout cl = (CardLayout)(this.getLayout());
        if (panel.equalsIgnoreCase("new") || panel.equalsIgnoreCase("edit")) {
            cl.show(this, "TeacherDrawArea");
        }
        else if (panel.equalsIgnoreCase("solve")) {
            cl.show(this, "StudentDrawArea");
        }
        else {
            cl.show(this, panel);
        }
    }
}
