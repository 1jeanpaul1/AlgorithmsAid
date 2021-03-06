package View;

import javafx.scene.shape.Circle;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;

public class NodeGuiViewPanel extends JPanel implements IView {
    private List<Circle> CircleNodes = new ArrayList<>();
    private int[] loNodes;
    private String heapType; //Should probably change heapType from a String to an Enum

    //Size in pixels of the node
    private static final int FIRST_NODE_SIZE = 30;

    //Size of the integers inside the node
    private static final int FIRST_INTEGER_SIZE = (int) (FIRST_NODE_SIZE * 0.95);

    //Y Position of the nodes
    private static final int FIRST_ROW_Y_POSITION = 50;

    //X Position of the nodes
    private static final int FIRST_ROW_X_POSITION = 225;

    NodeGuiViewPanel(int[] loNodes, String heapType) {
        super();
        this.loNodes = loNodes;
        this.heapType = heapType; //Should probably change heapType from a String to an Enum
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawNodes(g);
    }

    /**
     * Draws all the Nodes together.
     * @param g Graphics.
     */
    private void drawNodes(Graphics g) {
        g.setColor(Color.lightGray);
        int currentRow = 1; //the current row that nodes are being added to, changes after a row is filled
        int currentRowSize = 1; //the count of how many nodes are in a row
        int currentRowMaxSize = 2;
        int currentNodeSize = (int) (FIRST_NODE_SIZE * 1.5); //changes depending on the row
        int currentYPosition = FIRST_ROW_Y_POSITION; //stays the same until it goes to the next row
        int currentXPositionDistribution = (int) (FIRST_ROW_X_POSITION * 3); //changes every time
        int currentXPosition = currentXPositionDistribution;
        int currentIntegerSize = FIRST_INTEGER_SIZE; //changes depending on the row,
        int parentYPosition = currentYPosition;
        int parentXPosition = currentXPosition;
        int parentXPositionDistribution = currentXPositionDistribution;
        int parentPositioningShift = 10;
        int IntegerPositionShifter = 5;
        String currentInteger = String.valueOf(loNodes[0]);
        Circle firstNode = new Circle(currentXPosition, currentYPosition, currentNodeSize);
        CircleNodes.add(firstNode);
        g.fillOval(currentXPosition, currentYPosition, currentNodeSize, currentNodeSize); //not too sure what will be produced from this
        g.setColor(Color.black);
        g.drawString(currentInteger, currentXPosition - 5, currentYPosition + 15);
        g.setColor(Color.lightGray);
        currentYPosition += 60;
        currentXPositionDistribution /= 2;
        currentXPosition = currentXPositionDistribution;
        for (int i = 1; i < loNodes.length; i++) {
            g.setColor(Color.lightGray);
            currentInteger = String.valueOf(loNodes[i]);
            if (currentRowSize % (currentRowMaxSize + 1) == 0) {
                parentXPositionDistribution = currentXPositionDistribution;
                parentXPosition = parentXPositionDistribution;
                parentYPosition = currentYPosition;
                currentRow ++;
                currentRowSize = 1;
                currentRowMaxSize *= 2;
                currentYPosition += 60;
                currentXPositionDistribution /= 2 ;
                currentXPosition = currentXPositionDistribution;
                currentIntegerSize *= currentIntegerSize;
                currentNodeSize *= 0.90;
            }
            Circle currentCircle = new Circle(currentXPosition, currentYPosition, currentNodeSize);
            CircleNodes.add(currentCircle);
            g.drawLine(parentXPosition + parentPositioningShift, parentYPosition+parentPositioningShift,
                    currentXPosition+parentPositioningShift, currentYPosition+parentPositioningShift);
            g.fillOval(currentXPosition, currentYPosition, currentNodeSize, currentNodeSize);
            g.setColor(Color.black);
            g.drawString(currentInteger, currentXPosition + IntegerPositionShifter, currentYPosition + 15);
            g.setColor(Color.LIGHT_GRAY);
            currentXPosition += (currentXPositionDistribution * 2);
            currentRowSize++;
            if (i % 2 == 0) {
                parentXPosition += ((parentXPositionDistribution * 2));
            }

        }
    }

    @Override
    public String getName() {
        return this.heapType;
    }

    public Dimension getPreferredSize() {
        return new Dimension(2000,580);
    }

}
