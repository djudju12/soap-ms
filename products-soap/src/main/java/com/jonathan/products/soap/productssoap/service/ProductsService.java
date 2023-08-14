package com.jonathan.products.soap.productssoap.service;

import products.*;

public interface ProductsService {
    GetProcutByIdResponse findById(GetProcutByIdRequest request);
    GetAllProductsResponse findAll();
    DeleteProductResponse deleteProduct(DeleteProductRequest request);
    AddProductResponse addProduct(AddProductRequest request);
}
