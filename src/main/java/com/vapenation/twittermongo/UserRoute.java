package com.vapenation.twittermongo;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserRoute extends RouteBuilder {

    @Autowired
    CamelContext context;

    @Override
    public void configure() throws Exception {

        from("timer:aTimer?fixedRate=true&period=10s")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .to("https://randomuser.me/api")
            .routeId("TEST")
            .log("${body}");
    }
}