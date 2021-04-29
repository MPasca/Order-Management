package GUI;


import BLL.ClientBLL;
import Model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Client controller.
 */
public class ClientController {
    /**
     * The Client view.
     */
    ClientView clientView;
    /**
     * The Client bll.
     */
    ClientBLL clientBLL = new ClientBLL();

    /**
     * Instantiates a new Client controller.
     *
     * @param clientView the client view
     */
    public ClientController(ClientView clientView){
        this.clientView = clientView;
        this.clientView.btnAdd.addActionListener(new AddListener());
        this.clientView.btnRemove.addActionListener(new DeleteListener());
        this.clientView.btnUpdate.addActionListener(new UpdateListener());
    }

    /**
     * Add client.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void addClient() throws ExceptionIncorrectInput{
        if(clientView.txtAddName.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelAdd, "ClientView", "clientName");
        }
        String clientName = clientView.txtAddName.getText();

        if(clientView.txtAddEmail.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelAdd,"ClientView", "clientEmail");
        }
        String clientEmail = clientView.txtAddEmail.getText();

        if(clientView.txtAddAddress.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelAdd, "ClientView", "clientAddress");
        }
        String clientAddress = clientView.txtAddAddress.getText();

        if(clientView.txtAddTelephone.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelAdd, "ClientView", "clientTelephone");
        }
        String clientTelephone = clientView.txtAddTelephone.getText();

        Client newClient = new Client(clientName, clientEmail, clientAddress, clientTelephone);
        int clientId = clientBLL.insertClient(newClient);
        JOptionPane.showMessageDialog(clientView.panelAdd, "The client with id: " + clientId + " has been added to the DataBase.");
    }

    /**
     * The type Add listener.
     */
    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try {
                addClient();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Delete client.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void deleteClient() throws ExceptionIncorrectInput{
        if(clientView.txtRemoveSearchName.getText().isEmpty()){
            if(clientView.txtRemoveSearchID.getText().isEmpty()){
                throw new ExceptionIncorrectInput(clientView.panelRemove, "clientView", "removeSearchID");
            }
            int idToDelete = Integer.parseInt(clientView.txtRemoveSearchID.getText());
            JOptionPane.showMessageDialog(clientView.panelRemove, "The client with id: " + clientBLL.deleteClient(idToDelete) + " has been successfully deleted.");
        }
    }

    /**
     * The type Delete listener.
     */
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deleteClient();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Update client.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void updateClient() throws ExceptionIncorrectInput{
        if(clientView.txtUpdateName.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelEdit, "clientView", "updateName");
        }
        if(clientView.txtUpdateEmail.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelEdit, "clientView", "updateEmail");
        }
        if(clientView.txtUpdateAddress.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelEdit, "clientView", "updateAddress");
        }
        if(clientView.txtUpdateTelephone.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelEdit, "clientView", "updateTelephone");
        }
        if(clientView.txtUpdateID.getText().isEmpty()){
            throw new ExceptionIncorrectInput(clientView.panelEdit, "clientView", "updateID");
        }

        String name = clientView.txtUpdateName.getText();
        String email = clientView.txtUpdateEmail.getText();
        String address = clientView.txtUpdateAddress.getText();
        String telephone = clientView.txtUpdateAddress.getText();
        int id = Integer.parseInt(clientView.txtUpdateID.getText());

        Client toUpdate = new Client(id, name, email, address, telephone);
        JOptionPane.showMessageDialog(clientView.panelEdit, "The client with id: " + clientBLL.updateClient(toUpdate) + " has been successfully updated.");
    }

    /**
     * The type Update listener.
     */
    class UpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                updateClient();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Show all.
     */
    public void showAll(){

        String columns[] = {"ID", "Name", "Email", "Address", "Telephone"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        clientView.tableClients.setModel(model);
        List<Client> allClients = clientBLL.showAllClients();
        model.addRow(columns);
        for(Client c: allClients){
            String[] currentClient = {Integer.toString(c.getID()), c.getName(), c.getEmail(), c.getAddress(), c.getTelephone()};
            model.addRow(currentClient);
        }

        clientView.tableClients.setBounds(20, 20, 400, 300);
        clientView.tableClients.setBackground(clientView.element.colours.get(5));
        clientView.tableClients.setFont(clientView.element.fonts.get(5));
        JScrollPane scrollPane = new JScrollPane(clientView.tableClients);
        clientView.clientFrame.add(scrollPane);
    }

}
