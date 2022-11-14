package fsega.security.service;

import fsega.security.model.Product;
import fsega.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }
}
