package com.kiktan.test

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.cxf.binding.soap.SoapHeader
import org.apache.cxf.headers.Header
import org.apache.ws.security.WSConstants
import org.apache.ws.security.message.WSSecHeader
import org.apache.ws.security.message.WSSecUsernameToken
import org.w3c.dom.Document
import org.w3c.dom.Element

import javax.xml.namespace.QName
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class testGroovy implements Processor {

    @Override
    void process(Exchange exchange) throws Exception {

        String body = exchange.getIn().getBody(String.class);

        List<SoapHeader> soapHeaders = new ArrayList<SoapHeader>();

        String userName = "Bert"
        String password = "kolder";

        // Create Soap Header as DOM Element;  the attributes "actor" and "mustUnderstand" must not be added;
        // these attributes can be added later see below.
        // The following lines create the DOM Element.
        //<AuthHeader xmlns=http://www.Test.com/><ClientId>"+userName+"</ClientId><Password>"+password+"</Password></AuthHeader>"
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element authHeader = doc.createElementNS("http://www.Test.com/", "AuthHeader");
        doc.appendChild(authHeader);
        Element clientId = doc.createElementNS("http://www.Test.com/", "ClientId");
        clientId.setTextContent(userName);
        authHeader.appendChild(clientId);
        Element passwordEl = doc.createElementNS("http://www.Test.com/", "Password");
        passwordEl.setTextContent(password);
        authHeader.appendChild(passwordEl);

        // Create SOAP header instance.
        SoapHeader header = new SoapHeader(new QName(authHeader.getNamespaceURI(), authHeader.getLocalName()), authHeader);
        header.setActor("actor_test");
        header.setMustUnderstand(true);
        //SoapHeader soapHeader = new SoapHeader()
        header.setDirection(Header.Direction.DIRECTION_OUT);
        soapHeaders.add(header);
        exchange.getOut().setBody(body);
        exchange.getOut().setHeader(Header.HEADER_LIST, soapHeaders);

    }
}
