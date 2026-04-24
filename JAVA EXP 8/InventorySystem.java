import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Product interface
interface Product {
    void displayDetails();
}

// LegacyItem class
class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item ID: " + itemId + ", Description: " + description);
    }
}

// ProductAdapter class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print();
    }
}

// NewProduct class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product Name: " + name);
    }
}

// Singleton InventoryManager class
class InventoryManager {
    private static InventoryManager instance;

    private List<Product> products;

    private InventoryManager() {
        products = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Iterator<Product> returnInventory() {
        return products.iterator();
    }
}

// Main class
public class InventorySystem {
    public static void main(String[] args) {

        InventoryManager inventory = InventoryManager.getInstance();

        NewProduct product1 = new NewProduct("Laptop");
        NewProduct product2 = new NewProduct("Mobile Phone");

        LegacyItem legacyItem1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem legacyItem2 = new LegacyItem(102, "Old Mouse");

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.addProduct(new ProductAdapter(legacyItem1));
        inventory.addProduct(new ProductAdapter(legacyItem2));

        Iterator<Product> iterator = inventory.returnInventory();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }
}