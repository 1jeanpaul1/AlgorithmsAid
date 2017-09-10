package View;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

public class GuiViewFrame extends JFrame {
    private NodeGuiViewPanel nodeView;
    private final JPanel gui;
    private JScrollPane scrollPane;


    public GuiViewFrame(int[] loNodes, String heapType) {
        this.nodeView = new NodeGuiViewPanel(loNodes, heapType);
        this.gui = this.nodeView;
        scrollPane = new JScrollPane(gui, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.setResizable(false);
        this.setLayout(new GridLayout(1,1));
        this.add(scrollPane);
        this.setTitle(this.nodeView.getName());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setFocusable(true);
        this.requestFocus();
        scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)(950 * 1.5), (int)(680 / 1.5));
    }

    public void render() {
        //problem is here. Doesn't seem to pain.
        initialize();
       // gui.repaint();
    }

    private void initialize() {
        this.setVisible(true);
    }


}
