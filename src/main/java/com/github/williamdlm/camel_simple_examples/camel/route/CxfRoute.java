package com.github.williamdlm.camel_simple_examples.camel.route;

import com.github.williamdlm.camel_simple_examples.soap.HelloServiceImpl;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CxfRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("cxf:bean:helloEndpoint")
                .routeId("hiRoute")
                .log("Received request: ${body}")
                .to("bean:helloServiceImpl?method=sayHello")
                .log("Response: ${body}");


        from("cxf:/hello?serviceClass=" + HelloServiceImpl.class.getName())
                .routeId("helloRoute")
                .log("someAddress Way");

    }
}
