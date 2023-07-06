package application.views.screens;

import javax.swing.*;

public abstract class BaseScreen {
    protected final JFrame frame;

    protected BaseScreen() {
        this.frame = new JFrame();
        this.frame.setSize(1024,720);
        this.frame.setLayout(null);
        this.visible();
        this.frame.setVisible(true);
    }

    public abstract void visible();
}
