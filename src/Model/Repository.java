package Model;

import Drawings.Arrow;
import Drawings.Blocks.*;
import Drawings.Draw;
import View.DrawArea;

import javax.swing.*;
import java.util.*;

public class Repository extends Observable {
    private static final Repository instance = new Repository();
    CodeBlock first;
    CodeBlock second;
    int clickCount = 0;
    private List<Draw> drawings;
    private String currentDrawing;

    private Repository() {
        this.drawings = new ArrayList<>();
        this.currentDrawing = "";
    }

    public static Repository getInstance() {
        return instance;
    }

    public void newList() {
        clickCount = 0;
        drawings.clear();
        setChanged();
        notifyObservers("new");
    }

    public void updatePanel(String panel) {
        setChanged();
        notifyObservers(panel);
    }

    public void saveList() {
        String name = (String) JOptionPane.showInputDialog(
                new DrawArea("teacher"),
                "Type Name for the Model.Save File:",
                "Model.Save File",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );
        if (name != null) {
            clickCount = 0;
            Save.save(drawings, name);
            setChanged();
            notifyObservers("save");
        }
    }

    public void loadList(String name) {
//        String name = (String) JOptionPane.showInputDialog(
//                new DrawArea("teacher"),
//                "Enter Name to Model.Load File:",
//                "Enter Name",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                ""
//        );
//        if (name != null) {
//            clickCount = 0;
//            drawings.clear();
//            drawings = Load.load(name);
//            setChanged();
//            notifyObservers("load");
//        }
        drawings = Load.load(name);
    }

    public void undo() {
        if (!drawings.isEmpty()) {
            drawings.remove(drawings.size() - 1);
            setChanged();
            notifyObservers("Undo");
        }
    }

    public void about() {
        System.out.println("Print About Page.");
    }

    public void setCurrentDrawing(String currentDrawing) {
        clickCount = 0;
        this.currentDrawing = currentDrawing;
//        sortList();
        setChanged();
        notifyObservers(currentDrawing);
    }

    public List<Draw> getDrawings() {
        return sortList();
    }

    public void addDrawing(int x, int y) {
        if (currentDrawing.equalsIgnoreCase("arrow")) {
            addArrow(x, y);
        } else {
            addBlock(x, y);
        }
//        sortList();
        setChanged();
        notifyObservers(currentDrawing);
    }

    private void addBlock(int x, int y) {
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

    private void addArrow(int x, int y) {
        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock && ((CodeBlock) drawing).contains(x, y)) {
                if (clickCount <= 0) {
                    first = (CodeBlock) drawing;
                    if (first.checkOutgoingArrowLimit()) {
                        clickCount++;
                    }
                    break;
                } else if (clickCount == 1) {
                    second = (CodeBlock) drawing;
                    if (second.checkIncomingArrowLimit()) {
                        clickCount++;
                    }
                    break;
                }
            }
        }

        if (clickCount == 2) {
            Arrow newArrow = new Arrow(first, second);
            for (Draw drawing : drawings) {
                if (drawing instanceof Arrow arrow) {
                    if (newArrow.equals(arrow)) {
                        return;
                    }
                }
            }
            first.increaseOutgoingArrowCount();
            second.increaseIncomingArrowCount();
            drawings.add(newArrow);
            clickCount = 0;
        }
    }

    public void drag(int x, int y) {
        CodeBlock blockToDrag = null;
        int dragX;
        int dragY;

        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock && ((CodeBlock) drawing).contains(x, y)) {
                blockToDrag = (CodeBlock) drawing;
            }
        }

        if (blockToDrag != null) {
            dragX = ((blockToDrag.getX2() - blockToDrag.getX1()) / 2);
            dragY = ((blockToDrag.getY2() - blockToDrag.getY1()) / 2);
            if (blockToDrag instanceof InstructionBlock) {
                dragging(blockToDrag, new InstructionBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof ConditionBlock) {
                dragging(blockToDrag, new ConditionBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof VariableDeclarationBlock) {
                dragging(blockToDrag, new VariableDeclarationBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof CallMethodBlock) {
                dragging(blockToDrag, new CallMethodBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof InputOutputBlock) {
                dragging(blockToDrag, new InputOutputBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof StartBlock) {
                dragging(blockToDrag, new StartBlock(x - dragX, y - dragY));
            } else if (blockToDrag instanceof EndBlock) {
                dragging(blockToDrag, new EndBlock(x - dragX, y - dragY));
            }
        }
        setChanged();
        notifyObservers("Dragging");
    }

    private void dragging(CodeBlock block, CodeBlock newBlock) {
        List<Draw> tempList = new ArrayList<>(drawings);
        newBlock.setText(block.getText());
        for (Draw temp1 : tempList) {
            if (temp1 instanceof Arrow arrow) {
                if (arrow.getBlock1().equals(block)) {
                    drawings.add(new Arrow(newBlock, arrow.getBlock2()));
                    drawings.remove(arrow);
                } else if (arrow.getBlock2().equals(block)) {
                    drawings.add(new Arrow(arrow.getBlock1(), newBlock));
                    drawings.remove(arrow);
                }
            }
        }
        drawings.remove(block);
        drawings.add(newBlock);
    }

    public void addText(int x, int y) {
        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock && ((CodeBlock) drawing).contains(x, y)) {
                if (!(drawing instanceof StartBlock || drawing instanceof EndBlock)) {
                    String text = (String) JOptionPane.showInputDialog(
                            new DrawArea("teacher"),
                            "Name:",
                            "Enter Name",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            ""
                    );
                    if (text != null) {
                        ((CodeBlock) drawing).setText(text);
                        setChanged();
                        notifyObservers("Set Text to " + currentDrawing);
                    }
                    return;
                }
            }
        }
    }

    private List<Draw> sortList() {
        List<Draw> newDrawings = new ArrayList<>();
        List<CodeBlock> codeBlocks = new ArrayList<>();
        List<Arrow> arrows = new ArrayList<>();

        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock) {
                codeBlocks.add((CodeBlock) drawing);
            } else if (drawing instanceof Arrow) {
                arrows.add((Arrow) drawing);
            }
        }
        newDrawings.addAll(arrows);
        newDrawings.addAll(codeBlocks);
        return newDrawings;
    }
}
