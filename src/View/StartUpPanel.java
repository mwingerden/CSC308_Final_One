package View;

import Model.Repository;
import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class StartUpPanel extends JPanel implements Observer {
    Repository repository;

    public StartUpPanel() {
        repository = Repository.getInstance();
        repository.addObserver(this);
        Controller controller = new Controller();
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(300, 300));
        JButton teacher = new JButton("Teacher");
        teacher.addActionListener(controller);
        JButton student = new JButton("Student");
        student.addActionListener(controller);
        add(teacher);
        add(student);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
