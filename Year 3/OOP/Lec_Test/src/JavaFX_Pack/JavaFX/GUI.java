package JavaFX_Pack.JavaFX;

import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");

        JButton jbtOK = new JButton("OK");
        frame.add(jbtOK);
        JLabel jlblName = new JLabel("Enter Your name");
        frame.add(jlblName);
        JTextField jtfName = new JTextField("Type Name here");
        frame.add(jtfName);
        JCheckBox jchkBold = new JCheckBox("Bold");
        frame.add(jchkBold);
        JRadioButton jrbRed = new JRadioButton("Red");
        frame.add(jrbRed);
        JComboBox jcboColor = new JComboBox(new String[] {"Red","Green", "Blue"});
        frame.add(jcboColor);

        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
