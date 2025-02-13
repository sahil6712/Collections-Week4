package shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.shopingcart.ShoppingCart;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Phone", 800.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);
    }

    @Test
    void testAddToCart() {
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        assertEquals(1300.00, cart.getTotalPrice(), 0.01);
    }

    @Test
    void testTotalPrice() {
        cart.addToCart("Headphones", 2);
        cart.addToCart("Phone", 1);
        assertEquals(1100.00, cart.getTotalPrice(), 0.01);
    }

    @Test
    void testInvalidProduct() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addToCart("Tablet", 1);
        });
        assertEquals("Product not found in store.", exception.getMessage());
    }
}
