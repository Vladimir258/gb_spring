package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.model.Product;
import ru.gb.services.ProductService;

import java.util.List;

@RestController //Лекция 4 Теперь не нужно над методами прописывать аннотацию @ResponseBody
// http://localhost:8189/app
public class ProductControllers {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> showProductsPage() {
        return productService.findAll();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }


//    @GetMapping("/products")
//    public String showProductsPage(Model model) {
//        model.addAttribute("students", productService.findAll());
//        return "products_page";
//    }
//
//    @GetMapping("/products/{id}")
//    public String showProductPage(Model model, @PathVariable Long id) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "product_info_page";
//    }
//
//    @GetMapping("/add_form")
//    public String showAddForm() {
//        return "product_add";
//    }
//
//    @GetMapping("/product_add")
//    public String productAdd(@RequestParam Long id, @RequestParam String title) {
//        Product product = new Product(id, title);
//        productService.add(product);
//        return "redirect:/products";
//    }
}
