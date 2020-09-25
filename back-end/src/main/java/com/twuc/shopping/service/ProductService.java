package com.twuc.shopping.service;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getAllOrder() {
        List<ProductPO> productPOS = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (ProductPO productPO : productPOS) {
            Product product = Product.builder().proName(productPO.getProName())
                    .price(productPO.getPrice())
                    .imgURL(productPO.getImgURL())
                    .id(productPO.getId())
                    .unit(productPO.getUnit()).build();
            products.add(product);
        }
        return products;
    }
}
