package GUI;

import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type View.
 */
public class View {
    /**
     * The Element.
     */
    Element element = new Element();
    /**
     * The Btn client back.
     */
    JButton btnClientBack = new JButton("Back");
    /**
     * The Btn order back.
     */
    JButton btnOrderBack = new JButton("Back");
    /**
     * The Btn product back.
     */
    JButton btnProductBack = new JButton("Back");
    /**
     * The Main frame.
     */
    JFrame mainFrame = new JFrame("Order Management");

    /**
     * The Main panel.
     */
    JPanel mainPanel = new JPanel();
    /**
     * The Lbl main title.
     */
    JLabel lblMainTitle = new JLabel("Order Management");
    /**
     * The Btn client.
     */
    JButton btnClient = new JButton("Clients menu");
    /**
     * The Btn product.
     */
    JButton btnProduct = new JButton("Products menu");
    /**
     * The Btn order.
     */
    JButton btnOrder = new JButton("Orders menu");

    /**
     * The Client panel.
     */
    JPanel clientPanel = new JPanel();
    /**
     * The Lbl client title.
     */
    JLabel lblClientTitle = new JLabel("Clients menu");
    /**
     * The Btn add client.
     */
    JButton btnAddClient = new JButton("Add client");
    /**
     * The Btn remove client.
     */
    JButton btnRemoveClient = new JButton("Remove client");
    /**
     * The Btn edit client.
     */
    JButton btnEditClient = new JButton("Edit client");
    /**
     * The Btn view client.
     */
    JButton btnViewClient = new JButton("View clients");

    /**
     * The Product panel.
     */
    JPanel productPanel = new JPanel();
    /**
     * The Lbl product title.
     */
    JLabel lblProductTitle = new JLabel("Products menu");
    /**
     * The Btn add product.
     */
    JButton btnAddProduct = new JButton("Add product");
    /**
     * The Btn remove product.
     */
    JButton btnRemoveProduct = new JButton("Remove product");
    /**
     * The Btn edit product.
     */
    JButton btnEditProduct = new JButton("Edit product");
    /**
     * The Btn view product.
     */
    JButton btnViewProduct = new JButton("View products");

    /**
     * The Order panel.
     */
    JPanel orderPanel = new JPanel();
    /**
     * The Lbl order title.
     */
    JLabel lblOrderTitle = new JLabel("Orders menu");
    /**
     * The Btn add order.
     */
    JButton btnAddOrder = new JButton("Add order");
    /**
     * The Btn remove order.
     */
    JButton btnRemoveOrder = new JButton("Remove order");
    /**
     * The Btn edit order.
     */
    JButton btnEditOrder = new JButton("Edit order");
    /**
     * The Btn view order.
     */
    JButton btnViewOrder = new JButton("View orders");

