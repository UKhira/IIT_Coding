package JavaFX_Pack.MouseDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDetailsFrame extends JFrame {
    private String details;
    private JLabel statusBar;

    public MouseDetailsFrame(){
        super("Mouse Clicks and buttons");

        statusBar = new JLabel("Click the Mouse");
        add(statusBar, BorderLayout.SOUTH);
        addMouseListener(new MouseClickHandler());   //add handler
    }

    private class MouseClickHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent event){
            int xPos = event.getX();    //get pos X of the mouse
            int yPos = event.getY();    //get pos Y of the mouse

            details = String.format("Clicked %d time(s)",event.getClickCount());

            if(event.isMetaDown())      //right mouse button
                details += " with right mouse button";
            else if (event.isAltDown())     //middle mouse button
                details += " with center mouse button";
            else
                details += " with left mouse button";

            statusBar.setText(details);
        }
    }

    public static void main(String[] args) {
        MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
        mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseDetailsFrame.setSize(400, 150);
        mouseDetailsFrame.setVisible(true);
    }
}
