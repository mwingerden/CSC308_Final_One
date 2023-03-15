import Drawings.Blocks.*;
import Drawings.Draw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DrawArea extends JPanel implements Observer {
    private final List<Draw> drawings;
    private final Repository repository;

    public DrawArea() {
        this.repository = Repository.getInstance();
        repository.addObserver(this);
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
        if (repository.getBlockToDraw().equalsIgnoreCase("arrow")) {
//            for(Draw drawing : drawings) {
//                if(drawing instanceof CodeBlock) {
//                    if(drawing.contains(x, y)) {
//
//                    }
//                }
//            }
        } else {
            if (repository.getBlockToDraw().equalsIgnoreCase("condition block")) {
                drawings.add(new ConditionBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("variable declaration block")) {
                drawings.add(new VariableDeclarationBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("instruction block")) {
                drawings.add(new InstructionBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("call method block")) {
                drawings.add(new CallMethodBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("input/output block")) {
                drawings.add(new InputOutputBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("start block")) {
                drawings.add(new StartBlock(x, y));
            } else if (repository.getBlockToDraw().equalsIgnoreCase("end block")) {
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
        if (option.equalsIgnoreCase("new")) {
            clearArea();
        }
//        else if(option.equalsIgnoreCase("save")) {
//
//        }
    }

    private void clearArea() {
        drawings.clear();
        repaint();
    }

//    private void save() {
//
//    }
//
//    private void load() {
//
//    }

}
