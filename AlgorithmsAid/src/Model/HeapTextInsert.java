package Model;

import java.util.Scanner;

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

    }

}
