package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductView {
    Element element = new Element();

    JFrame productFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel panelAdd = new JPanel();
    JPanel panelEdit = new JPanel();
    JPanel panelRemove = new JPanel();
    JPanel panelView = new JPanel();

    //  ------------------------------------ panelAdd elements
    JLabel lblAddTitle = new JLabel("Add Product");

    JLabel lblAddName = new JLabel("Name:");
    JTextField txtAddName = new JTextField(25);
    JLabel lblAddQuantity = new JLabel("Quantity:");
    JTextField txtAddQuantity = new JTextField(25);
    JLabel lblAddPrice = new JLabel("Price:");
    JTextField txtAddPrice = new JTextField(25);

    JButton btnAdd = new JButton("Add");

    // ------------------------------------- panelRemove elements
    JLabel lblRemoveTitle = new JLabel("Remove Product");

    JLabel lblRemoveSearchName = new JLabel("Delete by name:");
    JTextField txtRemoveSearchName = new JTextField(5);
    JLabel lblRemoveSearchID = new JLabel("Delete by ID:");
    JTextField txtRemoveSearchID = new JTextField(25);

    JButton btnRemove = new JButton("Delete");

    // ------------------------------------- panelEdit elements
    JLabel lblUpdateTitle = new JLabel("Update Product");

    JLabel lblUpdateID = new JLabel("ID: ");
    JTextField txtUpdateID = new JTextField(5);
    JLabel lblUpdateName = new JLabel("Name:");
    JTextField txtUpdateName = new JTextField(25);
    JLabel lblUpdateQuantity = new JLabel("Quantity:");
    JTextField txtUpdateQuantity = new JTextField(25);
    JLabel lblUpdatePrice = new JLabel("Price:");
    JTextField txtUpdatePrice = new JTextField(25);

    JButton btnUpdate = new JButton("Update");

    // ------------------------------------- panelShow elements
    JLabel lblShowAllTitle = new JLabel("All Products");
    JTable tableProducts = new JTable();


    public ProductView(){
        productFrame.setBackground(element.colours.get(4));

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

        lblAddPrice.setForeground(element.colours.get(0));
        lblAddPrice.setFont(element.fonts.get(2));
        lblAddPrice.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtAddPrice.setColumns(30);
        txtAddPrice.setFont(element.fonts.get(1));
        txtAddPrice.setMaximumSize(new Dimension(600, 40));
        txtAddPrice.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelPrice = new JPanel(new FlowLayout());
            panelPrice.setBackground(element.colours.get(4));
            panelPrice.add(lblAddPrice);
            panelPrice.add(txtAddPrice);
            panelPrice.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnAdd.setBackground(element.colours.get(3));
        btnAdd.setForeground(element.colours.get(1));
        btnAdd.setFont(element.fonts.get(0));
        btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelAdd.add(lblAddTitle);
        panelAdd.add(panelName);
        panelAdd.add(panelQuantity);
        panelAdd.add(panelPrice);
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

        lblUpdatePrice.setForeground(element.colours.get(0));
        lblUpdatePrice.setFont(element.fonts.get(2));
        lblUpdatePrice.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtUpdatePrice.setColumns(30);
        txtUpdatePrice.setFont(element.fonts.get(1));
        txtUpdatePrice.setMaximumSize(new Dimension(600, 40));
        txtUpdatePrice.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelUpdatePrice = new JPanel(new FlowLayout());
            panelUpdatePrice.setBackground(element.colours.get(4));
            panelUpdatePrice.add(lblUpdatePrice);
            panelUpdatePrice.add(txtUpdatePrice);
            panelUpdatePrice.setBorder(new EmptyBorder(0, 30, 10 ,30));

        btnUpdate.setBackground(element.colours.get(3));
        btnUpdate.setForeground(element.colours.get(1));
        btnUpdate.setFont(element.fonts.get(0));
        btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelEdit.add(lblUpdateTitle);
        panelEdit.add(panelUpdateID);
        panelEdit.add(panelUpdateName);
        panelEdit.add(panelUpdateQuantity);
        panelEdit.add(panelUpdatePrice);
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
        lblRemoveSearchName.setForeground(element.colours.get(0));
        lblRemoveSearchName.setFont(element.fonts.get(2));
        lblRemoveSearchName.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        txtRemoveSearchName.setColumns(10);
        txtRemoveSearchName.setFont(element.fonts.get(1));
        txtRemoveSearchName.setMaximumSize(new Dimension(400, 40));
        txtRemoveSearchName.setAlignmentY(JTextField.CENTER_ALIGNMENT);

        JPanel panelRemoveSearchName = new JPanel();
            panelRemoveSearchName.setBackground(element.colours.get(4));
            panelRemoveSearchName.add(lblRemoveSearchName);
            panelRemoveSearchName.add(txtRemoveSearchName);
            panelRemoveSearchName.setBorder(new EmptyBorder(0, 30, 10 ,30));
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

// ------------ Show Products
        panelView.setBackground(element.colours.get(4));

        lblShowAllTitle.setForeground(element.colours.get(0));
        lblShowAllTitle.setFont(element.fonts.get(3));
        lblShowAllTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblShowAllTitle.setBorder(new EmptyBorder(0, 30, 20 ,30));

        tableProducts.setBounds(20, 20, 200, 300);
        tableProducts.setBackground(element.colours.get(1));
        tableProducts.setForeground(element.colours.get(3));
        tableProducts.setFont(element.fonts.get(4));

        panelView.add(lblShowAllTitle);
        panelView.add(tableProducts);

        mainPanel.add(panelAdd);
        mainPanel.add(panelEdit);
        mainPanel.add(panelRemove);
        mainPanel.add(panelView);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        productFrame.add(mainPanel);
        productFrame.setSize(500, 450);

        productFrame.setVisible(true);
    }

}
