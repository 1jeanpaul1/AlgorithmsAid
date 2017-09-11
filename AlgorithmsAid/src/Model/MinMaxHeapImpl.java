package Model;


import com.sun.tools.javac.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtorre on 7/16/17.
 */


/**
 * Array Logic: (the nodes will be stored in an array)
 * Parent(i) = i/2
 * LEFT(i) = 2i
 * RIGHT(i) = 2i+1
 */

/**
 * MinHeapImpl implements the ITree interface
 * Min-Heap model representation
 * All the logic behind how Min-Heap works if here.
 */
public class MinMaxHeapImpl implements ITree{
    //Tip: Always set your variables to private!! You don't want to give any other part of your code access to it.

    private int SIZELIMIT = 200;//Don't really have a use for the size limit at the moment, but it's nice to have it
    //there in case I want to make a size limit. Maybe I'll make only a size limit for the View.
    private int[] nodes;//MINHEAP/MAXHEAP will be represented in an array
    private int currentIndex = 1; //currentIndex will be used to keep track of where a node should be inserted.
    private boolean minOrMax;

    /**
     * MINHEAP = TRUE
     * MAXHEAP = FALSE
     * @param min if its a MINHEAP then min will be TRUE. If its a MAXHEAP then it will be FALSE
     */
    public MinMaxHeapImpl(boolean min) {
        this.nodes = new int[SIZELIMIT];
        this.minOrMax = min;
    }

    @Override
    /**
     * inserts the given node to the currentIndex
     */
    public void insert(int node) {
        try {
            if (currentIndex == SIZELIMIT) {
                throw new IllegalArgumentException("You've reached the size limit, I congratulate your curious mind");
            } else {
                nodes[currentIndex] = node;
                heapafy(); //heapafy function will reorder the tree
                updateCurrentIndex();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * deletes the first node it finds with the given value
     * @param node
     */
    @Override
    public void delete(int node) {
        throw new IllegalArgumentException("Functionality coming soon");
    }

    @Override
    /**
     * Overrides the toString Method. Uses the currentNodesConsole method. Parent Mode
     * is set to true.
     */
    public String toString() {
        return currentNodesConsole(true);
    }

    /**
     * Gets the current index of the nodes.
     * @return the currentIndex
     */
    private int getCurrentIndex() {
        return currentIndex;
    }

    private int getCurrentParentIndex() {
        return currentIndex / 2;
    }

    /**
     * updates the current index
     */
    private void updateCurrentIndex() {
        currentIndex += 1;
    }


    /**
     * Will return the first number of equal value as user stated unless otherwise told.
     * its place in the ordering will be based on a left to right order starting at the top of the tree.
     * @param number The number being searched for
     * @param place the place in the ordering(will only matter if there are multiple of the same number)
     * @return
     */
    private int find(int number, int place) {
        throw new IllegalArgumentException("Functionality coming soon");
    }


    /**
     * Reorders the nodes based on the inserted node
     * Explanation: Basically as long as the inserted node is either: less than the parent if MINHEAP, or greater than
     * the parent if MAXHEAP. Then the parent node and the inserted node will switch spots.
     * Question that I had about it when I started learning: What happens if the nodes are the same value?
     * Answer: If this is the case then I have it set so that the inserted node stays wherever its located. I think this
     * is common practice. You could also switch spots with the parent node but this would be redundant as they are the
     * same value
     */
    private void heapafy(){
        boolean parentComparison = false;
        int tempCurrentIndex = getCurrentIndex();
        int tempCurrentParentIndex = getCurrentParentIndex();
        while(!parentComparison){
            int parentNode = nodes[tempCurrentParentIndex];
            int tempNode = nodes[tempCurrentIndex];
            if (tempCurrentParentIndex == 0) {
                parentComparison = true;
            }
            else if (minMax(minOrMax, tempNode, parentNode)) {
                //tempNode = nodes[tempCurrentIndex];
                nodes[tempCurrentParentIndex] = tempNode;
                nodes[tempCurrentIndex] = parentNode;
                tempCurrentIndex = tempCurrentIndex / 2;
                tempCurrentParentIndex = tempCurrentParentIndex / 2;
            } else {
                parentComparison = true;
            }
        }
    }

    /**
     * Gets the current Nodes
     * @return list of Nodes in the Heap
     */
    public int[] getNodes() {
        int[] currentNodes = new int[getCurrentIndex() - 1];
        for(int i = 1; i < getCurrentIndex(); i++){
            currentNodes[i - 1] = nodes[i];
        }
        return currentNodes;
    }

    /**
     * Makes the list empty
     */
    @Override
    public void reset() {
        nodes = new int[SIZELIMIT];
        currentIndex = 1;
    }

    /**
     * Not sure if I want this feature, what would it entail?
     * I could keep an array of memory? An array of arrays?
     * What's a better way? Not a good idea to keep that much in storage?
     * Look this up later.
     */
    @Override
    public void undo() {
    throw new IllegalArgumentException("Functionality coming soon");
    }

    /**
     * A String representation of the nodes. Will do until I have the UI finished.
     * Has a parent mode where, if the user selects to be true, the parent of every node is given alongside the node.
     * @param parentMode boolean value to set parent mode or not. True = Parent Mode False = Regular Mode
     * @return a String representation of the nodes in either parent mode or regular mode
     */
    public String currentNodesConsole(boolean parentMode) {
        String currentMode = currentMode();
        int[] allNodes = getNodes();
        int sizeOfHeap = allNodes.length;
        if (getCurrentIndex() == 1) {
            return "Heap is empty!";
        }
        String tree = "" + allNodes[0];
        StringBuilder treeBuilder = new StringBuilder(currentMode + "\n" + tree);
        int currentExponential = 2;
        int currentCountRow = 1;
        if (parentMode) {
            treeBuilder.append("(no parent)\n");
        } else {
            treeBuilder.append("\n");
        }
        for (int i = 1; i < sizeOfHeap; i++){
            if (currentCountRow % (currentExponential + 1) == 0){
                treeBuilder.append("\n");
                treeBuilder.append(allNodes[i]);
                if (parentMode) {
                    treeBuilder.append("(" + "parent: " + nodes[(i + 1) / 2] + ")");
                }
                treeBuilder.append(" ");
                currentExponential *= 2;
                currentCountRow = 2;
            }else{
                treeBuilder.append(allNodes[i]);
                if (parentMode) {
                    treeBuilder.append("(" + "parent: " + nodes[(i + 1) / 2] + ")");
                }
                treeBuilder.append(" ");
                currentCountRow += 1;
            }
        }
        return treeBuilder.toString();
    }

    /**
     * This is really the only differentiation in the code between MinMax and MinHeap. A MaxHeap Checks if the parent
     * is greater than the selected node. A MinHeap checks if the parent is less than the selected Node.
     * @param min True if MINHEAP False if MAXHEAP
     * @param childNode the current child node that is being compared to the parent node
     * @param parentNode the current parent node that is being compared it its child node
     * @return the boolean comparison based on if its a MINHEAP or MAXHEAP
     */
    private boolean minMax (boolean min, int childNode, int parentNode){
        if (min) {
            return childNode < parentNode;
        } else {
            return childNode > parentNode;
        }
    }


    /**
     * Differentiates between a MaxHeap and a MinHeap.
     * @return returns a sting representation of MinHeap or MaxHeap depending on the selected mode.
     */
    private String currentMode() {
        if (minOrMax) {
            return "MIN HEAP";
        }
        else{
            return "MAX HEAP";
        }
    }

}
