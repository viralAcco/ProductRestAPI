package com.accolite.product.model;

import javax.persistence.*;

@Entity
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prodId;
    @Column(name = "prodName")
    private String prodName;
    @Column(name = "prodQt")
    private int prodQt;

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdQt() {
        return prodQt;
    }

    public void setProdQt(int prodQt) {
        this.prodQt = prodQt;
    }
}
