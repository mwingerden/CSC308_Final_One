package View;

import javax.swing.*;
import Controller.Controller;

public class MenuBarDraw extends JMenuBar {
    public MenuBarDraw() {
        JMenuBar menuBar = new JMenuBar();
        Controller controller = new Controller();

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenu block = new JMenu("Draw");

        JMenuItem newOption = new JMenuItem("New");
        JMenuItem saveOption = new JMenuItem("Model.Save");
        JMenuItem loadOption = new JMenuItem("Model.Load");

        JMenuItem startOption = new JMenuItem("Start Block");
        JMenuItem endOption = new JMenuItem("End Block");
        JMenuItem callMethodOption = new JMenuItem("Call Method Block");
        JMenuItem instructionOption = new JMenuItem("Instruction Block");
        JMenuItem inputOutputOption = new JMenuItem("Input/Output Block");
        JMenuItem variableDeclarationOption = new JMenuItem("Variable Declaration Block");
        JMenuItem conditionOption = new JMenuItem("Condition Block");
        JMenuItem ArrowOption = new JMenuItem("Arrow");

        JMenuItem aboutOption = new JMenuItem("About");

        file.add(newOption);
        newOption.addActionListener(controller);
        file.add(saveOption);
        saveOption.addActionListener(controller);
        file.add(loadOption);
        loadOption.addActionListener(controller);

        block.add(startOption);
        startOption.addActionListener(controller);
        block.add(endOption);
        endOption.addActionListener(controller);
        block.add(callMethodOption);
        callMethodOption.addActionListener(controller);
        block.add(instructionOption);
        instructionOption.addActionListener(controller);
        block.add(inputOutputOption);
        inputOutputOption.addActionListener(controller);
        block.add(variableDeclarationOption);
        variableDeclarationOption.addActionListener(controller);
        block.add(conditionOption);
        conditionOption.addActionListener(controller);
        block.add(ArrowOption);
        ArrowOption.addActionListener(controller);


        help.add(aboutOption);
        aboutOption.addActionListener(controller);
        JButton undo = new JButton("Undo");
        undo.addActionListener(controller);

        JButton back = new JButton("Back");
        back.addActionListener(controller);

        menuBar.add(file);
        menuBar.add(help);
        menuBar.add(block);
        menuBar.add(undo);
        add(menuBar);
    }
}
