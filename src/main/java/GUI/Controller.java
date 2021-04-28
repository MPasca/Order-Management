package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View view = new View();

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

    class ClientListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 330));
            view.clientPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 330));
            view.productPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    class OrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 330));
            view.orderPanel.setVisible(true);
            view.mainPanel.setVisible(false);
        }
    }

    class BackClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.clientPanel.setVisible(false);
        }
    }

    class BackProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.productPanel.setVisible(false);
        }
    }

    class BackOrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.mainFrame.setSize(new Dimension(460, 280));
            view.mainPanel.setVisible(true);
            view.orderPanel.setVisible(false);
        }
    }

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

// ------------------------ Order buttons
    class AddOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderView orderView = new OrderView();
            orderView.panelEdit.setVisible(false);
            orderView.panelRemove.setVisible(false);
            orderView.panelView.setVisible(false);
            OrderController orderController = new OrderController(orderView);
            orderController.showAll();
        }
    }

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


