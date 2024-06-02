package com.github.williamdlm.camel_simple_examples.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NettyHttpRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty-http:0.0.0.0:9125/")
                .log("body: ${body}");
    }
}
