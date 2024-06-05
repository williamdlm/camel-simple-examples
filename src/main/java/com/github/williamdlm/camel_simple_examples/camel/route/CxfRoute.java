package com.github.williamdlm.camel_simple_examples.camel.route;

import com.github.williamdlm.camel_simple_examples.soap.HelloService;
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


        from("cxf:/hello?serviceClass=" + HelloService.class.getName())
                .routeId("helloRoute")
                .log("someAddress Way")
                .to("bean:helloServiceImpl?method=sayHello");

        from("timer:mytimer?period=10s&delay=5s")
                .to("direct:start");

        from("direct:start")
//                    .setHeader(CxfConstants.OPERATION_NAME, constant("sayName"))
//                    .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://service.williamdlm.github.com/"))
//                    .setHeader("soapAction", constant("http://service.williamdlm.github.com/Introduce/sayName"))
                .setBody(constant("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.williamdlm.github.com/\">" +
                        "   <soapenv:Header/>" +
                        "   <soapenv:Body>" +
                        "      <ser:sayName>" +
                        "         <arg0>William Mota</arg0>" +
                        "      </ser:sayName>" +
                        "   </soapenv:Body>" +
                        "</soapenv:Envelope>"))
                .to("cxf:bean:producerCxf")
                .log("Response: ${body}");


    }
}
