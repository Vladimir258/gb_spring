package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import ru.gb.services.ProductService;

import java.util.List;

@Component
public class OrderService {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void createOrderFromProduct(Long productId) {
        System.out.println("Заказ создан:");
        System.out.println(productService.getTitleById(productId));
    }

    public List<Product> createProductsList() {
        return productService.findAll();
    }
}
