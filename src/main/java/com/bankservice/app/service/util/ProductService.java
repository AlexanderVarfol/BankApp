package com.bankservice.app.service.util;

import com.bankservice.app.entity.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
}
