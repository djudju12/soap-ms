package com.jonathan.products.soap.productssoap.controller;

import com.jonathan.products.soap.productssoap.service.ProductsService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import products.*;

import java.util.List;

@Endpoint
public class ProductController {

    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PayloadRoot(namespace = "http://www.soapws.com/products", localPart = "GetAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request){
        return productsService.findAll();
    }

    @PayloadRoot(namespace = "http://www.soapws.com/products", localPart = "GetProcutByIdRequest")
    @ResponsePayload
    public GetProcutByIdResponse getProduct(@RequestPayload GetProcutByIdRequest request){
        return productsService.findById(request);
    }
}
