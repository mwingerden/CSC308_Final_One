package View;

import Model.Repository;
import Controller.Controller;
import javax.swing.*;
import java.io.File;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class ListView extends JPanel implements Observer {
    Controller controller = new Controller();
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

        JButton back = new JButton("Back");
        back.addActionListener(controller);
        JButton edit = new JButton("Solve");
        edit.addActionListener(controller);

        createProblemList();

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

        createProblemList();

        add(back);
        add(edit);
        add(newProblem);
    }

    private void createProblemList() {
        ButtonGroup group = new ButtonGroup();
        JRadioButton jRadioButton;
        File dir = new File("./DrawingJSONFiles");

        for(File file : Objects.requireNonNull(dir.listFiles())) {
            String [] name = file.getName().split("\\.");
            jRadioButton = new JRadioButton(name[0]);
            group.add(jRadioButton);
            jRadioButton.addActionListener(controller);
            add(jRadioButton);
        }
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
