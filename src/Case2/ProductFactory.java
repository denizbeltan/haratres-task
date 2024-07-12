package Case2;

import java.util.ArrayList;

public class ProductFactory {
    private ArrayList<Product> productList = new ArrayList<Product>();

    public ProductFactory() {
    }

    public static Product createProduct(String name, double price, int quantity, double score) throws IllegalArgumentException {
        return new Product(name, price, quantity, score);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    public ArrayList<Product> sortProducts(String orderBy, String direction) {
        ArrayList<Product> sortedProducts = new ArrayList<>(productList);

        switch (orderBy) {
            case "price":
                sortedProducts.sort((p1, p2) -> {
                    if (direction.equals("asc")) {
                        return Double.compare(p1.getPrice(), p2.getPrice());
                    } else {
                        return Double.compare(p2.getPrice(), p1.getPrice());
                    }
                });
                break;
            case "quantity":
                sortedProducts.sort((p1, p2) -> {
                    if (direction.equals("asc")) {
                        return Integer.compare(p1.getQuantity(), p2.getQuantity());
                    } else {
                        return Integer.compare(p2.getQuantity(), p1.getQuantity());
                    }
                });
                break;
            case "score":
                sortedProducts.sort((p1, p2) -> {
                    if (direction.equals("asc")) {
                        return Double.compare(p1.getScore(), p2.getScore());
                    } else {
                        return Double.compare(p2.getScore(), p1.getScore());
                    }
                });
                break;
        }

        return sortedProducts;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
