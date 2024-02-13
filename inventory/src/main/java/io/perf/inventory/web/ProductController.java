package io.perf.inventory.web;

import io.perf.inventory.entities.Product;
import io.perf.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product productById (@PathVariable String id){
        return productRepository.findById(id).get();
    }
}
