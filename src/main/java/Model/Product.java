package Model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private float price;

    public Product(String name, int quantity, float price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int id, String name, int quantity, float price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public void updateQuantity(int orderedQuantity){
        this.quantity -= orderedQuantity;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public String toString(){
        return "Product [id=" + id +
                ", name=" + name +
                ", quantity=" + quantity + "]";
    }
}
