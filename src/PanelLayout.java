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
        add(new DrawArea(), "DrawArea");
        add(new TeacherView(), "Teacher");
        add(new StudentView(), "Student");
    }

    @Override
    public void update(Observable o, Object arg) {
        String panel = (String) arg;
        if (panel.equalsIgnoreCase("teacher")) {
            CardLayout cl = (CardLayout)(this.getLayout());
            cl.show(this, panel);
        } else if (panel.equalsIgnoreCase("student")) {
            CardLayout cl = (CardLayout)(this.getLayout());
            cl.show(this, panel);
        } else if (panel.equalsIgnoreCase("back")) {
            CardLayout cl = (CardLayout)(this.getLayout());
            cl.show(this, "StartUp");
        } else if (panel.equalsIgnoreCase("solve") || panel.equalsIgnoreCase("edit") ||
                   panel.equalsIgnoreCase("new")) {
            CardLayout cl = (CardLayout)(this.getLayout());
            cl.show(this, "DrawArea");
        }
    }
}
