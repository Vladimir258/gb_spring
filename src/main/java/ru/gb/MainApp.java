package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // todo 1 Создаем контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru");
        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);
        Cart cart = context.getBean(Cart.class);
        orderService.createOrderFromProduct(3L);

        for (Product p :orderService.createProductsList()) {
            System.out.println(p);
        }

        System.out.println("============================");

        cart.addProductToCart(2L);
        cart.showProductInCart();
        System.out.println("--------------");
        cart.addProductToCart(1L);
        cart.showProductInCart();
        System.out.println("--------------");
        cart.addProductToCart(2L);
        cart.showProductInCart();
        System.out.println("--------------");
        cart.addProductToCart(3L);
        cart.showProductInCart();
        System.out.println("--------------");
        cart.deletProductFromCart(productService.findById(3L));
        cart.showProductInCart();
        System.out.println("--------------");
        cart.deletProductFromCart(productService.findById(3L));
        cart.showProductInCart();
        System.out.println("--------------");
        context.close();
    }
}
