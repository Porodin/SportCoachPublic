package com.sportCoach.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TOTAL_PRICE")
    private int totalPrice;

    @Column(name = "PLACEMENT_DATE")
    private int placement_date;

    @Column(name = "RECEIVE_DATE")
    private int receiveDate;

    @Column(name = "COUNT")
    private int count;

    @ManyToMany
    @JoinTable(name = "ORDER_GOODS", joinColumns = @JoinColumn (name = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "GOODS_ID"))
    private Set<Product> orderGoods = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPlacement_date() {
        return placement_date;
    }

    public void setPlacement_date(int placement_date) {
        this.placement_date = placement_date;
    }

    public int getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(int receiveDate) {
        this.receiveDate = receiveDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Product> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Set<Product> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
