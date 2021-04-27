package Model;

public class Client {
    private String name;
    private String email;
    private String address;
    private String telephone;
    private int id;

    public Client(String name, String email, String address, String telephone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public Client(int id, String name, String email, String address, String telephone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setId(int id){
        this.id = id;
    }

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
