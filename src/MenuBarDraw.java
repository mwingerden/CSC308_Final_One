import javax.swing.*;

public class MenuBarDraw extends JMenuBar {
    public MenuBarDraw() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu block = new JMenu("Code Block");
        JMenu help = new JMenu("Help");

        JMenuItem newOption = new JMenuItem("New");
        JMenuItem saveOption = new JMenuItem("Save");
        JMenuItem loadOption = new JMenuItem("Load");
        JMenuItem ifBlockOption = new JMenuItem("If Block");
        JMenuItem aboutOption = new JMenuItem("About");

        file.add(newOption);
        file.add(saveOption);
        file.add(loadOption);
        block.add(ifBlockOption);
        help.add(aboutOption);

        menuBar.add(file);
        menuBar.add(block);
        menuBar.add(help);
        add(menuBar);
    }
}
