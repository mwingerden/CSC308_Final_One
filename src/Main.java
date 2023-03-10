import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setLayout(new BorderLayout());

        setJMenuBar(new MenuBarDraw());
        add(new ProgressBar(), BorderLayout.SOUTH);
        add(new DrawArea(), BorderLayout.CENTER);

        setTitle("Final Project");
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}