package JavaFX_Pack.FlowLayout;

import javax.swing.*;
import java.awt.*;

public class showFlowLayout extends JFrame {
    public showFlowLayout(){
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        add(new JLabel("First Name"));
        add(new JTextField(8));
        add(new JLabel("Middle Name"));
        add(new JTextField(1));
        add(new JLabel("Last Name"));
        add(new JTextField(8));
    }

    public static void main(String[] args) {
        showFlowLayout frame = new showFlowLayout();
        frame.setTitle("ShowFlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
