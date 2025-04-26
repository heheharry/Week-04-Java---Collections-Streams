package Day1.JavaGenerics;
import java.util.*;

interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, NONFICTION, SCIENCE;

    public String getCategoryName() {
        return name();
    }
}

enum ClothingCategory implements Category {
    MEN, WOMEN, KIDS;

    public String getCategoryName() {
        return name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return name();
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    public void displayProduct() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Category: " + category.getCategoryName());
    }
}

class MarketplaceUtility {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}
public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Alchemist", 20.0, BookCategory.FICTION);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 15.0, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 499.99, GadgetCategory.MOBILE);

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        MarketplaceUtility.applyDiscount(book, 10);
        MarketplaceUtility.applyDiscount(shirt, 15);
        MarketplaceUtility.applyDiscount(phone, 5);

        for (Product<? extends Category> product : catalog) {
            product.displayProduct();
        }
    }
}
