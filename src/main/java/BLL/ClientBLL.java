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

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new TelephoneValidator());
    }

    public Client findClientByID(int id){
        Client client = ClientDAO.find(id);
        if(client == null){
            throw new NoSuchElementException("There is no client with id = " + id);
        }

        return client;
    }

    public List<Client> findClientByName(String name){
        List<Client> fetchedClients = ClientDAO.find(name);
        if(fetchedClients == null){
            throw new NoSuchElementException("There are no clients named: " + name);
        }

        return fetchedClients;
    }

    public int insertClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return ClientDAO.insertClient(client);
    }

    public int updateClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return ClientDAO.updateClient(client);
    }

    public int deleteClient(int clientID){
        return ClientDAO.deleteClient(clientID);
    }

    public List<Client> showAllClients(){
        return ClientDAO.showAllClients();
    }
}
