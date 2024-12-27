package com.vinay_nagisetty.ecom_backend.service;

import com.vinay_nagisetty.ecom_backend.model.Product;
import com.vinay_nagisetty.ecom_backend.model.ProductResponseDTO;
import com.vinay_nagisetty.ecom_backend.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
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


        return productRepository.save(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        // Map Product entities to ProductResponseDTOs
        //manula ways of doing the mapping
//        return products.stream()
//                .map(product -> new ProductResponseDTO(
//                                        product.getName(),
//                                        product.getDescription(),
//                                        product.getBrand(),
//                                        product.getCategory(),
//                                        product.getPrice(),
//                                        product.isProductAvailable(),
//                        product.getReleaseDate(),
//                        product.getStockQuantity()
//                                ))
//                .collect(Collectors.toList());
//    }

        // Use ModelMapper to map entities to DTOs
        //using model mapper library
//        return products.stream()
//                .map(product -> modelMapper.map(product, ProductResponseDTO.class))
//                .collect(Collectors.toList());
//    }
        return products
                .stream()
                .map(product -> {
                    // Map the common fields
                    ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);

                    // Manually add extra fields
                    productResponseDTO.setExtraField("Custom extra value");

                    return productResponseDTO;
                })
                .toList() ; // Use collect in Java 11 or earlier
    }



}
