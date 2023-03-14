package Blocks;

import java.awt.*;

public interface Draw {
    void draw(Graphics g);

    boolean contains(int x, int y);

    String getText();

    void setText(String text);
}
