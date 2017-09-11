import Controller.HeapController;
import Model.MinMaxHeapImpl;

/**
 * Created by jtorre on 7/30/17.
 */

/**
 * This class prints the Heap into the console.
 */
public class AlgorithmsAidConsoleMain {
    private static boolean MINHEAP = true;
    private static boolean MAXHEAP = false;
    private static boolean PARENTMODE = true;
    private static boolean REGULARMODE = false;

    //FEEL FREE TO INSERT AS MANY NODES AS YOU WANT
    //Note: Only have minHeap and Max heap implemented currently.
    //To interchange in between MinHeap and Max Heap change the input for
    //MinMaxHeapImpl to either: MINHEAP or MAXHEAP;
    public static void main(String[] args) {
        //select between MAXHEAP or MINHEAP
        MinMaxHeapImpl minHeap = new MinMaxHeapImpl(MINHEAP);
        minHeap.insert(-5);
        minHeap.insert(-7);
        minHeap.insert(6);
        String currentOutput = minHeap.currentNodesConsole(PARENTMODE);
        System.out.println(currentOutput);
    }
}
