package Model;

public class Order {
    public int id;
    public int clientId;
    public int productId;
    public int quantity;

    public Order(){}


    public Order(int clientId, int productId, int quantity){
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Order(int id, int clientId, int productId, int quantity){
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getClientId() {
        return clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getClientID(){
        return clientId;
    }

    public int getProductID(){
        return productId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String toString(){
        return "Order [id=" + id +
                ", clientID=" + clientId +
                ", productID=" + productId +
                ", quantity=" + quantity + "]";
    }
}
