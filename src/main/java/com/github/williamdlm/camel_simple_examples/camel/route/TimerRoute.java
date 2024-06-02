package com.github.williamdlm.camel_simple_examples.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TimerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:timerName?period=5s")
                .routeId("timerRoute")
                .setBody(constant("Payload: " + LocalDateTime.now()))
                .log("Data e hora: ${date:now:dd/MM/YYYY HH:mm:ss}")
                .to("log:timerName");
    }
}
