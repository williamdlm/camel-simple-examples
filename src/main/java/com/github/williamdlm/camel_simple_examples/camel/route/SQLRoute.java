package com.github.williamdlm.camel_simple_examples.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SQLRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("sql:select * from cliente?noop=true") //Pode ser dessa forma, mas fica executando varias vezes
//                .log("SQL BODY: ${body}");

        from("timer:runOnce?delay=10000&repeatCount=1")
                .to("sql:select * from cliente")
                .log("SQL BODY: ${body}");

        from("timer:myTimerSQL?period=60s")
                .setProperty("nome", constant("John Doe"))
                .setProperty("email", constant("john.doe@example.com"))
                .to("sql:classpath:camelSQLQuery/myquery.sql");
    }
}
