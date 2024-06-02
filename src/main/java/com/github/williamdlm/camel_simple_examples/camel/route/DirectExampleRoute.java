package com.github.williamdlm.camel_simple_examples.camel.route;

import com.github.williamdlm.camel_simple_examples.model.MyDataType;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DirectExampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period=5s")
                .setBody(constant("PAYLOAD EXAMPLE DIRECT"))
                .to("direct:nameDirect");


        from("direct:nameDirect")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    MyDataType myDataType = new MyDataType(body);
                    exchange.getIn().setBody(myDataType);
                })
                .log("directRoute: ${body}")
                .to("log:nameDirect");
    }
}
