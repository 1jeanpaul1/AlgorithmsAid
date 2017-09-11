package View;

import java.awt.*;

/**
 * Interface for all the Heap Views.
 */
public interface IView {

    /**
     * Gets and returns the name of the current Heap.
     * @return Heap name.
     */
    String getName();

    /**
     * @return Dimensions for the screen
     */
    Dimension getPreferredSize();

    /**
     * Needed to draw everything.
     * @param g Graphics
     */
    void paintComponent(Graphics g);
}
