package com.vinay_nagisetty.ecom_backend.controller;

import com.vinay_nagisetty.ecom_backend.model.Product;
import com.vinay_nagisetty.ecom_backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product> >getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK) ;
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        System.out.println(product);
        System.out.println("////");
        System.out.println(imageFile);
        try {
            Product product1=productService.addProduct(product, imageFile);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
