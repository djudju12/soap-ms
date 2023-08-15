package com.jonathan.products.soap.productssoap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(int id) {
            super("Product not found. Id: " + id);
        }
}
