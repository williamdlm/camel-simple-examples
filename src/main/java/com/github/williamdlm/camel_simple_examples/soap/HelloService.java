package com.github.williamdlm.camel_simple_examples.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface HelloService {
    @WebMethod
    String sayHello(String text);
}
