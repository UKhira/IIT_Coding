package GUI_Application;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame(){
        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            p1.add(new JButton("" + i)).setBackground(Color.RED);
        }
        p1.add(new JButton("0")).setBackground(Color.RED);
        p1.add(new JButton("-")).setBackground(Color.RED);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));
        p2.add(new JButton("/")).setBackground(Color.GREEN);
        p2.add(new JButton("-")).setBackground(Color.GREEN);
        p2.add(new JButton("Clear")).setBackground(Color.GREEN);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));
        p3.add(p1);
        p3.add(p2);

        TextField textField = new TextField("45.5");
        textField.setBackground(Color.YELLOW);
        add(textField, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        CalculatorFrame myCalculator = new CalculatorFrame();
        myCalculator.setTitle("My Calculator");
        myCalculator.setVisible(true);
        myCalculator.setSize(600, 300);
        myCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
