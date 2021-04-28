package GUI;

import javax.swing.*;

public class ExceptionIncorrectInput extends Exception{
    public ExceptionIncorrectInput(JPanel panel, String view, String field){
        JOptionPane.showMessageDialog(panel, view + ": field " + field + " cannot be empty.");
    }
}
