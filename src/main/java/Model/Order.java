package Model;

public class Order {
    private int id;
    private int clientId;
    private int productId;
    private int quantity;

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
