package GUI;

import Model.Client;

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

    class AddClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientView clientView = new ClientView();
        }
    }
}