    /**
     * Instantiates a new View.
     */
    public View(){
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(460, 280);

        mainFrame.setBackground(element.colours.get(4));

        btnClient.setBackground(element.colours.get(3));
        btnClient.setForeground(element.colours.get(1));
        btnClient.setFont(element.fonts.get(0));
        btnClient.setAlignmentX(Component.CENTER_ALIGNMENT);


// ----------------- Main Panel
       lblMainTitle.setForeground(element.colours.get(0));
       lblMainTitle.setFont(element.fonts.get(3));
       lblMainTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
       lblMainTitle.setBorder(new EmptyBorder(0, 30, 50 ,30));

       btnClientBack.setBackground(element.colours.get(3));
       btnClientBack.setForeground(element.colours.get(1));
       btnClientBack.setFont(element.fonts.get(0));
       btnClientBack.setAlignmentX(Component.CENTER_ALIGNMENT);

       btnProductBack.setBackground(element.colours.get(3));
       btnProductBack.setForeground(element.colours.get(1));
       btnProductBack.setFont(element.fonts.get(0));
       btnProductBack.setAlignmentX(Component.CENTER_ALIGNMENT);

       btnOrderBack.setBackground(element.colours.get(3));
       btnOrderBack.setForeground(element.colours.get(1));
       btnOrderBack.setFont(element.fonts.get(0));
       btnOrderBack.setAlignmentX(Component.CENTER_ALIGNMENT);


       btnProduct.setBackground(element.colours.get(3));
       btnProduct.setForeground(element.colours.get(1));
       btnProduct.setFont(element.fonts.get(0));
       btnProduct.setAlignmentX(Component.CENTER_ALIGNMENT);

       btnOrder.setBackground(element.colours.get(3));
       btnOrder.setForeground(element.colours.get(1));
       btnOrder.setFont(element.fonts.get(0));
       btnOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

       mainPanel.add(lblMainTitle);
       mainPanel.add(btnClient);
       mainPanel.add(new JLabel(" "));
       mainPanel.add(btnProduct);
       mainPanel.add(new JLabel(" "));
       mainPanel.add(btnOrder);
       mainPanel.add(new JLabel(" "));

       mainPanel.setBackground(element.colours.get(4));
       mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
       mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// ----------------- Client Panel
        lblClientTitle.setForeground(element.colours.get(0));
        lblClientTitle.setFont(element.fonts.get(3));
        lblClientTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblClientTitle.setBorder(new EmptyBorder(0, 78, 50 ,78));

        btnAddClient.setBackground(element.colours.get(3));
        btnAddClient.setForeground(element.colours.get(1));
        btnAddClient.setFont(element.fonts.get(0));
        btnAddClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRemoveClient.setBackground(element.colours.get(3));
        btnRemoveClient.setForeground(element.colours.get(1));
        btnRemoveClient.setFont(element.fonts.get(0));
        btnRemoveClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEditClient.setBackground(element.colours.get(3));
        btnEditClient.setForeground(element.colours.get(1));
        btnEditClient.setFont(element.fonts.get(0));
        btnEditClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnViewClient.setBackground(element.colours.get(3));
        btnViewClient.setForeground(element.colours.get(1));
        btnViewClient.setFont(element.fonts.get(0));
        btnViewClient.setAlignmentX(Component.CENTER_ALIGNMENT);

        clientPanel.add(lblClientTitle);
        clientPanel.add(btnAddClient);
        clientPanel.add(new JLabel(" "));
        clientPanel.add(btnRemoveClient);
        clientPanel.add(new JLabel(" "));
        clientPanel.add(btnEditClient);
        clientPanel.add(new JLabel(" "));
        clientPanel.add(btnViewClient);
        clientPanel.add(new JLabel(" "));
        clientPanel.add(btnClientBack);
        clientPanel.add(new JLabel(" "));

        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.PAGE_AXIS));
        clientPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        clientPanel.setBackground(element.colours.get(4));

// ----------------- Product Panel
        lblProductTitle.setForeground(element.colours.get(0));
        lblProductTitle.setFont(element.fonts.get(3));
        lblProductTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblProductTitle.setBorder(new EmptyBorder(0, 66, 50 ,66));

        btnAddProduct.setBackground(element.colours.get(3));
        btnAddProduct.setForeground(element.colours.get(1));
        btnAddProduct.setFont(element.fonts.get(0));
        btnAddProduct.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRemoveProduct.setBackground(element.colours.get(3));
        btnRemoveProduct.setForeground(element.colours.get(1));
        btnRemoveProduct.setFont(element.fonts.get(0));
        btnRemoveProduct.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEditProduct.setBackground(element.colours.get(3));
        btnEditProduct.setForeground(element.colours.get(1));
        btnEditProduct.setFont(element.fonts.get(0));
        btnEditProduct.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnViewProduct.setBackground(element.colours.get(3));
        btnViewProduct.setForeground(element.colours.get(1));
        btnViewProduct.setFont(element.fonts.get(0));
        btnViewProduct.setAlignmentX(Component.CENTER_ALIGNMENT);

        productPanel.add(lblProductTitle);
        productPanel.add(btnAddProduct);
        productPanel.add(new JLabel(" "));
        productPanel.add(btnRemoveProduct);
        productPanel.add(new JLabel(" "));
        productPanel.add(btnEditProduct);
        productPanel.add(new JLabel(" "));
        productPanel.add(btnViewProduct);
        productPanel.add(new JLabel(" "));
        productPanel.add(btnProductBack);
        productPanel.add(new JLabel(" "));

        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.PAGE_AXIS));
        productPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        productPanel.setBackground(element.colours.get(4));


// ----------------- Order Panel
        lblOrderTitle.setForeground(element.colours.get(0));
        lblOrderTitle.setFont(element.fonts.get(3));
        lblOrderTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblOrderTitle.setBorder(new EmptyBorder(0, 90, 50 ,90));

        btnAddOrder.setBackground(element.colours.get(3));
        btnAddOrder.setForeground(element.colours.get(1));
        btnAddOrder.setFont(element.fonts.get(0));
        btnAddOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRemoveOrder.setBackground(element.colours.get(3));
        btnRemoveOrder.setForeground(element.colours.get(1));
        btnRemoveOrder.setFont(element.fonts.get(0));
        btnRemoveOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEditOrder.setBackground(element.colours.get(3));
        btnEditOrder.setForeground(element.colours.get(1));
        btnEditOrder.setFont(element.fonts.get(0));
        btnEditOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnViewOrder.setBackground(element.colours.get(3));
        btnViewOrder.setForeground(element.colours.get(1));
        btnViewOrder.setFont(element.fonts.get(0));
        btnViewOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

        orderPanel.add(lblOrderTitle);
        orderPanel.add(btnAddOrder);
        orderPanel.add(new JLabel(" "));
        orderPanel.add(btnRemoveOrder);
        orderPanel.add(new JLabel(" "));
        orderPanel.add(btnEditOrder);
        orderPanel.add(new JLabel(" "));
        orderPanel.add(btnViewOrder);
        orderPanel.add(new JLabel(" "));
        orderPanel.add(btnOrderBack);
        orderPanel.add(new JLabel(" "));

        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.PAGE_AXIS));
        orderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderPanel.setBackground(element.colours.get(4));

