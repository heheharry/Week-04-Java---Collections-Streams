package Day1.JavaGenerics;
import java.util.*;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    public void displayInfo() {
        System.out.println("Electronics Item: " + getName());
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    public void displayInfo() {
        System.out.println("Grocery Item: " + getName());
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    public void displayInfo() {
        System.out.println("Furniture Item: " + getName());
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class WarehouseUtility {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Apples"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        WarehouseUtility.displayAllItems(electronicsStorage.getItems());
        WarehouseUtility.displayAllItems(groceryStorage.getItems());
        WarehouseUtility.displayAllItems(furnitureStorage.getItems());
    }
}
