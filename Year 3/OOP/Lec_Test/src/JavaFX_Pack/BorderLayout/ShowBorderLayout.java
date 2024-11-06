package JavaFX_Pack.BorderLayout;

import javax.swing.*;
import java.awt.*;

public class ShowBorderLayout extends JFrame{
    public ShowBorderLayout(){
        setLayout(new BorderLayout(5,10));

        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("Center"), BorderLayout.CENTER);
        add(new JButton("West"), BorderLayout.WEST);
    }

    public static void main(String[] args) {
        ShowBorderLayout frame = new ShowBorderLayout();
        frame.setTitle("ShowFlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
