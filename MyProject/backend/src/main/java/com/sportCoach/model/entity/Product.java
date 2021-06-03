package com.sportCoach.model.entity;

import com.sportCoach.dto.ProductDto;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_OF_PRODUCT")
    private String nameOfProduct;

    @Column(name = "FEEDBACKSCOUNT")
    private Long feedBacksCount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "LINK", length=1000)
    private String link;

    @Column(name = "WEIGHT")
    private Long weight;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "SUBCATEGORY")
    private String subCategory;

//    @ManyToMany(mappedBy = "orderGoods")
//    private Set<Orders> orderList = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FeedBacks>feedBacksList = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Images> imagesList = new HashSet<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Characteristics> characteristicsList = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;
//
//
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private FeedBacks feedBacks;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Images images;

    public ProductDto toResponse(){
        return new ProductDto(this.id,
                nameOfProduct,
                price,
                link,
                feedBacksCount,
                description,
                status,
                brand,
                weight,
                amount, subCategory);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public Long getFeedBacksCount() {
        return feedBacksCount;
    }

    public void setFeedBacksCount(Long feedBacksCount) {
        this.feedBacksCount = feedBacksCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Set<FeedBacks> getFeedBacksList() {
        return feedBacksList;
    }

    public void setFeedBacksList(Set<FeedBacks> feedBacksList) {
        this.feedBacksList = feedBacksList;
    }

    public Set<Images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(Set<Images> imagesList) {
        this.imagesList = imagesList;
    }

    public Set<Characteristics> getCharacteristicsList() {
        return characteristicsList;
    }

    public void setCharacteristicsList(Set<Characteristics> characteristicsList) {
        this.characteristicsList = characteristicsList;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

