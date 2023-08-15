package com.jonathan.products.soap.productssoap.utls;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jonathan.products.soap.productssoap.model.ProductEntity;

import java.io.IOException;
import java.io.InputStream;

public class XmlUtils {

    public static ProductEntity productFromFile(String path) throws IOException {
        InputStream is = XmlUtils.class.getResourceAsStream(path);
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(is, ProductEntity.class);
    }

}
