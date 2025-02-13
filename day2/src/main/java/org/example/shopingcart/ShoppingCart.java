package org.example.shopingcart;

import java.util.*;

public class ShoppingCart {
    private final Map<String, Double> productPrices;  // Stores product prices
    private final LinkedHashMap<String, Integer> cart; // Maintains insertion order
    private final TreeMap<Double, String> sortedByPrice; // Sorts items by price

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cart = new LinkedHashMap<>();
        this.sortedByPrice = new TreeMap<>();
    }

    // Adding products to the store
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        sortedByPrice.put(price, product);
    }

    // Adding items to the cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            throw new IllegalArgumentException("Product not found in store.");
        }
    }

    // Displaying cart in insertion order
    public void displayCart() {
        System.out.println("Shopping Cart (Ordered by addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue());
        }
    }

    // Displaying products sorted by price
    public void displayProductsSortedByPrice() {
        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, String> entry : sortedByPrice.entrySet()) {
            System.out.println(entry.getValue() + " - Price: $" + entry.getKey());
        }
    }

    // Get total price of the cart
    public double getTotalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Phone", 800.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);

        // Adding items to cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Headphones", 1);

        // Displaying cart and sorted products
        cart.displayCart();
        cart.displayProductsSortedByPrice();
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
