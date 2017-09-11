package Controller;

public interface IController {
    /**
     * renders the View
     */
    void render();
    void insert();
    void delete();
    void undo();
    void reset();
}
