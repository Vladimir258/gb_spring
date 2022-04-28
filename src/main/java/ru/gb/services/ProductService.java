package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repositories.ProductRepository;

import java.util.List;

@Service // От @Component впринципе ничем не отличается
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + delta);
        // productRepository.save(product); // Если бы мы уже работали с БД
    }

//    public String getTitleById(Long id) {
//        return productRepository.findById(id).getTitle();
//    }
//
//    public Product findById(Long id) {
//        return productRepository.findById(id);
//    }
//
//
//
//    public void add(Product product) {
//        productRepository.add(product);
//    }
}
