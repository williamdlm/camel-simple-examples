package com.github.williamdlm.camel_simple_examples.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:{{app.files.input}}?delete=true&delay=15000")
                .routeId("fileRoute")
                .log("${file:name}")
                .to("file:{{app.files.output}}?fileName=${date:now:HHmmss}_${file:name}");
    }
}
