package com.kiktan.test

import org.apache.camel.Exchange
import org.apache.camel.Processor
import groovy.util.XmlSlurper

class test implements Processor{
    @Override
    void process(Exchange exchange) throws Exception {

        def list = new XmlSlurper().parseText(exchange.getIn(String.class))
    }
}
