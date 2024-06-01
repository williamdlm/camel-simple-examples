package com.github.williamdlm.camel_simple_examples.config;

import com.github.williamdlm.camel_simple_examples.soap.HelloService;
import com.github.williamdlm.camel_simple_examples.soap.HelloServiceImpl;
import jakarta.xml.ws.Endpoint;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CfxConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private HelloService helloService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, helloService);
        endpoint.publish("/hello");
        return endpoint;
    }

    @Bean
    public CxfEndpoint helloEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/services/hello");
        cxfEndpoint.setServiceClass(HelloService.class);
        return cxfEndpoint;
    }
}
