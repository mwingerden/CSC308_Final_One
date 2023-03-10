import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JPanel {
    public ProgressBar() {
        setLayout(new BorderLayout());
        JTextField progressbar = new JTextField("Temp");
        progressbar.setEditable(false);
        add(progressbar, BorderLayout.CENTER);
    }
}
