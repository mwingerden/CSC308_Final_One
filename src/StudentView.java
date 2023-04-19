import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class StudentView extends JPanel implements Observer {
    public StudentView() {
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

    @Override
    public void update(Observable o, Object arg) {

    }
}
