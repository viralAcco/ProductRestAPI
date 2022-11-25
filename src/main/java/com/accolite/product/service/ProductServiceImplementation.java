package com.accolite.product.service;

import com.accolite.product.exception.ProductException;
import com.accolite.product.model.Product;
import com.accolite.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProd(Product prod){
        return productRepo.save(prod);
    }

    @Override
    public Product updateProd(Product prod){
        Optional<Product> prodObj = this.productRepo.findById(prod.getProdId());

        if(prodObj.isPresent()) {
            Product prodUpdate = prodObj.get();
            prodUpdate.setProdId(prod.getProdId());
            prodUpdate.setProdName(prod.getProdName());
            prodUpdate.setProdQt(prod.getProdQt());
            return this.productRepo.save(prodUpdate);
        }else{
            throw new ProductException("Product didn't found with ID: "+ prod.getProdId());
        }

    }

    @Override
    public List<Product> getProduct() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProdById(long prodId) {
        Optional<Product> prodObj = this.productRepo.findById(prodId);
        if(prodObj.isPresent()){
            return prodObj.get();
        }else{
            throw new ProductException("Product didn't found with ID: "+ prodId);
        }
    }

    @Override
    public void deleteProd(long prodId) {
        Optional<Product> prodObj = this.productRepo.findById(prodId);
        if(prodObj.isPresent()){
            this.productRepo.deleteById(prodId);
        }else{
            throw new ProductException("Product didn't found with ID: "+ prodId);
        }
    }

}
