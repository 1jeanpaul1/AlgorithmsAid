import Controller.HeapController;
import Model.MinMaxHeapImpl;

/**
 * Created by jtorre on 7/30/17.
 */

/**
 * This class draws the Nodes.
 */
public class AlgorithmsAidMain {
    private static boolean MINHEAP = true;
    private static boolean MAXHEAP = false;
    private static boolean PARENTMODE = true;
    private static boolean REGULARMODE = false;

    //FEEL FREE TO INSERT AS MANY NODES AS YOU WANT
    //Note: Not finished yet, still need some positioning fixes
    //Also need to add being able to manually
    public static void main(String[] args) {
        //select between MAXHEAP or MINHEAP
        MinMaxHeapImpl minHeap = new MinMaxHeapImpl(MINHEAP);
        minHeap.insert(-5);
        minHeap.insert(-7);
        minHeap.insert(6);
        HeapController controller = new HeapController(minHeap);
        controller.render();
    }
}
