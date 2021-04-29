package BLL;

import BLL.Validators.EmailValidator;
import BLL.Validators.TelephoneValidator;
import BLL.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    private List<Validator<Client>> validators;
    ClientDAO clientDAO = new ClientDAO();

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new TelephoneValidator());
    }

    public Client findClientByID(int id){
        Client client = clientDAO.findById(id);
        if(client == null){
            throw new NoSuchElementException("There is no client with id = " + id);
        }

        return client;
    }

    public int insertClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return clientDAO.insert(client);
    }

    public int updateClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return clientDAO.update(client);
    }

    public int deleteClient(int clientID){
        return clientDAO.delete(clientID);
    }

    public List<Client> showAllClients(){
        return clientDAO.findAll();
    }
}
