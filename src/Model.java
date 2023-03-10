import javax.swing.*;
import java.awt.*;

public class Model extends JFrame {

    public Model() {
        setLayout(new BorderLayout());

        setJMenuBar(new MenuBarDraw());
        add(new ProgressBar(), BorderLayout.SOUTH);
        add(new DrawArea(), BorderLayout.CENTER);

        setTitle("Final Project");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Model();
    }
}