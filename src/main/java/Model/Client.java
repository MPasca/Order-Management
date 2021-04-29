package Model;

/**
 * The type Client.
 */
public class Client {

    /**
     * The Name.
     */
    public String name;
    /**
     * The Email.
     */
    public String email;
    /**
     * The Address.
     */
    public String address;
    /**
     * The Telephone.
     */
    public String telephone;
    /**
     * The Id.
     */
    public int id;

    /**
     * Instantiates a new Client.
     */
    public Client(){}

    /**
     * Instantiates a new Client.
     *
     * @param name      the name
     * @param email     the email
     * @param address   the address
     * @param telephone the telephone
     */
    public Client(String name, String email, String address, String telephone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    /**
     * Instantiates a new Client.
     *
     * @param id        the id
     * @param name      the name
     * @param email     the email
     * @param address   the address
     * @param telephone the telephone
     */
    public Client(int id, String name, String email, String address, String telephone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets telephone.
     *
     * @param telephone the telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Get email string.
     *
     * @return the string
     */
    public String getEmail(){
        return email;
    }

    /**
     * Get address string.
     *
     * @return the string
     */
    public String getAddress(){
        return address;
    }

    /**
     * Get telephone string.
     *
     * @return the string
     */
    public String getTelephone(){
        return telephone;
    }

    /**
     * Set id.
     *
     * @param id the id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Get id int.
     *
     * @return the int
     */
    public int getID(){
        return id;
    }

    public String toString(){
        return "Client [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", address=" + address +
                ", telephone=" + telephone + "]";
    }
}
