package ShowImage;

import javax.swing.*;

public class ImageViewer extends JFrame {
    private JLabel imgPanel;
    private JButton btnOne, btnTwo;

    public ImageViewer(){

    }

    public static void main(String[] args) {
        ImageViewer imageViewer = new ImageViewer();
        imageViewer.setTitle("Image Viewer");
        imageViewer.setSize(400,450);
        imageViewer.setVisible(true);
        imageViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
