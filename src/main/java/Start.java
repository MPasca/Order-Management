import BLL.ClientBLL;
import BLL.OrderBLL;
import BLL.ProductBLL;
import GUI.*;
import Model.*;

/**
 * The type Start.
 */
public class Start {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String [] args){
        Controller controller = new Controller();
/*
        Client client1 = new Client("Jane Doe", "abcd@abcd.com", "Str Ceahlau, nr 77, Cluj-Napoca, Cluj", "+40722222222");

        ClientBLL clientBLL = new ClientBLL();
        int clientId = clientBLL.insertClient(client1);


        Product product1 = new Product( "toDelete", 12, 2.34f);
        ProductBLL productBLL = new ProductBLL();
        int productId = productBLL.insertProduct(product1);

        if(productId > 0){
            System.out.println("Found product: " + productBLL.findProductByID(productId).toString() + " by ID");
        }

        Order order1 = new Order(clientId, productId, 5);
        OrderBLL orderBLL = new OrderBLL();
        int orderId = orderBLL.insertOrder(order1);

        System.out.println("Product: " + productBLL.deleteProduct(product1.getId()) + " has been deleted!");

        System.out.println("_________________________________________________");
        for(Client client : clientBLL.showAllClients()){
            System.out.println(client.toString());
            System.out.println("_________________________________________________");
        }

 */
    }
}
