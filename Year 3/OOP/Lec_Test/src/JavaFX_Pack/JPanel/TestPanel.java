package JavaFX_Pack.JPanel;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JFrame {
    public TestPanel() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));

        for (int i = 1; i <= 9; i++) {
            p1.add(new JButton("" + i));
        }
        p1.add(new JButton("0"));
        p1.add(new JButton("Start"));
        p1.add(new JButton("Stop"));

        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(new JTextField("Time to be displayed here"), BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);

        add(p2, BorderLayout.EAST);
        add(new JButton("Food to be placed here"), BorderLayout.CENTER);

        p1.setBackground(Color.YELLOW);
    }

    public static void main (String[]args){
        TestPanel frame = new TestPanel();
        frame.setTitle("The Front view of a microwave oven");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);
    }
}
