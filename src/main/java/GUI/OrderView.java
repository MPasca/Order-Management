package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrderView {
    Element element = new Element();

    JFrame orderFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel panelAdd = new JPanel();
    JPanel panelEdit = new JPanel();
    JPanel panelRemove = new JPanel();
    JPanel panelView = new JPanel();

    //  ------------------------------------ panelAdd elements
    JLabel lblAddTitle = new JLabel("Add Order");

    JLabel lblAddClientId = new JLabel("Client Id:");
    JComboBox<Integer> cmbClients = new JComboBox<>();
    JLabel lblAddProductId = new JLabel("Product Id:");
    JComboBox<Integer> cmbProducts = new JComboBox<>();
    JLabel lblAddQuantity = new JLabel("Quantity:");
    JTextField txtAddQuantity = new JTextField(25);

    JButton btnAdd = new JButton("Add");

    // ------------------------------------- panelRemove elements
    JLabel lblRemoveTitle = new JLabel("Remove Order");

    JLabel lblRemoveSearchClientId = new JLabel("Delete by ClientId:");
    JTextField txtRemoveSearchClientId = new JTextField(5);
    JLabel lblRemoveSearchID = new JLabel("Delete by ID:");
    JTextField txtRemoveSearchID = new JTextField(25);

    JButton btnRemove = new JButton("Delete");

    // ------------------------------------- panelEdit elements
    JLabel lblUpdateTitle = new JLabel("Update Product");

    JLabel lblUpdateID = new JLabel("ID: ");
    JTextField txtUpdateID = new JTextField(5);
    JLabel lblUpdateClientID = new JLabel("Name:");
    JTextField txtUpdateClientID = new JTextField(25);
    JLabel lblUpdateProductID = new JLabel("Telephone:");
    JTextField txtUpdateProductID = new JTextField(25);
    JLabel lblUpdateQuantity = new JLabel("Email:");
    JTextField txtUpdateQuantity = new JTextField(25);

    JButton btnUpdate = new JButton("Update");

    // ------------------------------------- panelShow elements
    JLabel lblShowAllTitle = new JLabel("All Orders");
    JTable tableOrders = new JTable();

    public OrderView(){
        orderFrame.setBackground(element.colours.get(4));

// ------------ Add Panel
        panelAdd.setBackground(element.colours.get(4));

        lblAddTitle.setForeground(element.colours.get(0));
        lblAddTitle.setFont(element.fonts.get(3));
        lblAddTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAddTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        lblAddClientId.setForeground(element.colours.get(0));
        lblAddClientId.setFont(element.fonts.get(2));
        lblAddClientId.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        cmbClients.setFont(element.fonts.get(1));
        cmbClients.setMaximumSize(new Dimension(100, 40));

        JPanel panelClientId = new JPanel();
            panelClientId.setBackground(element.colours.get(4));
            panelClientId.add(lblAddClientId);
            panelClientId.add(cmbClients);
            panelClientId.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblAddQuantity.setForeground(element.colours.get(0));
        lblAddQuantity.setFont(element.fonts.get(2));
        lblAddQuantity.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddQuantity.setColumns(30);
        txtAddQuantity.setFont(element.fonts.get(1));
        txtAddQuantity.setMaximumSize(new Dimension(600, 40));
        txtAddQuantity.setAlignmentY(JTextField.CENTER_ALIGNMENT);


        JPanel panelQuantity = new JPanel();
            panelQuantity.setBackground(element.colours.get(4));
            panelQuantity.add(lblAddQuantity);
            panelQuantity.add(txtAddQuantity);
            panelQuantity.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblAddProductId.setForeground(element.colours.get(0));
        lblAddProductId.setFont(element.fonts.get(2));
        lblAddProductId.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        cmbProducts.setFont(element.fonts.get(1));
        cmbProducts.setMaximumSize(new Dimension(100, 40));

        JPanel panelProductId = new JPanel(new FlowLayout());
            panelProductId.setBackground(element.colours.get(4));
            panelProductId.add(lblAddProductId);
            panelProductId.add(cmbProducts);
            panelProductId.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnAdd.setBackground(element.colours.get(3));
        btnAdd.setForeground(element.colours.get(1));
        btnAdd.setFont(element.fonts.get(0));
        btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelAdd.add(lblAddTitle);
        panelAdd.add(panelClientId);
        panelAdd.add(panelProductId);
        panelAdd.add(panelQuantity);
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


        lblUpdateClientID.setForeground(element.colours.get(0));
        lblUpdateClientID.setFont(element.fonts.get(2));
        lblUpdateClientID.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateClientID.setColumns(30);
        txtUpdateClientID.setFont(element.fonts.get(1));
        txtUpdateClientID.setMaximumSize(new Dimension(600, 40));
        txtUpdateClientID.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateClientID = new JPanel();
        panelUpdateClientID.setBackground(element.colours.get(4));
            panelUpdateClientID.add(lblUpdateClientID);
            panelUpdateClientID.add(txtUpdateClientID);
            panelUpdateClientID.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblUpdateQuantity.setForeground(element.colours.get(0));
        lblUpdateQuantity.setFont(element.fonts.get(2));
        lblUpdateQuantity.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateQuantity.setColumns(30);
        txtUpdateQuantity.setFont(element.fonts.get(1));
        txtUpdateQuantity.setMaximumSize(new Dimension(600, 40));
        txtUpdateQuantity.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateQuantity = new JPanel();
        panelUpdateQuantity.setBackground(element.colours.get(4));
        panelUpdateQuantity.add(lblUpdateQuantity);
        panelUpdateQuantity.add(txtUpdateQuantity);
        panelUpdateQuantity.setBorder(new EmptyBorder(0, 30, 10 ,30));

        lblUpdateProductID.setForeground(element.colours.get(0));
        lblUpdateProductID.setFont(element.fonts.get(2));
        lblUpdateProductID.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdateProductID.setColumns(30);
        txtUpdateProductID.setFont(element.fonts.get(1));
        txtUpdateProductID.setMaximumSize(new Dimension(600, 40));
        txtUpdateProductID.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdateProductID = new JPanel(new FlowLayout());
        panelUpdateProductID.setBackground(element.colours.get(4));
        panelUpdateProductID.add(lblUpdateProductID);
        panelUpdateProductID.add(txtUpdateProductID);
        panelUpdateProductID.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnUpdate.setBackground(element.colours.get(3));
        btnUpdate.setForeground(element.colours.get(1));
        btnUpdate.setFont(element.fonts.get(0));
        btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelEdit.add(lblUpdateTitle);
        panelEdit.add(panelUpdateID);
        panelEdit.add(panelUpdateClientID);
        panelEdit.add(panelUpdateQuantity);
        panelEdit.add(panelUpdateProductID);
        panelEdit.add(btnUpdate);
        panelEdit.add(new JLabel(" "));
        panelEdit.setLayout(new BoxLayout(panelEdit, BoxLayout.Y_AXIS));
        
// ------------ Delete panel
        panelRemove.setBackground(element.colours.get(4));

        lblRemoveTitle.setForeground(element.colours.get(0));
        lblRemoveTitle.setFont(element.fonts.get(3));
        lblRemoveTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblRemoveTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        /*
        lblRemoveSearchClientId.setForeground(element.colours.get(0));
        lblRemoveSearchClientId.setFont(element.fonts.get(2));
        lblRemoveSearchClientId.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtRemoveSearchClientId.setColumns(10);
        txtRemoveSearchClientId.setFont(element.fonts.get(1));
        txtRemoveSearchClientId.setMaximumSize(new Dimension(400, 40));
        txtRemoveSearchClientId.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelRemoveSearchClientId = new JPanel();
            panelRemoveSearchClientId.setBackground(element.colours.get(4));
            panelRemoveSearchClientId.add(lblRemoveSearchClientId);
            panelRemoveSearchClientId.add(txtRemoveSearchClientId);
            panelRemoveSearchClientId.setBorder(new EmptyBorder(0, 30, 10 ,30));
        */

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

// ------------ Show Orders
        panelView.setBackground(element.colours.get(4));

        lblShowAllTitle.setForeground(element.colours.get(0));
        lblShowAllTitle.setFont(element.fonts.get(3));
        lblShowAllTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblShowAllTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        tableOrders.setBounds(20, 20, 200, 300);
        tableOrders.setBackground(element.colours.get(1));
        tableOrders.setForeground(element.colours.get(3));
        tableOrders.setFont(element.fonts.get(4));

        panelView.add(lblShowAllTitle);
        panelView.add(tableOrders);

        mainPanel.add(panelAdd);
        mainPanel.add(panelEdit);
        mainPanel.add(panelRemove);
        mainPanel.add(panelView);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        orderFrame.add(mainPanel);
        orderFrame.setSize(500, 450);

        orderFrame.setVisible(true);
    }

}
