package JavaFX_Pack.EventHandle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListenerDemo extends JFrame {
    JButton b;
    JTextField tf;

    public EventListenerDemo(){
        b = new JButton("Click Here");
        tf = new JTextField();
        this.setTitle("ActionListener Example");

        DemoHandler handler =  new DemoHandler();

        b.addActionListener(handler);

        this.add(b, BorderLayout.NORTH);
        this.add(tf, BorderLayout.CENTER);
    }

    private class DemoHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            tf.setText("Welcome to Java");
        }
    }

    public static void main(String[] args) {
        EventListenerDemo example = new EventListenerDemo();
        example.setVisible(true);
        example.setSize(200, 200);
        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
