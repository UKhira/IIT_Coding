package Excercise_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ImageViewer extends JFrame {
    private JLabel imgPanel;
    private JButton btnOne, btnTwo;

    private ImageIcon imageZero ,imageOne, imageTwo;

    public ImageViewer(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.setBackground(Color.BLUE);

        JPanel panelOne = new JPanel();
        panelOne.setLayout(new GridLayout(1,2));

        btnOne = new JButton("One");
        panelOne.add(btnOne);

        btnTwo = new JButton("Two");
        panelOne.add(btnTwo);

        imageZero = new ImageIcon(Objects.requireNonNull(getClass().getResource("zero.png")));
        imgPanel = new JLabel(imageZero, JLabel.CENTER);

        cp.add(imgPanel, BorderLayout.CENTER);
        cp.add(panelOne, BorderLayout.SOUTH);

        imageOne = new ImageIcon(Objects.requireNonNull(getClass().getResource("one.png")));
        imageTwo = new ImageIcon(Objects.requireNonNull(getClass().getResource("two.png")));

        MyListener myListener = new MyListener();
        btnOne.addActionListener(myListener);
        btnTwo.addActionListener(myListener);

        imgPanel.addMouseListener(myListener);
    }

    private class MyListener extends MouseAdapter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();

            if(btnLabel.equals("One")){
                imgPanel.setIcon(imageOne);
            } else if (btnLabel.equals("Two")) {
                imgPanel.setIcon(imageTwo);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            imgPanel.setIcon(imageZero);
        }
    }

    public static void main(String[] args) {
        ImageViewer imageViewer = new ImageViewer();
        imageViewer.setTitle("Image Viewer");
        imageViewer.setSize(600,400);
        imageViewer.setVisible(true);
        imageViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

