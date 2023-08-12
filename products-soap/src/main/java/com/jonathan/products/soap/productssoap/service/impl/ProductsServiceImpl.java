package com.jonathan.products.soap.productssoap.service.impl;

import com.jonathan.products.soap.productssoap.model.ProductEntity;
import com.jonathan.products.soap.productssoap.repository.ProductsRepository;
import com.jonathan.products.soap.productssoap.service.ProductsService;
import org.springframework.stereotype.Service;
import products.GetAllProductsResponse;
import products.GetProcutByIdRequest;
import products.GetProcutByIdResponse;
import products.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public GetProcutByIdResponse findById(GetProcutByIdRequest request) {
        ProductEntity entity = productsRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Product product = map(entity);
        GetProcutByIdResponse response = new GetProcutByIdResponse();
        response.setProduct(product);
        return response;
    }

    @Override
    public GetAllProductsResponse findAll() {
        List<ProductEntity> entities = productsRepository.findAll();

        GetAllProductsResponse response = new GetAllProductsResponse();

        var list = response.getProducts();
        entities.forEach(entity -> {
            Product product = map(entity);
            list.add(product);
        });
        return response;
    }

    private Product map(ProductEntity productEntity) {
        var p = new Product();
        p.setId(productEntity.getId());
        p.setName(productEntity.getName());
        p.setDescription(productEntity.getDescription());
        p.setPrice(productEntity.getPrice());
        return p;
    }

}
