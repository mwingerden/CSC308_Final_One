import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        //fefe
        setLayout(new BorderLayout());
        DrawArea drawArea = new DrawArea();

        setJMenuBar(new MenuBarDraw());
        add(new StatusBar(), BorderLayout.SOUTH);
        add(drawArea, BorderLayout.CENTER);

        setTitle("Final Project");
        setSize(900, 900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}