package JavaFX_Pack.MouseTracker;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseTrackerFrame extends JFrame {
    private JPanel mousePanel;       //Panel in which mouse events will occur
    private JLabel statusBar;        //Label that displays event information

    //MouseTrackerFrame Constructor sets up GUI and registers mouse event handlers

    public MouseTrackerFrame(){
        super("Demonstrating Mouse Events");

        mousePanel = new JPanel(); //Create Panel
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Mouse Outside JPanel");
        add(statusBar, BorderLayout.SOUTH);

//        Create and register listener for mouse and mouse motion events
        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

//        MouseListener event handlers handle event when mouse released immediately after the press
        @Override
        public void mouseClicked(MouseEvent event){
            statusBar.setText(String.format("Clicked at [%d, %d]",event.getX(), event.getY()));
        }

        @Override
        public void mousePressed(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d, %d]",event.getX(), event.getY()));
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d, %d]",event.getX(), event.getY()));
        }

        @Override
        public void mouseEntered(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d, %d]",event.getX(), event.getY()));
            mousePanel.setBackground(Color.GREEN);
        }

        //        Handle event when mouse exit the area
        public void mouseExited(MouseEvent event){
            statusBar.setText("Mouse outside JPanel");
            mousePanel.setBackground(Color.WHITE);
        }

        @Override
        public void mouseDragged(MouseEvent e){
            throw new UnsupportedOperationException("Not Supported yet.");   //to change body of generator
        }

        @Override
        public void mouseMoved(MouseEvent e){
            throw new UnsupportedOperationException("Not supported yet");   //to change body of generator
        }


    }

    public static void main(String[] args) {
        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300, 100);
        mouseTrackerFrame.setVisible(true);
    }
}
