import Drawings.Arrow;
import Drawings.Blocks.*;
import Drawings.Draw;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Repository extends Observable {
    private static final Repository instance = new Repository();
    private List<Draw> drawings;
    private String currentDrawing;
    private Arrow arrow;

    private Repository() {
        this.drawings = new ArrayList<>();
        this.currentDrawing = "";
        this.arrow = new Arrow();
    }

    public static Repository getInstance() {
        return instance;

    }

    public void newList() {
        drawings.clear();
        setChanged();
        notifyObservers("new");
    }

    public void saveList() {
        String name = (String) JOptionPane.showInputDialog(
                new DrawArea(),
                "Type Name for the Save File:",
                "Save File",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );
        Save.save(drawings, name);
        setChanged();
        notifyObservers("save");
    }

    public void loadList() {
        String name = (String) JOptionPane.showInputDialog(
                new DrawArea(),
                "Enter Name to Load File:",
                "Enter Name",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );
        drawings.clear();
        drawings = Load.load(name);
        sortList();
        setChanged();
        notifyObservers("load");
    }

    public void undo() {
        drawings.remove(drawings.size() - 1);
    }

    public void about() {
        System.out.println("Print About Page.");
    }

    public void setCurrentDrawing(String currentDrawing) {
        this.currentDrawing = currentDrawing;
        sortList();
        setChanged();
        notifyObservers(currentDrawing);
    }

    public List<Draw> getDrawings() {
        return drawings;
    }

    public void addDrawing(int x, int y) {
        if (currentDrawing.equalsIgnoreCase("arrow")) {
            if (arrow.getBlocksSize() == 2) {
                arrow = new Arrow();
            }
            for (Draw drawing : drawings) {
                if (drawing instanceof CodeBlock) {
                    if (drawing.contains(x, y)) {
                        arrow.addBlock((CodeBlock) drawing);
                    }
                }
            }
            if (arrow.getBlocksSize() == 2) {
                drawings.add(arrow);
            }
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
        }
        sortList();
        setChanged();
        notifyObservers(currentDrawing);
    }

    public void dragBlock(int x, int y) {
        List<Draw> placeHolder = new ArrayList<>(drawings);
        for (Draw drawing : placeHolder) {
            if (drawing.contains(x, y)) {
                if (drawing instanceof InstructionBlock) {
                    drag(drawing, new InstructionBlock(x - 10, y -10));
                } else if (drawing instanceof ConditionBlock) {
                    drag(drawing, new ConditionBlock(x - 10, y -10));
                } else if (drawing instanceof VariableDeclarationBlock) {
                    drag(drawing, new VariableDeclarationBlock(x - 10, y -10));
                } else if (drawing instanceof CallMethodBlock) {
                    drag(drawing, new CallMethodBlock(x - 10, y -10));
                } else if (drawing instanceof InputOutputBlock) {
                    drag(drawing, new InputOutputBlock(x - 10, y -10));
                } else if (drawing instanceof StartBlock) {
                    drag(drawing, new StartBlock(x - 10, y -10));
                } else if (drawing instanceof EndBlock) {
                    drag(drawing, new EndBlock(x - 10, y -10));
                }
            }
        }
        sortList();
        setChanged();
        notifyObservers("Dragging " + currentDrawing);
    }

    private void drag(Draw drawing, CodeBlock newBlock) {
        List<Draw> placeHolder = new ArrayList<>(drawings);
        newBlock.setText(drawing.getText());
        drawings.add(newBlock);
        drawings.remove(drawing);
        for (Draw temp : placeHolder) {
            if (temp instanceof Arrow draggingArrow) {
                List<CodeBlock> arrowCodeBlocks = draggingArrow.getCodeBlocks();
                int count = 1;
                for (CodeBlock codeBlock : arrowCodeBlocks) {
                    if (codeBlock.equals(drawing)) {
                        drawings.remove(draggingArrow);
                        CodeBlock temp1 = arrowCodeBlocks.get(count);
                        draggingArrow.clearCodeBlocks();
                        draggingArrow.addBlock(newBlock);
                        draggingArrow.addBlock(temp1);
                        drawings.add(draggingArrow);
                        break;
                    }
                    else {
                        count--;
                    }
                }
            }
        }
    }

    public void addText(int x, int y) {
        for (Draw drawings : drawings) {
            if (drawings.contains(x, y)) {
                if (!(drawings instanceof StartBlock || drawings instanceof EndBlock)) {
                    String text = (String) JOptionPane.showInputDialog(
                            new DrawArea(),
                            "Name:",
                            "Enter Name",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            ""
                    );
                    sortList();
                    drawings.setText(text);
                    setChanged();
                    notifyObservers("Set Text to " + currentDrawing);
                    return;
                }
            }
        }
    }

    private void sortList() {
        List<Draw> codeBlockList = new ArrayList<>();
        List<Draw> arrowList = new ArrayList<>();
        for(Draw drawing : drawings) {
            if(drawing instanceof CodeBlock) {
                codeBlockList.add(drawing);
            }
            else if(drawing instanceof Arrow) {
                arrowList.add(drawing);
            }
        }
        drawings.clear();
        drawings.addAll(arrowList);
        drawings.addAll(codeBlockList);
    }
}
