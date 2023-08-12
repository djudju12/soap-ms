package com.jonathan.products.soap.productssoap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.MessageDispatcher;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WsConfig {

    @Value("${xsd.tns}")
    private String namespace;

    @Bean
    public ServletRegistrationBean<?> dispatcher(ApplicationContext context) {
        MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
        dispatcherServlet.setTransformWsdlLocations(true);
        dispatcherServlet.setApplicationContext(context);
        return new ServletRegistrationBean<>(dispatcherServlet, "/products/*");
    }

    @Bean(name="products")
    public DefaultWsdl11Definition definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CoursePort");
        wsdl11Definition.setTargetNamespace(namespace);
        wsdl11Definition.setLocationUri("/products");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
    }

}
