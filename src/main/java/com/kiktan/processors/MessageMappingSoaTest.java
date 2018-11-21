package com.kiktan.processors;

import org.apache.camel.Headers;
import org.apache.cxf.binding.soap.SoapHeader;
import org.omg.CORBA.Object;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Map;

import javax.wsdl.Input;

public class MessageMappingSoaTest {

    public static String getHeaders(String custom) {
        return custom;
    }
}
