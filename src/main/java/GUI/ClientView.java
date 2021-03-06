package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The type Client view.
 */
public class ClientView {
    /**
     * The Element.
     */
    Element element = new Element();

    /**
     * The Client frame.
     */
    JFrame clientFrame = new JFrame();
    /**
     * The Main panel.
     */
    JPanel mainPanel = new JPanel();
    /**
     * The Panel add.
     */
    JPanel panelAdd = new JPanel();
    /**
     * The Panel edit.
     */
    JPanel panelEdit = new JPanel();
    /**
     * The Panel remove.
     */
    JPanel panelRemove = new JPanel();
    /**
     * The Panel view.
     */
    JPanel panelView = new JPanel();

    /**
     * The Lbl add title.
     */
//  ------------------------------------ panelAdd elements
    JLabel lblAddTitle = new JLabel("Add Client");

    /**
     * The Lbl add name.
     */
    JLabel lblAddName = new JLabel("Name:");
    /**
     * The Txt add name.
     */
    JTextField txtAddName = new JTextField(25);
    /**
     * The Lbl add email.
     */
    JLabel lblAddEmail = new JLabel("Email:");
    /**
     * The Txt add email.
     */
    JTextField txtAddEmail = new JTextField(25);
    /**
     * The Lbl add telephone.
     */
    JLabel lblAddTelephone = new JLabel("Telephone:");
    /**
     * The Txt add telephone.
     */
    JTextField txtAddTelephone = new JTextField(25);
    /**
     * The Lbl add address.
     */
    JLabel lblAddAddress = new JLabel("Address:");
    /**
     * The Txt add address.
     */
    JTextField txtAddAddress = new JTextField(25);

    /**
     * The Btn add.
     */
    JButton btnAdd = new JButton("Add");

    /**
     * The Lbl remove title.
     */
// ------------------------------------- panelRemove elements
    JLabel lblRemoveTitle = new JLabel("Remove Client");

    /**
     * The Lbl remove search name.
     */
    JLabel lblRemoveSearchName = new JLabel("Delete by name:");
    /**
     * The Txt remove search name.
     */
    JTextField txtRemoveSearchName = new JTextField(5);
    /**
     * The Lbl remove search id.
     */
    JLabel lblRemoveSearchID = new JLabel("Delete by ID:");
    /**
     * The Txt remove search id.
     */
    JTextField txtRemoveSearchID = new JTextField(25);

    /**
     * The Btn remove.
     */
    JButton btnRemove = new JButton("Delete");

    /**
     * The Lbl update title.
     */
// ------------------------------------- panelEdit elements
    JLabel lblUpdateTitle = new JLabel("Update Client");

    /**
     * The Lbl update id.
     */
    JLabel lblUpdateID = new JLabel("ID: ");
    /**
     * The Txt update id.
     */
    JTextField txtUpdateID = new JTextField(5);
    /**
     * The Lbl update name.
     */
    JLabel lblUpdateName = new JLabel("Name:");
    /**
     * The Txt update name.
     */
    JTextField txtUpdateName = new JTextField(25);
    /**
     * The Lbl update email.
     */
    JLabel lblUpdateEmail = new JLabel("Email:");
    /**
     * The Txt update email.
     */
    JTextField txtUpdateEmail = new JTextField(25);
    /**
     * The Lbl update telephone.
     */
    JLabel lblUpdateTelephone = new JLabel("Telephone:");
    /**
     * The Txt update telephone.
     */
    JTextField txtUpdateTelephone = new JTextField(25);
    /**
     * The Lbl update address.
     */
    JLabel lblUpdateAddress = new JLabel("Address:");
    /**
     * The Txt update address.
     */
    JTextField txtUpdateAddress = new JTextField(25);

    /**
     * The Btn update.
     */
    JButton btnUpdate = new JButton("Update Client");


    /**
     * The Lbl show all title.
     */
// ------------------------------------- panelShow elements
    JLabel lblShowAllTitle = new JLabel("All Clients");
    /**
     * The Table clients.
     */
    JTable tableClients = new JTable();


