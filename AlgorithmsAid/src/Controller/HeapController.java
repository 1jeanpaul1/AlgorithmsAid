package Controller;

import Model.MinMaxHeapImpl;
import View.GuiViewFrame;


/**
 * Controller for the Heaps. All commands from user will go through controller and passed to
 * the Model and the View.
 */
public class HeapController implements IController{
    private MinMaxHeapImpl model;
    private GuiViewFrame view;

    public HeapController(MinMaxHeapImpl minMaxHeap) {
        this.model = minMaxHeap;
        this.view = new GuiViewFrame(minMaxHeap.getNodes(), "Min");
    }

    @Override
    public void render() {
        view.render();
    }

    @Override
    public void insert() {
        throw new IllegalArgumentException("Not yet implemented");
    }

    @Override
    public void delete() {
        throw new IllegalArgumentException("Not yet implemented");

    }

    @Override
    public void undo() {
        throw new IllegalArgumentException("Not yet implemented");

    }

    @Override
    public void reset() {
        throw new IllegalArgumentException("Not yet implemented");
    }

}
