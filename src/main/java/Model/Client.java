package Model;

public class Client {
    public String name;
    public String email;
    public String address;
    public String telephone;
    public int id;

    public Client(){}

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

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
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
