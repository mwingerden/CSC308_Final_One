import javax.swing.*;

public class MenuBarDraw extends JMenuBar {
    public MenuBarDraw() {
        JMenuBar menuBar = new JMenuBar();
        Controller controller = new Controller(null);

        JMenu file = new JMenu("File");
        JMenu block = new JMenu("Code Block");
        JMenu help = new JMenu("Help");

        JMenuItem newOption = new JMenuItem("New");
        JMenuItem saveOption = new JMenuItem("Save");
        JMenuItem loadOption = new JMenuItem("Load");
        JMenuItem variableDeclarationOption = new JMenuItem("Variable Declaration Block");
        JMenuItem ifBlockOption = new JMenuItem("If Block");
        JMenuItem commandBlockOption = new JMenuItem("Command Block");
        JMenuItem aboutOption = new JMenuItem("About");

        file.add(newOption);
        newOption.addActionListener(controller);
        file.add(saveOption);
        saveOption.addActionListener(controller);
        file.add(loadOption);
        loadOption.addActionListener(controller);
        block.add(variableDeclarationOption);
        variableDeclarationOption.addActionListener(controller);
        block.add(ifBlockOption);
        ifBlockOption.addActionListener(controller);
        block.add(commandBlockOption);
        commandBlockOption.addActionListener(controller);
        help.add(aboutOption);
        aboutOption.addActionListener(controller);

        menuBar.add(file);
        menuBar.add(block);
        menuBar.add(help);
        add(menuBar);
    }
}
