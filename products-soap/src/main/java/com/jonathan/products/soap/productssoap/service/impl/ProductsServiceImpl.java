package com.jonathan.products.soap.productssoap.service.impl;

import com.jonathan.products.soap.productssoap.model.ProductEntity;
import com.jonathan.products.soap.productssoap.repository.ProductsRepository;
import com.jonathan.products.soap.productssoap.service.ProductsService;
import org.springframework.stereotype.Service;
import products.*;

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

    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest request) {
        if (!productsRepository.existsById(request.getId()))
            throw new RuntimeException("Product not found");
        productsRepository.deleteById(request.getId());

        DeleteProductResponse response = new DeleteProductResponse();
        DeleteResponse message = new DeleteResponse();
        message.setMessage("Product deleted");
        message.setStatus(200);
        response.setResponse(message);
        return response;
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {
        Product p = request.getProduct();

        p.setId(0);
        ProductEntity savedProduct = productsRepository.save(map(p));

        AddProductResponse response = new AddProductResponse();
        response.setProduct(map(savedProduct));
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

    private ProductEntity map(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        return entity;
    }

}
