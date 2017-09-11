package Controller;

import Model.ITree;

import java.util.Scanner;

/**
 * Class so that user can insert nodes to the model in a text file through
 * Command line
 */
public class HeapTextInsert {
    ITree heap;

    HeapTextInsert(ITree heap) {
        this.heap = heap;
    }

    public void scan() {
        Scanner myScanner = new Scanner(System.in);
        String inputedData = myScanner.nextLine();
        String[] splitedData = inputedData.split(",");

        for (String i : splitedData) {
            heap.insert(Integer.parseInt(i));
        }

        throw new IllegalArgumentException("Not yet finished");
    }

}
