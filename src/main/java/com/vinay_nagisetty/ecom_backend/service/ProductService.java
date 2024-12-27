package com.vinay_nagisetty.ecom_backend.service;

import com.vinay_nagisetty.ecom_backend.model.Product;
import com.vinay_nagisetty.ecom_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
//        System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {


//            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
            product.setImageName(imageFile.getOriginalFilename());


        return  productRepository.save(product);
    }
}
