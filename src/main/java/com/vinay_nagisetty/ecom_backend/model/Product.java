package com.vinay_nagisetty.ecom_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private String category;

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Product(String brand, String category, String description, int id, byte[] imageData, String imageName, String imageType, String name, double price, boolean productAvailable, Date releaseDate, int stockQuantity) {
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.id = id;
        this.imageData = imageData;
        this.imageName = imageName;
        this.imageType = imageType;
        this.name = name;
        this.price = price;
        this.productAvailable = productAvailable;
        this.releaseDate = releaseDate;
        this.stockQuantity = stockQuantity;
    }

    private double price;
//    private String imageUrl;
    private boolean productAvailable;
    private int stockQuantity;
//@Column(name = "release_date")

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
 public Product() {
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Product(int id, String name, String description, String brand, String category, double price, Date releaseDate, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.releaseDate = releaseDate;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    public Product(String name, String description, String brand, String category, double price, Date releaseDate) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }
}