    /**
     * Instantiates a new Client view.
     */
    public ClientView(){
        clientFrame.setBackground(element.colours.get(4));

// ------------ Add Panel
        panelAdd.setBackground(element.colours.get(4));

        lblAddTitle.setForeground(element.colours.get(0));
        lblAddTitle.setFont(element.fonts.get(3));
        lblAddTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAddTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        lblAddName.setForeground(element.colours.get(0));
        lblAddName.setFont(element.fonts.get(2));
        lblAddName.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddName.setColumns(30);
        txtAddName.setFont(element.fonts.get(1));
        txtAddName.setMaximumSize(new Dimension(600, 40));
        txtAddName.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelName = new JPanel();
            panelName.setBackground(element.colours.get(4));
            panelName.add(lblAddName);
            panelName.add(txtAddName);
            panelName.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblAddEmail.setForeground(element.colours.get(0));
        lblAddEmail.setFont(element.fonts.get(2));
        lblAddEmail.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddEmail.setColumns(30);
        txtAddEmail.setFont(element.fonts.get(1));
        txtAddEmail.setMaximumSize(new Dimension(600, 40));
        txtAddEmail.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelEmail = new JPanel();
            panelEmail.setBackground(element.colours.get(4));
            panelEmail.add(lblAddEmail);
            panelEmail.add(txtAddEmail);
            panelEmail.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblAddAddress.setForeground(element.colours.get(0));
        lblAddAddress.setFont(element.fonts.get(2));
        lblAddAddress.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddAddress.setColumns(30);
        txtAddAddress.setFont(element.fonts.get(1));
        txtAddAddress.setMaximumSize(new Dimension(600, 40));
        txtAddAddress.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelAddress = new JPanel(new FlowLayout());
            panelAddress.setBackground(element.colours.get(4));
            panelAddress.add(lblAddAddress);
            panelAddress.add(txtAddAddress);
            panelAddress.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblAddTelephone.setForeground(element.colours.get(0));
        lblAddTelephone.setFont(element.fonts.get(2));
        lblAddTelephone.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddTelephone.setColumns(30);
        txtAddTelephone.setFont(element.fonts.get(1));
        txtAddTelephone.setMaximumSize(new Dimension(600, 40));
        txtAddTelephone.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelTelephone = new JPanel(new FlowLayout());
            panelTelephone.setBackground(element.colours.get(4));
            panelTelephone.add(lblAddTelephone);
            panelTelephone.add(txtAddTelephone);
            panelTelephone.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnAdd.setBackground(element.colours.get(3));
        btnAdd.setForeground(element.colours.get(1));
        btnAdd.setFont(element.fonts.get(0));
        btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelAdd.add(lblAddTitle);
        panelAdd.add(panelName);
        panelAdd.add(panelEmail);
        panelAdd.add(panelAddress);
        panelAdd.add(panelTelephone);
        panelAdd.add(btnAdd);
        panelAdd.add(new JLabel(" "));
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));

