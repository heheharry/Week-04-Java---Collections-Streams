package Day2.Extras;
import java.util.*;
public class ShoppingCart {
    private Map<String, Double> productPrices;
    private Map<String, Integer> cartItems;
    private Map<String, Integer> cartItemsInOrder;
    private Map<String, Integer> cartItemsSortedByPrice;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        cartItemsInOrder = new LinkedHashMap<>();
        cartItemsSortedByPrice = new TreeMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addItemToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            cartItemsInOrder.put(product, cartItemsInOrder.getOrDefault(product, 0) + quantity);
            cartItemsSortedByPrice.put(product, cartItemsSortedByPrice.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not available.");
        }
    }

    public void removeItemFromCart(String product) {
        if (cartItems.containsKey(product)) {
            cartItems.remove(product);
            cartItemsInOrder.remove(product);
            cartItemsSortedByPrice.remove(product);
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public void displayCartItemsInOrder() {
        System.out.println("Cart Items (In Order Added):");
        for (Map.Entry<String, Integer> entry : cartItemsInOrder.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + " - Price: $" + productPrices.get(entry.getKey()));
        }
    }

    public void displayCartItemsSortedByPrice() {
        System.out.println("Cart Items (Sorted by Price):");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(cartItemsSortedByPrice.entrySet());
        entries.sort((entry1, entry2) -> Double.compare(productPrices.get(entry1.getKey()), productPrices.get(entry2.getKey())));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + " - Price: $" + productPrices.get(entry.getKey()));
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct("Laptop", 800);
        shoppingCart.addProduct("Phone", 600);
        shoppingCart.addProduct("Headphones", 100);
        shoppingCart.addProduct("Mouse", 20);

        shoppingCart.addItemToCart("Laptop", 1);
        shoppingCart.addItemToCart("Phone", 2);
        shoppingCart.addItemToCart("Headphones", 1);
        shoppingCart.addItemToCart("Mouse", 1);

        shoppingCart.displayCartItemsInOrder();
        System.out.println();

        shoppingCart.displayCartItemsSortedByPrice();
        System.out.println();

        System.out.println("Total Price: $" + shoppingCart.getTotalPrice());

        shoppingCart.removeItemFromCart("Mouse");
        System.out.println("\nAfter removing Mouse:");
        shoppingCart.displayCartItemsInOrder();
    }
}
