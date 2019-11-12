package com.vapenation.twittermongo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class UserRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:aTimer?fixedRate=true&period=10s")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .to("https://randomuser.me/api")
            .routeId("TEST")
            .log("${body}");
    }
}