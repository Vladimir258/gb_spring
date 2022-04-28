package ru.gb.repositories;

import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 20F),
                new Product(2L, "Milk", 10F),
                new Product(3L, "Apple", 5F),
                new Product(4L, "Orange", 7F),
                new Product(5L, "Sugar", 35F)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s->s.getId().equals(id));
    }

    public Product findById(final Long id) {
        return products.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException());
    }

//    public void add(Product product) {
//        products.add(product);
//    }

}
