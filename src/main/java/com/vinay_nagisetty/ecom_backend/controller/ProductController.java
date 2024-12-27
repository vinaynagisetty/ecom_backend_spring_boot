package com.vinay_nagisetty.ecom_backend.controller;

import com.vinay_nagisetty.ecom_backend.model.Product;
import com.vinay_nagisetty.ecom_backend.model.ProductResponseDTO;
import com.vinay_nagisetty.ecom_backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile) {
        System.out.println(product);
        System.out.println("////");
        System.out.println(imageFile);
        try {
            Product product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productID}/image")
    public ResponseEntity<byte[]> getProductImageId(@PathVariable int productID) throws IOException {
        Product product = productService.getProductById(productID);
        if (product != null) {
            byte[] image = product.getImageData();
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(product.getImageType()))
                    .body(image);     //if we provide the contenttype as well its showing the image in previww


//            return new ResponseEntity<>(image, HttpStatus.OK);   //if we dont provide the contenttype its downloading the image but it does not show the image in preview
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/productsBySpecifiedResponse")
    public ResponseEntity<Map<String, Object>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        // Create the response map with success status and the list of products
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("productDetails", products);

        return ResponseEntity.ok(response);
    }
}

