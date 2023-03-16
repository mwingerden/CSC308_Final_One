import Drawings.Blocks.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Repository extends Observable {
    private static final Repository instance = new Repository();
    String blockToDraw;
    private List<CodeBlock> drawings;
    private String currentDrawing;

    private Repository() {
        this.blockToDraw = "";
        this.drawings = new ArrayList<>();
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
        drawings = Load.load(name);
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
        setChanged();
        notifyObservers(currentDrawing);
    }

    public List<CodeBlock> getDrawings() {
        return drawings;
    }

    public void addBlock(int x, int y) {
//        if (currentDrawing.equalsIgnoreCase("arrow")) {
//            if (arrow.getBlocksSize() == 2) {
//                arrow = new Arrow();
//            }
//            for (Draw drawing : drawings) {
//                if (drawing instanceof CodeBlock) {
//                    if (drawing.contains(x, y)) {
//                        arrow.addBlock((CodeBlock) drawing);
//                    }
//                }
//            }
//            if (arrow.getBlocksSize() == 2) {
//                drawings.add(0, arrow);
//            }
//        } else {
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
//        }
        setChanged();
        notifyObservers(currentDrawing);
    }

    public void dragBlock(int x, int y) {
        CodeBlock temp = null;
        for (CodeBlock drawing : drawings) {
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
                setChanged();
                notifyObservers("Dragging " + currentDrawing);
                return;
            }
        }
    }

    public void addText(int x, int y) {
        for (CodeBlock drawings : drawings) {
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
                    drawings.setText(text);
                    setChanged();
                    notifyObservers("Set Text to " + currentDrawing);
                    return;
                }
            }
        }
    }

//    public static Repository getInstance() {
//        return instance;
//    }
//
//    public void newList() {
//        drawings.clear();
//        setChanged();
//        notifyObservers("new");
//    }
//
//    public void saveList() {
//        String name = (String) JOptionPane.showInputDialog(
//                new DrawArea(),
//                "Type Name for the Save File:",
//                "Save File",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                ""
//        );
//        Save.save(drawings, name);
//        setChanged();
//        notifyObservers("save");
//    }
//
//    public void loadList() {
//        String name = (String) JOptionPane.showInputDialog(
//                new DrawArea(),
//                "Enter Name to Load File:",
//                "Enter Name",
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                null,
//                ""
//        );
//        drawings = Load.load(name);
//        setChanged();
//        notifyObservers("load");
//    }
//
//    public void undo() {
//        drawings.remove(drawings.size() - 1);
//    }
//
//    public void about() {
//        System.out.println("Print About Page.");
//    }
//
//    public void setCurrentDrawing(String currentDrawing) {
//        this.currentDrawing = currentDrawing;
//        setChanged();
//        notifyObservers(currentDrawing);
//    }
//
//    public List<Draw> getDrawings() {
//        return drawings;
//    }
//
//    public void addBlock(int x, int y) {
//        if (currentDrawing.equalsIgnoreCase("arrow")) {
//            if (arrow.getBlocksSize() == 2) {
//                arrow = new Arrow();
//            }
//            for (Draw drawing : drawings) {
//                if (drawing instanceof CodeBlock) {
//                    if (drawing.contains(x, y)) {
//                        arrow.addBlock((CodeBlock) drawing);
//                    }
//                }
//            }
//            if (arrow.getBlocksSize() == 2) {
//                drawings.add(0, arrow);
//            }
//        } else {
//            if (currentDrawing.equalsIgnoreCase("condition block")) {
//                drawings.add(new ConditionBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("variable declaration block")) {
//                drawings.add(new VariableDeclarationBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("instruction block")) {
//                drawings.add(new InstructionBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("call method block")) {
//                drawings.add(new CallMethodBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("input/output block")) {
//                drawings.add(new InputOutputBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("start block")) {
//                drawings.add(new StartBlock(x, y));
//            } else if (currentDrawing.equalsIgnoreCase("end block")) {
//                drawings.add(new EndBlock(x, y));
//            }
//        }
//        setChanged();
//        notifyObservers(currentDrawing);
//    }
//
//    public void dragBlock(int x, int y) {
//        CodeBlock temp = null;
//        for (Draw drawing : drawings) {
//            if (drawing.contains(x, y)) {
//                if (drawing instanceof InstructionBlock) {
//                    temp = new InstructionBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof ConditionBlock) {
//                    temp = new ConditionBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof VariableDeclarationBlock) {
//                    temp = new VariableDeclarationBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof CallMethodBlock) {
//                    temp = new CallMethodBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof InputOutputBlock) {
//                    temp = new InputOutputBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof StartBlock) {
//                    temp = new StartBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof EndBlock) {
//                    temp = new EndBlock(x - 10, y - 10);
//                    temp.setText(drawing.getText());
//                } else if (drawing instanceof Arrow) {
//                    for(Draw codeBlock : drawings) {
//                        if(codeBlock instanceof CodeBlock) {
//
//                        }
//                    }
//                }
//                drawings.add(temp);
//                drawings.remove(drawing);
//                setChanged();
//                notifyObservers("Dragging " + currentDrawing);
//                return;
//            }
//        }
//    }
//
//    public void addText(int x, int y) {
//        for (Draw drawings : drawings) {
//            if (drawings.contains(x, y)) {
//                if (!(drawings instanceof StartBlock || drawings instanceof EndBlock)) {
//                    String text = (String) JOptionPane.showInputDialog(
//                            new DrawArea(),
//                            "Name:",
//                            "Enter Name",
//                            JOptionPane.PLAIN_MESSAGE,
//                            null,
//                            null,
//                            ""
//                    );
//                    drawings.setText(text);
//                    setChanged();
//                    notifyObservers("Set Text to " + currentDrawing);
//                    return;
//                }
//            }
//        }
//    }
}
