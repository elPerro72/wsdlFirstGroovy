package com.kiktan.common;

import org.apache.camel.Headers;
import org.apache.cxf.binding.soap.SoapHeader;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.Map;

public class ProcessHeaders {

    public String getChainId(@Headers Map headers) {
        String chainId = null;
        ArrayList<SoapHeader> soapheaders = (ArrayList) headers.get("org.apache.cxf.headers.Header.list");
        for (SoapHeader soapHeader : soapheaders) {
            if (soapHeader.getName().toString().contains("chainId")) {
                Element e = (Element) soapHeader.getObject();
                chainId = e.getTextContent();
            }
        }
        return chainId;
    }
}
