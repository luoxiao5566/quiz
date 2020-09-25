package com.twuc.shopping.service;

import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        ProductPO productPO = ProductPO.builder().proName(product.getProName())
                .price(product.getPrice())
                .imgURL(product.getImgURL())
                .unit(product.getUnit()).build();
        productRepository.save(productPO);
    }
}
