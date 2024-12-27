package com.vinay_nagisetty.ecom_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class ProductResponseDTO {


    private String name;
    private String description;
    private String brand;
    private String category;
    private double price;
    private boolean productAvailable;
    private int stockQuantity;
    @JsonIgnore
    private Date releaseDate;

    public ProductResponseDTO() {

    }

    public ProductResponseDTO(String brand, String category, String description, String name, double price, boolean productAvailable, Date releaseDate, int stockQuantity) {
        this.brand = brand;
        this.category = category;
        this.description = description;

        this.name = name;
        this.price = price;
        this.productAvailable = productAvailable;
        this.releaseDate = releaseDate;
        this.stockQuantity = stockQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
