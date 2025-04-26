package Day5.FeaturesProblemStatements;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Sale {
    int productId;
    int quantity;
    double price;

    Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return productId + " " + totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale(1, 5, 100),
                new Sale(2, 15, 200),
                new Sale(3, 20, 150),
                new Sale(4, 8, 300),
                new Sale(5, 12, 400),
                new Sale(6, 25, 120),
                new Sale(7, 18, 250)
        );

        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(topProducts);
    }
}
