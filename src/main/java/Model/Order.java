package Model;

/**
 * The type Order.
 */
public class Order {
    /**
     * The Id.
     */
    public int id;
    /**
     * The Client id.
     */
    public int clientId;
    /**
     * The Product id.
     */
    public int productId;
    /**
     * The Quantity.
     */
    public int quantity;

    /**
     * Instantiates a new Order.
     */
    public Order(){}


    /**
     * Instantiates a new Order.
     *
     * @param clientId  the client id
     * @param productId the product id
     * @param quantity  the quantity
     */
    public Order(int clientId, int productId, int quantity){
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Order.
     *
     * @param id        the id
     * @param clientId  the client id
     * @param productId the product id
     * @param quantity  the quantity
     */
    public Order(int id, int clientId, int productId, int quantity){
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get client id int.
     *
     * @return the int
     */
    public int getClientID(){
        return clientId;
    }

    /**
     * Get product id int.
     *
     * @return the int
     */
    public int getProductID(){
        return productId;
    }

    /**
     * Get quantity int.
     *
     * @return the int
     */
    public int getQuantity(){
        return quantity;
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
