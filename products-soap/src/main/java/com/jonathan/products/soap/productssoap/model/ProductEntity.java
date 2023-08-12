package com.jonathan.products.soap.productssoap.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ProductEntity {
    private int id;
    private String name;
    private String description;
    private double price;
}
