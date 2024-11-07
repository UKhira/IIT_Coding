package GUI_Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame {
    private JLabel lblcount;
    private JTextField tfCount;
    private JButton btnCountUp, btnCountDown, reset;
    private int count = 0;

    public Counter(){
        super("My Counter");

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        lblcount = new JLabel("Counter");
        add(lblcount);

        tfCount = new JTextField(count + "", 10);
        tfCount.setEditable(false);
        add(tfCount);

        btnCountUp = new JButton("Count Up");
        add(btnCountUp);

        btnCountDown = new JButton("Count Down");
        add(btnCountDown);

        reset = new JButton("Reset");
        add(reset);


        MyListener handler = new MyListener();
        btnCountUp.addActionListener(handler);
        btnCountDown.addActionListener(handler);
        reset.addActionListener(handler);
    }

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            String btnLabel = event.getActionCommand();

            if(btnLabel.equals("Count Up")){
                ++count;
                tfCount.setText(count + "");
            } else if (btnLabel.equals("Count Down")) {
                count--;
                tfCount.setText(count + "");
            }
            else
                tfCount.setText("0");
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setSize(500,100);
        counter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        counter.setVisible(true);
    }
}
