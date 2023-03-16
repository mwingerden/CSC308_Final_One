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
        if (!drawings.isEmpty()) {
            drawings.remove(drawings.size() - 1);
            sortList();
            setChanged();
            notifyObservers("Undo");
        }
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
//        Collections.reverse(drawings);
        CodeBlock blockToDrag = null;
        int dragX;
        int dragY;
        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock && drawing.contains(x, y)) {
                blockToDrag = (CodeBlock) drawing;
            }
        }
        if (blockToDrag != null) {
            dragX = ((blockToDrag.getX2() - blockToDrag.getX1()) / 2);
            dragY = ((blockToDrag.getY2() - blockToDrag.getY1()) / 2);
            if (blockToDrag instanceof InstructionBlock) {
                drag(blockToDrag, new InstructionBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof ConditionBlock) {
                drag(blockToDrag, new ConditionBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof VariableDeclarationBlock) {
                drag(blockToDrag, new VariableDeclarationBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof CallMethodBlock) {
                drag(blockToDrag, new CallMethodBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof InputOutputBlock) {
                drag(blockToDrag, new InputOutputBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof StartBlock) {
                drag(blockToDrag, new StartBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof EndBlock) {
                drag(blockToDrag, new EndBlock(x - dragX, y - dragY));
            }
        }
        sortList();
        setChanged();
        notifyObservers("Dragging " + currentDrawing);
    }

    private void drag(Draw drawing, CodeBlock newBlock) {
//        sortList();
        List<Draw> placeHolder = new ArrayList<>(drawings);
        newBlock.setText(drawing.getText());
        drawings.add(newBlock);
        drawings.remove(drawing);
        for (Draw temp : placeHolder) {
            if (temp instanceof Arrow draggingArrow) {
                List<CodeBlock> arrowCodeBlocks = draggingArrow.getCodeBlocks();
                if (!(arrowCodeBlocks.size() == 2)) {
                    break;
                }
                int count = 1;
                for (CodeBlock codeBlock : arrowCodeBlocks) {
                    if (codeBlock.equals(drawing)) {
                        drawings.remove(draggingArrow);
                        CodeBlock temp1 = arrowCodeBlocks.get(count);
                        draggingArrow.clearCodeBlocks();
//                        temp1.resetCount();
                        draggingArrow.addBlock(newBlock);
                        draggingArrow.addBlock(temp1);
                        drawings.add(draggingArrow);
                        break;
                    } else {
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
        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock) {
                codeBlockList.add(drawing);
            } else if (drawing instanceof Arrow) {
                arrowList.add(drawing);
            }
        }
        drawings.clear();
        drawings.addAll(arrowList);
        drawings.addAll(codeBlockList);
    }
}
