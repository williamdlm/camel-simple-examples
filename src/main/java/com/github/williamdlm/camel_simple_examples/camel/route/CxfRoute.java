package com.github.williamdlm.camel_simple_examples.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CxfRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("cxf:bean:helloEndpoint")
                .routeId("helloRoute")
                .log("Received request: ${body}")
                .to("bean:helloServiceImpl?method=sayHello")
                .log("Response: ${body}");
    }
}
