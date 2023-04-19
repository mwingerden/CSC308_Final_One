import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class TeacherView extends JPanel implements Observer {
    public TeacherView() {
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
