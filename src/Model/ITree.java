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
     * Deletes the first node found with the given value
     * @param node
     */
    void delete(int node);

    int[] getNodes();

    void reset();

    void undo();
}
