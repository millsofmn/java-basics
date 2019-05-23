package com.millsofmn.javabasics.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println(address);
            System.out.println("HostName : " + address.getHostName());
            System.out.println("Canonical : " + address.getCanonicalHostName());
            System.out.println("Address : " + address.getAddress());
            System.out.println("HostAddress : " + address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
