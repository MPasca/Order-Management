package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Controller.
 */
public class Controller {
    /**
     * The View.
     */
    View view = new View();

    /**
     * Instantiates a new Controller.
     */
    public Controller(){
        view.addClientListener(new ClientListener());
        view.addProductListener(new ProductListener());
        view.addOrderListener(new OrderListener());
        view.addBackClientListener(new BackClientListener());
        view.addBackProductListener(new BackProductListener());
        view.addBackOrderListener(new BackOrderListener());

        view.addAddClientListener(new AddClientListener());
        view.addRemoveClientListener(new RemoveClientListener());
        view.addEditClientListener(new EditClientListener());
        view.addViewClientListener(new ViewClientsListener());

        view.addAddProductListener(new AddProductListener());
        view.addRemoveProductListener(new RemoveProductListener());
        view.addEditProductListener(new EditProductListener());
        view.addViewProductListener(new ViewProductsListener());

        view.addAddOrderListener(new AddOrderListener());
        view.addRemoveOrderListener(new RemoveOrderListener());
        view.addEditOrderListener(new EditOrderListener());
        view.addViewOrderListener(new ViewOrdersListener());

    }

    /**
     * The type Client listener.
     */
    class ClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 380));
            view.clientPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    /**
     * The type Product listener.
     */
    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 380));
            view.productPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    /**
     * The type Order listener.
     */
    class OrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 380));
            view.orderPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    /**
     * The type Back client listener.
     */
    class BackClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.clientPanel.setVisible(false);
        }
    }

    /**
     * The type Back product listener.
     */
    class BackProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.productPanel.setVisible(false);
        }
    }

    /**
     * The type Back order listener.
     */
    class BackOrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.orderPanel.setVisible(false);
        }
    }

    /**
     * The type Add client listener.
     */
// ------------------------- Client buttons
    class AddClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
            clientView.panelEdit.setVisible(false);
            clientView.panelRemove.setVisible(false);
            clientView.panelView.setVisible(false);
            ClientController clientController = new ClientController(clientView);
        }
    }

    /**
     * The type Remove client listener.
     */
    class RemoveClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
            clientView.panelEdit.setVisible(false);
            clientView.panelAdd.setVisible(false);
            clientView.panelView.setVisible(false);
            ClientController clientController = new ClientController(clientView);
        }
    }

    /**
     * The type Edit client listener.
     */
    class EditClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
            clientView.panelRemove.setVisible(false);
            clientView.panelAdd.setVisible(false);
            clientView.panelView.setVisible(false);
            ClientController clientController = new ClientController(clientView);
        }
    }

    /**
     * The type View clients listener.
     */
    class ViewClientsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
            clientView.panelEdit.setVisible(false);
            clientView.panelAdd.setVisible(false);
            clientView.panelRemove.setVisible(false);
            ClientController clientController = new ClientController(clientView);
            clientController.showAll();
        }
    }
// ----------------------------------------

    /**
     * The type Add product listener.
     */
// ------------------------ Product buttons
    class AddProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductView productView = new ProductView();
            productView.panelEdit.setVisible(false);
            productView.panelRemove.setVisible(false);
            productView.panelView.setVisible(false);
            ProductController productController = new ProductController(productView);
        }
    }

    /**
     * The type Remove product listener.
     */
    class RemoveProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductView productView = new ProductView();
            productView.panelEdit.setVisible(false);
            productView.panelAdd.setVisible(false);
            productView.panelView.setVisible(false);
            ProductController productController = new ProductController(productView);
        }
    }

    /**
     * The type Edit product listener.
     */
    class EditProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductView productView = new ProductView();
            productView.panelRemove.setVisible(false);
            productView.panelAdd.setVisible(false);
            productView.panelView.setVisible(false);
            ProductController productController = new ProductController(productView);
        }
    }

    /**
     * The type View products listener.
     */
    class ViewProductsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductView productView = new ProductView();
            productView.panelEdit.setVisible(false);
            productView.panelAdd.setVisible(false);
            productView.panelRemove.setVisible(false);
            ProductController productController = new ProductController(productView);
            productController.showAll();
        }
    }

    /**
     * The type Add order listener.
     */
// ------------------------ Order buttons
    class AddOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            orderView.panelEdit.setVisible(false);
            orderView.panelRemove.setVisible(false);
            orderView.panelView.setVisible(false);
            OrderController orderController = new OrderController(orderView);
            orderController.generateComboBoxes();
        }
    }

    /**
     * The type Remove order listener.
     */
    class RemoveOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            orderView.panelEdit.setVisible(false);
            orderView.panelAdd.setVisible(false);
            orderView.panelView.setVisible(false);
            OrderController orderController = new OrderController(orderView);
        }
    }

    /**
     * The type Edit order listener.
     */
    class EditOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            orderView.panelRemove.setVisible(false);
            orderView.panelAdd.setVisible(false);
            orderView.panelView.setVisible(false);
            OrderController orderController = new OrderController(orderView);
        }
    }

    /**
     * The type View orders listener.
     */
    class ViewOrdersListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            orderView.panelEdit.setVisible(false);
            orderView.panelAdd.setVisible(false);
            orderView.panelRemove.setVisible(false);
            OrderController orderController = new OrderController(orderView);
            orderController.showAll();
        }
    }

}


