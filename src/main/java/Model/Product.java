package Model;

/**
 * The type Product.
 */
public class Product {
    /**
     * The Id.
     */
    public int id;
    /**
     * The Name.
     */
    public String name;
    /**
     * The Quantity.
     */
    public int quantity;
    /**
     * The Price.
     */
    public float price;

    /**
     * Instantiates a new Product.
     */
    public Product(){}

    /**
     * Instantiates a new Product.
     *
     * @param name     the name
     * @param quantity the quantity
     * @param price    the price
     */
    public Product(String name, int quantity, float price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Instantiates a new Product.
     *
     * @param id       the id
     * @param name     the name
     * @param quantity the quantity
     * @param price    the price
     */
    public Product(int id, String name, int quantity, float price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get id int.
     *
     * @return the int
     */
    public int getId(){
        return id;
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
     * Update quantity.
     *
     * @param orderedQuantity the ordered quantity
     */
    public void updateQuantity(int orderedQuantity){
        this.quantity -= orderedQuantity;
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
     * Get price float.
     *
     * @return the float
     */
    public float getPrice(){
        return price;
    }

    public String toString(){
        return "Product [id=" + id +
                ", name=" + name +
                ", quantity=" + quantity + "]";
    }
}
