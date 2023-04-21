package View;

import Model.Repository;
import Controller.Controller;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ListView extends JPanel implements Observer {
    public ListView(String user) {
        if(user.equalsIgnoreCase("student")) {
            studentListView();
        }
        else if (user.equalsIgnoreCase("teacher")) {
            teacherListView();
        }
    }

    private void studentListView() {
        Repository repository = Repository.getInstance();
        repository.addObserver(this);

        Controller controller = new Controller();
        JButton back = new JButton("Back");
        back.addActionListener(controller);
        JButton edit = new JButton("Solve");
        edit.addActionListener(controller);

        add(back);
        add(edit);
    }

    private void teacherListView() {
        Repository repository = Repository.getInstance();
        repository.addObserver(this);
        Controller controller = new Controller();
        JButton back = new JButton("Back");
        back.addActionListener(controller);
        JButton edit = new JButton("Edit");
        edit.addActionListener(controller);
        JButton newProblem = new JButton("New");
        newProblem.addActionListener(controller);

        add(back);
        add(edit);
        add(newProblem);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
