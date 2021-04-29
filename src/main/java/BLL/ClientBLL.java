package BLL;

import BLL.Validators.EmailValidator;
import BLL.Validators.TelephoneValidator;
import BLL.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Client bll.
 */
public class ClientBLL {
    private List<Validator<Client>> validators;
    /**
     * The Client dao.
     */
    ClientDAO clientDAO = new ClientDAO();

    /**
     * Instantiates a new Client bll.
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new TelephoneValidator());
    }

    /**
     * finds client by id
     *
     * @param id the id
     * @return client client
     */
    public Client findClientByID(int id){
        Client client = clientDAO.findById(id);
        if(client == null){
            throw new NoSuchElementException("There is no client with id = " + id);
        }

        return client;
    }

    /**
     * inserts client
     *
     * @param client the client
     * @return int int
     */
    public int insertClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return clientDAO.insert(client);
    }

    /**
     * updates client
     *
     * @param client the client
     * @return int int
     */
    public int updateClient(Client client){
        for(Validator<Client> v : validators){
            v.validate(client);
        }

        return clientDAO.update(client);
    }

    /**
     * deletes given client
     *
     * @param clientID the client id
     * @return int int
     */
    public int deleteClient(int clientID){
        return clientDAO.delete(clientID);
    }

    /**
     * shows all clients
     *
     * @return list list
     */
    public List<Client> showAllClients(){
        return clientDAO.findAll();
    }
}
