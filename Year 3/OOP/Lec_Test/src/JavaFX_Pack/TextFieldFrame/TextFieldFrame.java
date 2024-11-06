package JavaFX_Pack.TextFieldFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame {
    private JTextField textField1, textField2, textField3;
    private JPasswordField passwordField;

//    TextField constructor adds JTextFields to JFrame
    public TextFieldFrame(){
        super("Testing JTextField and JPassword");
        setLayout(new FlowLayout());

//        Construct TextField with 10 Columns
        textField1 = new JTextField(10);
        add(textField1);

//      Construct TextField with default text
        textField2 = new JTextField("Enter Text Here");
        add(textField2);

//        Construct TextField with default text and 21 columns
        textField3 = new JTextField("Unpredictable Text Field", 21);
        textField3.setEditable(false);
        add(textField3);

//        Construct PasswordField with default text
        passwordField = new JPasswordField("Hidden Text");
        add(passwordField);

//        Register Event Handlers
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener {
//        Process TextField events
        public void actionPerformed(ActionEvent event){
            String string = "";         //Declaring string in display

//            User pressed Enter in JTextField1
            if(event.getSource() == textField1) {
                string = String.format("TextField1: %s", event.getActionCommand());
            }

//            User pressed Enter in JTextField2
            if(event.getSource() == textField2) {
                string = String.format("TextField2: %s", event.getActionCommand());
            }

//            User pressed Enter in JTextField3
            if(event.getSource() == textField3) {
                string = String.format("TextField3: %s", event.getActionCommand());
            }

//            User pressed Enter in JPasswordField
            if(event.getSource() == passwordField){
                string = String.format("TextField1: %s", new String(passwordField.getPassword()));
            }

//            Display the String in dialog box
            JOptionPane.showMessageDialog(null, string);
        }
    }

    public static void main(String[] args) {
        TextFieldFrame textFieldFrame = new TextFieldFrame();
        textFieldFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        textFieldFrame.setVisible(true);
        textFieldFrame.setSize(325,100);
    }
}
