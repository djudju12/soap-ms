package com.jonathan.products.soap.productssoap.service.impl;

import com.jonathan.products.soap.productssoap.model.ProductEntity;
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

    private static final List<ProductEntity> entities = new ArrayList<>();

    static {
        var p1 = new ProductEntity().setId(1).setDescription("Desc1").setName("Name1").setPrice(1.0);
        var p2 = new ProductEntity().setId(2).setDescription("Desc2").setName("Name2").setPrice(2.0);
        var p3 = new ProductEntity().setId(3).setDescription("Desc3").setName("Name3").setPrice(3.0);
        entities.add(p1);
        entities.add(p2);
        entities.add(p3);
    }

    @Override
    public GetProcutByIdResponse findById(GetProcutByIdRequest request) {
        final int id = request.getId();
        for (ProductEntity p : entities) {
            if (p.getId() == id) {
                GetProcutByIdResponse response = new GetProcutByIdResponse();
                response.setProduct(map(p));
                return response;
            }
        }

        return null;
    }

    @Override
    public GetAllProductsResponse findAll() {
        GetAllProductsResponse response = new GetAllProductsResponse();
        var productsResponse = response.getProducts();
        entities.forEach(p -> productsResponse.add(map(p)));
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
