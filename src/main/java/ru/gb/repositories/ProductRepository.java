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
                new Product(1L, "Bread"),
                new Product(2L, "Milk"),
                new Product(3L, "Apple"),
                new Product(4L, "Orange"),
                new Product(5L, "Sugar")
        ));
    }

    public Product findById(final Long id) {
        return products.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException());
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

//    public void removeById(Long id) {
//        products.removeIf(s->s.getId().equals(id));
//    }
}
