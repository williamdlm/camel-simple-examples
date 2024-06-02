package com.github.williamdlm.camel_simple_examples.config;

import com.github.williamdlm.camel_simple_examples.soap.HelloService;
import jakarta.xml.ws.Endpoint;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private HelloService helloService;

    public CxfConfig(Bus bus, HelloService helloService) {
        this.bus = bus;
        this.helloService = helloService;
    }

//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(bus, helloService);
//        endpoint.publish("/hello");
//        return endpoint;
//    }

    @Bean
    public CxfEndpoint helloEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/hi");
        cxfEndpoint.setServiceClass(HelloService.class);
        return cxfEndpoint;
    }
}
