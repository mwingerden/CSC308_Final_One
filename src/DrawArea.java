import Drawings.Blocks.*;
import Drawings.Draw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DrawArea extends JPanel implements Observer {
    private List<Draw> drawings;
    private String currentDrawing;

    public DrawArea() {
        Repository repository = Repository.getInstance();
        repository.addObserver(this);
        this.currentDrawing = "";
        Controller controller = new Controller(this);
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(300, 300));
        drawings = new ArrayList<>();
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Draw drawing : drawings) {
            drawing.draw(g);
        }
    }

//    public void drawStartEndPoints() {
//        //TODO: Have user draw the blocks instead of drawing it for them.
//        drawings.add(new StartBlock(0, 0));
//        drawings.add(new EndBlock(this.getWidth() - 60, this.getHeight() - 60));
//    }

    public void drawBlock(int x, int y) {
        if (currentDrawing.equalsIgnoreCase("arrow")) {
//            for(Draw drawing : drawings) {
//                if(drawing instanceof CodeBlock) {
//                    if(drawing.contains(x, y)) {
//
//                    }
//                }
//            }
        } else {
            if (currentDrawing.equalsIgnoreCase("condition block")) {
                drawings.add(new ConditionBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("variable declaration block")) {
                drawings.add(new VariableDeclarationBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("instruction block")) {
                drawings.add(new InstructionBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("call method block")) {
                drawings.add(new CallMethodBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("input/output block")) {
                drawings.add(new InputOutputBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("start block")) {
                drawings.add(new StartBlock(x, y));
            } else if (currentDrawing.equalsIgnoreCase("end block")) {
                drawings.add(new EndBlock(x, y));
            }
            repaint();
        }
    }

    public void dragBlock(int x, int y) {
        CodeBlock temp = null;
        for (Draw drawing : drawings) {
            if (drawing.contains(x, y)) {
                if (drawing instanceof InstructionBlock) {
                    temp = new InstructionBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof ConditionBlock) {
                    temp = new ConditionBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof VariableDeclarationBlock) {
                    temp = new VariableDeclarationBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof CallMethodBlock) {
                    temp = new CallMethodBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof InputOutputBlock) {
                    temp = new InputOutputBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof StartBlock) {
                    temp = new StartBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                } else if (drawing instanceof EndBlock) {
                    temp = new EndBlock(x - 10, y - 10);
                    temp.setText(drawing.getText());
                }
                drawings.add(temp);
                drawings.remove(drawing);
                repaint();
                return;
            }
        }
    }

    public void addText(int x, int y) {
        for (Draw drawings : drawings) {
            if (drawings.contains(x, y)) {
                if (!(drawings instanceof StartBlock || drawings instanceof EndBlock)) {
                    String text = (String) JOptionPane.showInputDialog(
                            this,
                            "Name:",
                            "Enter Name",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            ""
                    );
                    drawings.setText(text);
                    repaint();
                    return;
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        String option = (String) arg;
        String name;
        if (option.equalsIgnoreCase("new")) {
            clearArea();
        } else if (option.equalsIgnoreCase("save")) {
            name = (String) JOptionPane.showInputDialog(
                    this,
                    "Type Name for the Save File:",
                    "Save File",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    ""
            );
            Save.save(drawings, name);
        } else if (option.equalsIgnoreCase("load")) {
            name = (String) JOptionPane.showInputDialog(
                    this,
                    "Enter Name to Load File:",
                    "Enter Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    ""
            );
            clearArea();
            drawings = Load.load(name);
            repaint();
        } else {
            currentDrawing = option;
        }
    }

    private void clearArea() {
        drawings.clear();
        repaint();
    }
}
