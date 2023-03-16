package Drawings;

import java.awt.*;

public interface Draw {
    void draw(Graphics g);

    boolean contains(int x, int y);

    String getText();

    void setText(String text);

    int getX1();

    int getY1();

    int getX2();

    int getY2();
}
