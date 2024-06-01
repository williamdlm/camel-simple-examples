package com.github.williamdlm.camel_simple_examples.soap;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
//@WebService(endpointInterface = "com.github.williamdlm.camel_simple_examples.soap.Hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String text) {
        System.out.println("Executed sayHello");
        return "Hello " + text;
    }
}
