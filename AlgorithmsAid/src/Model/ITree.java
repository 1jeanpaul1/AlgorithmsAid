package Model;

/**
 * Created by jtorre on 7/16/17.
 */

/**
 * ITree will be the interface that all trees will follow. Will contain
 * General Methods that all trees have such as adding/deleting nodes
 */
public interface ITree {

    /**
     * Adds a node to the given Tree
     * @param node the node being added
     */
    void insert(int node);

    /**
     * Deletes the first node found with the given value.
     * @param node deletes this node.
     */
    void delete(int node);

    /**
     * Gets the inserted nodes.
     * @return an array of the inserted nodes.
     */
    int[] getNodes();

    /**
     * Makes the array of nodes empty.
     */
    void reset();

    /**
     * undoes the last action made.
     */
    void undo();

    /**
     * String representation of the model.
     * @return a String representation of the model.
     */
    String toString();

    /**
     * Returns a String representation of the inserted nodes.
     * @param parentMode if true the returned value shoes parent data of each node.
     * @return A String representation of the inserted nodes in either parentMode or Regular Mode.
     */
    String currentNodesConsole(boolean parentMode);
}
