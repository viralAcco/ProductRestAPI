package com.accolite.product.service;

import com.accolite.product.model.Product;

import java.util.List;

public interface ProductService {

    Product createProd(Product prod);

    Product updateProd(Product prod);

    List<Product> getProduct();

    Product getProdById(long prodId);

    void deleteProd(long prodId);
}
