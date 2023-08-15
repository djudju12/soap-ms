package com.jonathan.products.soap.productssoap.service.impl;

import com.jonathan.products.soap.productssoap.exception.ProductNotFoundException;
import com.jonathan.products.soap.productssoap.model.ProductEntity;
import com.jonathan.products.soap.productssoap.repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import products.GetProcutByIdRequest;
import products.GetProcutByIdResponse;

import java.io.IOException;
import java.util.Optional;

import static com.jonathan.products.soap.productssoap.utls.XmlUtils.productFromFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
class ProductsServiceImplTest {

    @Mock
    private ProductsRepository productsRepository;

    @InjectMocks
    private ProductsServiceImpl service;

    private final static String PRODUCT_ENTITY_PATH = "/payloads/products/product.xml";

    @Test
    void findById_ReceveisValidRequest_ReturnsValidResponse() throws IOException {
        // given
        ProductEntity expectedProduct = productFromFile(PRODUCT_ENTITY_PATH);
        GetProcutByIdRequest request = new GetProcutByIdRequest();
        request.setId(expectedProduct.getId());
        given(productsRepository.findById(anyInt())).willReturn(Optional.of(expectedProduct));

        // when
        GetProcutByIdResponse response = service.findById(request);

        // then
        then(productsRepository).should().findById(anyInt());
        assertThat(response.getProduct()).isNotNull();
    }

    @Test
    void findById_ReceivesInvalidRequest_ThrowsException() {
        // given
        given(productsRepository.findById(anyInt())).willReturn(Optional.empty());

        // when
        // then
        assertThatThrownBy(() -> service.findById(new GetProcutByIdRequest()))
                .isInstanceOf(ProductNotFoundException.class);
        then(productsRepository).should().findById(anyInt());
        then(productsRepository).shouldHaveNoMoreInteractions();

    }

    @Test
    void findAll() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void addProduct() {
    }
}