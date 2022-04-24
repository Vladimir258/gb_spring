package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    List<Product> cartProduct = new ArrayList<>();
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductToCart(Long id) {
        cartProduct.add(productRepository.findById(id));
//        for (Product pr: cartProduct) {
//            System.out.println(pr);
//        }
    }

    public void deletProductFromCart(Product p) {
        cartProduct.remove(p);
//        for (Product pr: cartProduct) {
//            System.out.println(pr);
//        }
    }

    public void showProductInCart() {
        for (Product pr: cartProduct) {
            System.out.println(pr);
        }
    }
}
