import View.PanelLayout;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setLayout(new CardLayout());

        add(new PanelLayout(), BorderLayout.CENTER);

        setTitle("Intelligent Tutoring System");
        setSize(900, 900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}