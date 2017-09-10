package Controller;

import Model.MinMaxHeapImpl;
import View.GuiViewFrame;


public class HeapController {
    private MinMaxHeapImpl model;
    private GuiViewFrame view;

    public HeapController(MinMaxHeapImpl minMaxHeap) {
        this.model = minMaxHeap;
        this.view = new GuiViewFrame(minMaxHeap.getNodes(), "Min");
    }

    public void render() {
        view.render();
    }

}
