import Blocks.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawArea extends JPanel {
    private final List<CodeBlock> codeBlocks;
    private final Repository repository;

    public DrawArea() {
        this.repository = Repository.getInstance();
        Controller controller = new Controller(this);
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(300, 300));
        codeBlocks = new ArrayList<>();
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CodeBlock codeBlock : codeBlocks) {
            codeBlock.draw(g);
        }
    }

    public void drawStartEndPoints() {
        codeBlocks.add(new StartBlock());
        codeBlocks.add(new EndBlock(this.getWidth() - 60, this.getHeight() - 60));
    }

    public void drawBlock(int x, int y) {
        if (repository.getBlockToDraw().equalsIgnoreCase("condition block")) {
            codeBlocks.add(new ConditionBlock(x, y));
        } else if (repository.getBlockToDraw().equalsIgnoreCase("variable declaration block")) {
            codeBlocks.add(new VariableDeclarationBlock(x, y));
        } else if (repository.getBlockToDraw().equalsIgnoreCase("instruction block")) {
            codeBlocks.add(new InstructionBlock(x, y));
        } else if (repository.getBlockToDraw().equalsIgnoreCase("call method block")) {
            codeBlocks.add(new CallMethodBlock(x, y));
        } else if (repository.getBlockToDraw().equalsIgnoreCase("input/output block")) {
            codeBlocks.add(new InputOutputBlock(x, y));
        }
        repaint();
    }

    public void dragBlock(int x, int y) {
        //TODO: Have user drag begin and end blocks
        CodeBlock temp = null;
        for (CodeBlock codeBlock : codeBlocks) {
            if (codeBlock.contains(x, y)) {
                if (codeBlock instanceof InstructionBlock) {
                    temp = new InstructionBlock(x - 10, y - 10);
                    temp.setText(codeBlock.getText());
                } else if (codeBlock instanceof ConditionBlock) {
                    temp = new ConditionBlock(x - 10, y - 10);
                    temp.setText(codeBlock.getText());
                } else if (codeBlock instanceof VariableDeclarationBlock) {
                    temp = new VariableDeclarationBlock(x - 10, y - 10);
                    temp.setText(codeBlock.getText());
                } else if (codeBlock instanceof CallMethodBlock) {
                    temp = new CallMethodBlock(x - 10, y - 10);
                    temp.setText(codeBlock.getText());
                } else if (codeBlock instanceof InputOutputBlock) {
                    temp = new InputOutputBlock(x - 10, y - 10);
                    temp.setText(codeBlock.getText());
                }
                codeBlocks.add(temp);
                codeBlocks.remove(codeBlock);
                repaint();
                return;
            }
        }
    }

    public void addText(int x, int y) {
        for (CodeBlock codeBlock : codeBlocks) {
            if (codeBlock.contains(x, y)) {
                if (!(codeBlock instanceof StartBlock || codeBlock instanceof EndBlock)) {
                    String text = (String) JOptionPane.showInputDialog(
                            this,
                            "Name:",
                            "Enter Name",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            ""
                    );
                    codeBlock.setText(text);
                    repaint();
                    return;
                }
            }
        }
    }
}
