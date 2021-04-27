package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientView {
    Element element = new Element();

    JFrame clientFrame = new JFrame();
    JPanel panelAdd = new JPanel();
    JPanel panelEdit = new JPanel();
    JPanel panelRemove = new JPanel();

//  ------------------------------------ panelAdd elements
    JLabel lblAddTitle = new JLabel("Add Client");

    JLabel lblAddName = new JLabel("Name:");
    JTextField txtAddName = new JTextField(25);
    JLabel lblAddEmail = new JLabel("Email:");
    JTextField txtAddEmail = new JTextField(25);
    JLabel lblAddTelephone = new JLabel("Telephone:");
    JTextField txtAddTelephone = new JTextField(25);
    JLabel lblAddAddress = new JLabel("Address:");
    JTextField txtAddAddress = new JTextField(25);

    JButton btnAdd = new JButton();

// ------------------------------------- panelRemove elements
    JLabel lblRemoveTitle = new JLabel("Remove Client");

    JLabel lblRemoveSearchID = new JLabel("Search by ID:");
    JTextField txtRemoveSearchID = new JTextField(5);
    JLabel lblRemoveSearchName = new JLabel("Search by name:");
    JTextField txtRemoveSearchName = new JTextField(25);

    JButton btnRemove = new JButton();

// ------------------------------------- panelEdit elements
    JLabel lblEditTitle = new JLabel("Remove Client");

    // the elements from Add Client

    JButton btnEdit = new JButton();

    public ClientView(){
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clientFrame.setBackground(element.colours.get(4));

// ------------ Add Panel
        panelAdd.setBackground(element.colours.get(4));

        lblAddTitle.setForeground(element.colours.get(0));
        lblAddTitle.setFont(element.fonts.get(3));
        lblAddTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAddTitle.setBorder(new EmptyBorder(0, 30, 50 ,30));

        lblAddName.setForeground(element.colours.get(0));
        lblAddName.setFont(element.fonts.get(1));
        lblAddName.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddName.setColumns(10);
        txtAddName.setFont(element.fonts.get(1));
        txtAddName.setMaximumSize(new Dimension(300, 30));
        txtAddName.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        lblAddEmail.setForeground(element.colours.get(0));
        lblAddEmail.setFont(element.fonts.get(1));
        lblAddEmail.setBorder(new EmptyBorder(0, 0, 50 ,30));

        lblAddAddress.setForeground(element.colours.get(0));
        lblAddAddress.setFont(element.fonts.get(1));
        lblAddAddress.setBorder(new EmptyBorder(0, 0, 50 ,30));

        lblAddTelephone.setForeground(element.colours.get(0));
        lblAddTelephone.setFont(element.fonts.get(1));
        lblAddTelephone.setBorder(new EmptyBorder(0, 0, 50 ,30));

        JPanel panelName = new JPanel();
            panelName.setBackground(element.colours.get(4));
            panelName.add(lblAddName);
            panelName.add(txtAddName);
            panelName.setBorder(new EmptyBorder(0, 30, 50 ,30));
            panelName.setLayout(new BoxLayout(panelName, BoxLayout.X_AXIS));

        JPanel panelEmail = new JPanel();
            panelEmail.setBackground(element.colours.get(4));
            panelEmail.add(lblAddEmail);
            panelEmail.add(txtAddEmail);
            panelEmail.setLayout(new BoxLayout(panelEmail, BoxLayout.X_AXIS));


        JPanel panelAddress = new JPanel(new FlowLayout());
            panelAddress.setBackground(element.colours.get(4));
            panelAddress.add(lblAddAddress);
            panelAddress.add(txtAddAddress);
            panelAddress.setLayout(new BoxLayout(panelAddress, BoxLayout.X_AXIS));

        JPanel panelTelephone = new JPanel(new FlowLayout());
            panelTelephone.setBackground(element.colours.get(4));
            panelTelephone.add(lblAddTelephone);
            panelTelephone.add(txtAddTelephone);

        panelAdd.add(lblAddTitle);
        panelAdd.add(panelName);
        panelAdd.add(panelEmail);
        panelAdd.add(panelAddress);
        panelAdd.add(panelTelephone);
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));

        clientFrame.add(panelAdd);
        clientFrame.pack();

        clientFrame.setVisible(true);
    }
}
