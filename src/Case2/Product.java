package Case2;

public class Product {
    final String name;
    double price;
    int quantity;
    double score;

    public Product(String name, double price, int quantity, double score) {
        if (name.isEmpty() || name.length() > 20) {
            throw new IllegalArgumentException("Name must be between 1 and 20 characters");
        }

        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        if (price < 0 || price > 100) {
            throw new IllegalArgumentException("Price must be between 0 and 100");
        }

        if (score < 0 || score > 5) {
            throw new IllegalArgumentException("Score must be between 0 and 5");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public void increaseQuantity() {
        this.quantity++;
    }
}
