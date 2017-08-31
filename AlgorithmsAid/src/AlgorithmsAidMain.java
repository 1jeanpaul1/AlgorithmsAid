import Model.MinMaxHeapImpl;

/**
 * Created by jtorre on 7/30/17.
 */
public class AlgorithmsAidMain {
    private static boolean MINHEAP = true;
    private static boolean MAXHEAP = false;
    private static boolean PARENTMODE = true;
    private static boolean REGULARMODE = false;

    //FEEL FREE TO INSERT AS MANY NODES AS YOU WANT

    public static void main(String[] args) {
        //select between MAXHEAP or MINHEAP
        MinMaxHeapImpl minHeap = new MinMaxHeapImpl(MINHEAP);
        minHeap.insert(-5);
        minHeap.insert(-7);
        minHeap.insert(6);
        minHeap.insert(-100);
        minHeap.insert(4);
        minHeap.insert(12);
        minHeap.insert(0);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(100);
        minHeap.insert(4);
        minHeap.insert(-12);
        minHeap.insert(0);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(100);
        minHeap.insert(4);
        minHeap.insert(12);
        minHeap.insert(0);
        minHeap.insert(14);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(62);
        minHeap.insert(100);
        minHeap.insert(4);
        minHeap.insert(12);
        minHeap.insert(30);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(100);
        minHeap.insert(4);
        minHeap.insert(122);
        minHeap.insert(0);
        minHeap.insert(1);
        int[] nodes = minHeap.getNodes();
        //select between PARENTMODE or REGULARMODE
        //System.out.println(minHeap.currentNodesConsole(PARENTMODE));
        minHeap.reset();
        System.out.println(minHeap.currentNodesConsole(REGULARMODE));
        minHeap.insert(1);
        System.out.println(minHeap.currentNodesConsole(PARENTMODE));

    }
}
