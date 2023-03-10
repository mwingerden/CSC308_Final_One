import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawArea extends JPanel {
    private List<CodeBlock> codeBlocks;

    public DrawArea() {
        setBackground(Color.PINK);
        codeBlocks = new ArrayList<>();
        codeBlocks.add(new StartBlock());
        codeBlocks.add(new EndBlock());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(CodeBlock codeBlock : codeBlocks) {
            codeBlock.draw(g);
        }
    }
}