// ----------------- Main Frame
        mainFrame.add(mainPanel);
        mainFrame.add(clientPanel);
        mainFrame.add(productPanel);
        mainFrame.add(orderPanel);

        clientPanel.setVisible(false);
        productPanel.setVisible(false);
        orderPanel.setVisible(false);

        mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        mainFrame.setVisible(true);
    }

    /**
     * Add client listener.
     *
     * @param actionListener the action listener
     */
    public void addClientListener(ActionListener actionListener){
        btnClient.addActionListener(actionListener);
    }

    /**
     * Add product listener.
     *
     * @param actionListener the action listener
     */
    public void addProductListener(ActionListener actionListener){
        btnProduct.addActionListener(actionListener);
    }

    /**
     * Add order listener.
     *
     * @param actionListener the action listener
     */
    public void addOrderListener(ActionListener actionListener){
        btnOrder.addActionListener(actionListener);
    }

    /**
     * Add back client listener.
     *
     * @param actionListener the action listener
     */
    public void addBackClientListener(ActionListener actionListener){
        btnClientBack.addActionListener(actionListener);
    }

    /**
     * Add back product listener.
     *
     * @param actionListener the action listener
     */
    public void addBackProductListener(ActionListener actionListener){
        btnProductBack.addActionListener(actionListener);
    }

    /**
     * Add back order listener.
     *
     * @param actionListener the action listener
     */
    public void addBackOrderListener(ActionListener actionListener){
        btnOrderBack.addActionListener(actionListener);
    }


    /**
     * Add add client listener.
     *
     * @param actionListener the action listener
     */
    public void addAddClientListener(ActionListener actionListener){
        btnAddClient.addActionListener(actionListener);
    }

    /**
     * Add remove client listener.
     *
     * @param actionListener the action listener
     */
    public void addRemoveClientListener(ActionListener actionListener){
        btnRemoveClient.addActionListener(actionListener);
    }

    /**
     * Add edit client listener.
     *
     * @param actionListener the action listener
     */
    public void addEditClientListener(ActionListener actionListener){
        btnEditClient.addActionListener(actionListener);
    }

    /**
     * Add view client listener.
     *
     * @param actionListener the action listener
     */
    public void addViewClientListener(ActionListener actionListener){
        btnViewClient.addActionListener(actionListener);
    }


    /**
     * Add add product listener.
     *
     * @param actionListener the action listener
     */
    public void addAddProductListener(ActionListener actionListener){
        btnAddProduct.addActionListener(actionListener);
    }

    /**
     * Add remove product listener.
     *
     * @param actionListener the action listener
     */
    public void addRemoveProductListener(ActionListener actionListener){
        btnRemoveProduct.addActionListener(actionListener);
    }

    /**
     * Add edit product listener.
     *
     * @param actionListener the action listener
     */
    public void addEditProductListener(ActionListener actionListener){
        btnEditProduct.addActionListener(actionListener);
    }

    /**
     * Add view product listener.
     *
     * @param actionListener the action listener
     */
    public void addViewProductListener(ActionListener actionListener){
        btnViewProduct.addActionListener(actionListener);
    }


    /**
     * Add add order listener.
     *
     * @param actionListener the action listener
     */
    public void addAddOrderListener(ActionListener actionListener){
        btnAddOrder.addActionListener(actionListener);
    }

    /**
     * Add remove order listener.
     *
     * @param actionListener the action listener
     */
    public void addRemoveOrderListener(ActionListener actionListener){
        btnRemoveOrder.addActionListener(actionListener);
    }

    /**
     * Add edit order listener.
     *
     * @param actionListener the action listener
     */
    public void addEditOrderListener(ActionListener actionListener){
        btnEditOrder.addActionListener(actionListener);
    }

    /**
     * Add view order listener.
     *
     * @param actionListener the action listener
     */
    public void addViewOrderListener(ActionListener actionListener){
        btnViewOrder.addActionListener(actionListener);
    }

}
