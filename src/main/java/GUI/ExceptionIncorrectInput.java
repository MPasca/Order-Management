package GUI;

import javax.swing.*;

/**
 * The type Exception incorrect input.
 */
public class ExceptionIncorrectInput extends Exception{
    /**
     * Instantiates a new Exception incorrect input.
     *
     * @param panel the panel
     * @param view  the view
     * @param field the field
     */
    public ExceptionIncorrectInput(JPanel panel, String view, String field){
        JOptionPane.showMessageDialog(panel, view + ": field " + field + " cannot be empty.");
    }
}
