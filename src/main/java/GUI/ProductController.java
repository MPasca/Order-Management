package GUI;


import BLL.ProductBLL;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Product controller.
 */
public class ProductController {
    /**
     * The Product view.
     */
    ProductView productView;
    /**
     * The Product bll.
     */
    ProductBLL productBLL = new ProductBLL();

    /**
     * Instantiates a new Product controller.
     *
     * @param ProductView the product view
     */
    public ProductController(ProductView ProductView){
        this.productView = ProductView;
        this.productView.btnAdd.addActionListener(new AddListener());
        this.productView.btnRemove.addActionListener(new DeleteListener());
        this.productView.btnUpdate.addActionListener(new UpdateListener());
    }

    /**
     * Add product.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void addProduct() throws ExceptionIncorrectInput{
        if(productView.txtAddName.getText().isEmpty()){
            throw new ExceptionIncorrectInput(productView.panelAdd, "productView", "productName");
        }
        String productName = productView.txtAddName.getText();

        if(productView.txtAddQuantity.getText().isEmpty()){
            throw new ExceptionIncorrectInput(productView.panelAdd,"productView", "productQuantity");
        }
        int productQuantity = Integer.parseInt(productView.txtAddQuantity.getText());

        if(productView.txtAddPrice.getText().isEmpty()){
            throw new ExceptionIncorrectInput(productView.panelAdd, "productView", "productPrice");
        }
        float productPrice = Float.parseFloat(productView.txtAddPrice.getText());

        Product newProduct = new Product(productName, productQuantity, productPrice);
        int ProductId = productBLL.insertProduct(newProduct);
        JOptionPane.showMessageDialog(productView.panelAdd, "The Product with id: " + ProductId + " has been added to the DataBase.");
    }

    /**
     * The type Add listener.
     */
    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try {
                addProduct();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Delete product.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void deleteProduct() throws ExceptionIncorrectInput{
        if(productView.txtRemoveSearchName.getText().isEmpty()){
            if(productView.txtRemoveSearchID.getText().isEmpty()){
                throw new ExceptionIncorrectInput(productView.panelRemove, "ProductView", "removeSearchID");
            }
            int idToDelete = Integer.parseInt(productView.txtRemoveSearchID.getText());
            JOptionPane.showMessageDialog(productView.panelRemove, "The Product with id: " + productBLL.deleteProduct(idToDelete) + " has been successfully deleted.");
        }
    }

    /**
     * The type Delete listener.
     */
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deleteProduct();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Update product.
     *
     * @throws ExceptionIncorrectInput the exception incorrect input
     */
    public void updateProduct() throws ExceptionIncorrectInput{
            if(productView.txtUpdateName.getText().isEmpty()){
                throw new ExceptionIncorrectInput(productView.panelEdit, "productView", "updateName");
            }
            if(productView.txtUpdateQuantity.getText().isEmpty()){
                throw new ExceptionIncorrectInput(productView.panelEdit, "productView", "updateQuantity");
            }
            if(productView.txtUpdatePrice.getText().isEmpty()){
                throw new ExceptionIncorrectInput(productView.panelEdit, "productView", "updatePrice");
            }
            if(productView.txtUpdateID.getText().isEmpty()){
                throw new ExceptionIncorrectInput(productView.panelEdit, "productView", "updateID");
            }

            String name = productView.txtUpdateName.getText();
            int quantity = Integer.parseInt(productView.txtUpdateQuantity.getText());
            float price = Float.parseFloat(productView.txtUpdatePrice.getText());
            int id = Integer.parseInt(productView.txtUpdateID.getText());

            Product toUpdate = new Product(id, name, quantity, price);
            JOptionPane.showMessageDialog(productView.panelEdit, "The product with id: " + productBLL.updateProduct(toUpdate) + " has been successfully updated.");
    }

    /**
     * The type Update listener.
     */
    class UpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                updateProduct();
            } catch (ExceptionIncorrectInput exceptionIncorrectInput) {
                exceptionIncorrectInput.printStackTrace();
            }
        }
    }

    /**
     * Show all.
     */
    public void showAll(){
        String productColumns[] = {"ID", "Name", "Quantity", "Price"};
        DefaultTableModel model = new DefaultTableModel(productColumns, 0);

        productView.tableProducts.setModel(model);
        List<Product> allProducts = productBLL.showAllProducts();
        model.addRow(productColumns);
        for(Product p: allProducts){
            String[] currentProduct = {Integer.toString(p.getId()), p.getName(), Integer.toString(p.getQuantity()), Float.toString(p.getPrice())};
            model.addRow(currentProduct);
        }

        productView.tableProducts.setBounds(20, 20, 400, 300);
        productView.tableProducts.setBackground(productView.element.colours.get(5));
        productView.tableProducts.setFont(productView.element.fonts.get(5));
        JScrollPane scrollPane = new JScrollPane(productView.tableProducts);
        productView.productFrame.add(scrollPane);
    }
}
