package com.kiktan.test;

public class testGroovy {

    public static String getHeaders(String custom) {


        def inputSOATest = new XmlSlurper().parseText(custom)
        def ff =  inputSOATest.test

        return custom
    }
}
