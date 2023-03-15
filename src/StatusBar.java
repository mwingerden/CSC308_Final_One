import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class StatusBar extends JPanel implements Observer {
    private final JTextField progressbar;

    public StatusBar() {
        Repository repository = Repository.getInstance();
        repository.addObserver(this);
        setLayout(new BorderLayout());
        progressbar = new JTextField("Temp");
        progressbar.setEditable(false);
        add(progressbar, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        String option = (String) arg;
        if (option.equalsIgnoreCase("new")) {
            progressbar.setText("Created New Board");
        } else if (option.equalsIgnoreCase("save")) {
            progressbar.setText("Saved Board");
        } else if (option.equalsIgnoreCase("load")) {
            progressbar.setText("Loaded a Board");
        } else if (option.equalsIgnoreCase("about")) {
            progressbar.setText("Opened About Page");
        } else if (option.equalsIgnoreCase("start block")) {
            progressbar.setText("Drawing Start Block");
        } else if (option.equalsIgnoreCase("end block")) {
            progressbar.setText("Drawing End Block");
        } else if (option.equalsIgnoreCase("call method block")) {
            progressbar.setText("Drawing Call Method Block");
        } else if (option.equalsIgnoreCase("instruction block")) {
            progressbar.setText("Drawing Instruction Block");
        } else if (option.equalsIgnoreCase("input/output block")) {
            progressbar.setText("Drawing Input/Output Block");
        } else if (option.equalsIgnoreCase("variable declaration block")) {
            progressbar.setText("Drawing Variable Declaration Block");
        } else if (option.equalsIgnoreCase("condition block")) {
            progressbar.setText("Drawing Condition Block");
        } else if (option.equalsIgnoreCase("arrow")) {
            progressbar.setText("Drawing Arrows");
        }
    }
}