// ------------ Update panel
        panelEdit.setBackground(element.colours.get(4));

        lblUpdateTitle.setForeground(element.colours.get(0));
        lblUpdateTitle.setFont(element.fonts.get(3));
        lblUpdateTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUpdateTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        lblUpdateID.setForeground(element.colours.get(0));
        lblUpdateID.setFont(element.fonts.get(2));
        lblUpdateID.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateID.setColumns(30);
        txtUpdateID.setFont(element.fonts.get(1));
        txtUpdateID.setMaximumSize(new Dimension(600, 40));
        txtUpdateID.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateID = new JPanel();
            panelUpdateID.setBackground(element.colours.get(4));
            panelUpdateID.add(lblUpdateID);
            panelUpdateID.add(txtUpdateID);
            panelUpdateID.setBorder(new EmptyBorder(0, 30, 10 ,30));


        lblUpdateName.setForeground(element.colours.get(0));
        lblUpdateName.setFont(element.fonts.get(2));
        lblUpdateName.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateName.setColumns(30);
        txtUpdateName.setFont(element.fonts.get(1));
        txtUpdateName.setMaximumSize(new Dimension(600, 40));
        txtUpdateName.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateName = new JPanel();
            panelUpdateName.setBackground(element.colours.get(4));
            panelUpdateName.add(lblUpdateName);
            panelUpdateName.add(txtUpdateName);
            panelUpdateName.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblUpdateEmail.setForeground(element.colours.get(0));
        lblUpdateEmail.setFont(element.fonts.get(2));
        lblUpdateEmail.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateEmail.setColumns(30);
        txtUpdateEmail.setFont(element.fonts.get(1));
        txtUpdateEmail.setMaximumSize(new Dimension(600, 40));
        txtUpdateEmail.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateEmail = new JPanel();
            panelUpdateEmail.setBackground(element.colours.get(4));
            panelUpdateEmail.add(lblUpdateEmail);
            panelUpdateEmail.add(txtUpdateEmail);
            panelUpdateEmail.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblUpdateAddress.setForeground(element.colours.get(0));
        lblUpdateAddress.setFont(element.fonts.get(2));
        lblUpdateAddress.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateAddress.setColumns(30);
        txtUpdateAddress.setFont(element.fonts.get(1));
        txtUpdateAddress.setMaximumSize(new Dimension(600, 40));
        txtUpdateAddress.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateAddress = new JPanel(new FlowLayout());
            panelUpdateAddress.setBackground(element.colours.get(4));
            panelUpdateAddress.add(lblUpdateAddress);
            panelUpdateAddress.add(txtUpdateAddress);
            panelUpdateAddress.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblUpdateTelephone.setForeground(element.colours.get(0));
        lblUpdateTelephone.setFont(element.fonts.get(2));
        lblUpdateTelephone.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateTelephone.setColumns(30);
        txtUpdateTelephone.setFont(element.fonts.get(1));
        txtUpdateTelephone.setMaximumSize(new Dimension(600, 40));
        txtUpdateTelephone.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateTelephone = new JPanel(new FlowLayout());
            panelUpdateTelephone.setBackground(element.colours.get(4));
            panelUpdateTelephone.add(lblUpdateTelephone);
            panelUpdateTelephone.add(txtUpdateTelephone);
            panelUpdateTelephone.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnUpdate.setBackground(element.colours.get(3));
        btnUpdate.setForeground(element.colours.get(1));
        btnUpdate.setFont(element.fonts.get(0));
        btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelEdit.add(lblUpdateTitle);
        panelEdit.add(panelUpdateID);
        panelEdit.add(panelUpdateName);
        panelEdit.add(panelUpdateEmail);
        panelEdit.add(panelUpdateAddress);
        panelEdit.add(panelUpdateTelephone);
        panelEdit.add(btnUpdate);
        panelEdit.add(new JLabel(" "));
        panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.Y_AXIS));


// ------------ Delete panel
        panelRemove.setBackground(element.colours.get(4));
        
        lblRemoveTitle.setForeground(element.colours.get(0));
        lblRemoveTitle.setFont(element.fonts.get(3));
        lblRemoveTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblRemoveTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        lblRemoveSearchID.setForeground(element.colours.get(0));
        lblRemoveSearchID.setFont(element.fonts.get(2));
        lblRemoveSearchID.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtRemoveSearchID.setColumns(5);
        txtRemoveSearchID.setFont(element.fonts.get(1));
        txtRemoveSearchID.setMaximumSize(new Dimension(400, 40));
        txtRemoveSearchID.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelRemoveSearchID = new JPanel();
            panelRemoveSearchID.setBackground(element.colours.get(4));
            panelRemoveSearchID.add(lblRemoveSearchID);
            panelRemoveSearchID.add(txtRemoveSearchID);
            panelRemoveSearchID.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnRemove.setBackground(element.colours.get(3));
        btnRemove.setForeground(element.colours.get(1));
        btnRemove.setFont(element.fonts.get(0));
        btnRemove.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelRemove.add(lblRemoveTitle);
        panelRemove.add(panelRemoveSearchID);
        panelRemove.add(btnRemove);
        panelRemove.add(new JLabel(" "));
        panelRemove.setLayout(new BoxLayout(panelRemove, BoxLayout.Y_AXIS));

// ------------ Show clients
        panelView.setBackground(element.colours.get(4));

        lblShowAllTitle.setForeground(element.colours.get(0));
        lblShowAllTitle.setFont(element.fonts.get(3));
        lblShowAllTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblShowAllTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        tableClients.setBounds(20, 20, 200, 300);
        tableClients.setBackground(element.colours.get(1));
        tableClients.setForeground(element.colours.get(3));
        tableClients.setFont(element.fonts.get(4));

        panelView.add(lblShowAllTitle);
        panelView.add(tableClients);


        mainPanel.add(panelAdd);
        mainPanel.add(panelEdit);
        mainPanel.add(panelRemove);
        mainPanel.add(panelView);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        clientFrame.add(mainPanel);
        clientFrame.setSize(500, 450);

        clientFrame.setVisible(true);
    }

}
