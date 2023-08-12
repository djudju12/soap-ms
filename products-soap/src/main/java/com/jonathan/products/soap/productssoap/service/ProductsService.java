package com.jonathan.products.soap.productssoap.service;

import products.GetAllProductsResponse;
import products.GetProcutByIdRequest;
import products.GetProcutByIdResponse;

public interface ProductsService {
    GetProcutByIdResponse findById(GetProcutByIdRequest request);
    GetAllProductsResponse findAll();
}
