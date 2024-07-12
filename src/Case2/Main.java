package Case2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductFactory productFactory = new ProductFactory();

        System.out.println("Enter the number of products:");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        boolean validNumberOfProducts = numberOfProducts > 1;
        while (!validNumberOfProducts) {
            numberOfProducts = Integer.parseInt(scanner.nextLine());
            if (numberOfProducts <= 1) {
                System.out.println("The number of products must be greater than 1, please try again:");
                continue;
            }

            validNumberOfProducts = true;
        }

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter the name of product " + ":");
            String name = scanner.nextLine();

            System.out.println("Enter the price of product ("+ name + ")" + ":");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter the quantity of product ("+ name + ")" + ":");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the score of product ("+ name + ")" + ":");
            double score = Double.parseDouble(scanner.nextLine());

            try {
                Product product = ProductFactory.createProduct(name, price, quantity, score);
                productFactory.addProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ", please try again.");
                i--;
            }
        }

        // Ask the user to choose the sorting method
        System.out.println("Choose the sorting method: [price, quantity, score]");
        String sortingMethod = scanner.nextLine();
        boolean validSortingMethod = sortingMethod.equals("price") || sortingMethod.equals("quantity") || sortingMethod.equals("score");
        while (!validSortingMethod) {
            sortingMethod = scanner.nextLine();
            if (!sortingMethod.equals("price") && !sortingMethod.equals("quantity") && !sortingMethod.equals("score")) {
                System.out.println("Invalid sorting method, please try again:");
                continue;
            }

            validSortingMethod = true;
        }

        // Ask the user to choose the sorting direction
        System.out.println("Choose the sorting direction: [asc, desc]");
        String sortingDirection = scanner.nextLine();
        boolean validSortingDirection = sortingDirection.equals("asc") || sortingDirection.equals("desc");
        while (!validSortingDirection) {
            sortingDirection = scanner.nextLine();
            if (!sortingDirection.equals("asc") && !sortingDirection.equals("desc")) {
                System.out.println("Invalid sorting direction, please try again:");
                continue;
            }

            validSortingDirection = true;
        }

        // Get the sorted products
        productFactory.sortProducts(sortingMethod, sortingDirection).forEach(product -> {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getScore());
        });

        Cart cart = new Cart();
        while (true) {
            System.out.println("Choose the product name to add to the cart: [x for exit]");
            String productName = scanner.nextLine();

            if (productName.equals("x")) {
                if (cart.getProducts().size() < 2) {
                    System.out.println("The cart must have at least 2 products, please try again:");
                    continue;
                }

                break;
            }

            Product product = productFactory.getProductByName(productName);
            if (product == null) {
                System.out.println("Case2.Product not found, please try again:");
                continue;
            }

            System.out.println("Enter the quantity of product ("+ productName + ")" + ":");
            int quantity = Integer.parseInt(scanner.nextLine());
            while (quantity > product.getQuantity() || quantity < 1) {
                System.out.println("Quantity must be less than or equal to " + product.getQuantity() + ", please try again:");
                quantity = Integer.parseInt(scanner.nextLine());
            }

            cart.addProduct(product, quantity);
        }

        // Get the total price of the cart
        System.out.println("Total price of the cart: " + cart.getTotalPrice());

        scanner.close();
    }
}