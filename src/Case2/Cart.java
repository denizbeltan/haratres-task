package Case2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public Cart() {}

    public void addProduct(Product product, int quantity) {
        this.products.add(new Product(product.getName(), product.getPrice(), quantity, product.getScore()));
        System.out.println("Case2.Product " + product.getName() + " added to the cart");
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (Product product : this.products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }

        for (int i = 1; i < products.size(); i++) {
            Product previousProduct = products.get(i - 1);
            Product currentProduct = products.get(i);

            if (previousProduct.getPrice() > currentProduct.getPrice()) {
                double discount = currentProduct.getPrice();
                totalPrice -= discount * previousProduct.getQuantity();
                previousProduct.setPrice(previousProduct.getPrice() - discount);
            }
        }

        System.out.println("Your cart:");
        for (Product product : this.products) {
            System.out.println(product.getName() + ": " + product.getPrice() + " TL x " + product.getQuantity() + " = " + product.getPrice() * product.getQuantity() + " TL");
        }

        return totalPrice;
    }
}
