package fsega.security.controller;

import fsega.security.model.Product;
import fsega.security.model.User;
import fsega.security.service.ProductService;
import fsega.security.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final ProductService productService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public Controller(ProductService productService, UserDetailsService userDetailsService) {
        this.productService = productService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/user/register")
    public void register(@RequestBody User user) {
        userDetailsService.register(user);
    }

    @PostMapping("/product/save")
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }
}
