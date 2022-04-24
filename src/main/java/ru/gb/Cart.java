package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    List<Product> products;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(); // Лучше инициализировать здесь чем сразу поле
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductToCart(Long id) {
        products.add(productRepository.findById(id));
    }

    public void deletProductFromCart(Product p) {
        products.remove(p);
    }

    public void showProductInCart() {
        for (Product pr: products) {
            System.out.println(pr);
        }
    }
}
