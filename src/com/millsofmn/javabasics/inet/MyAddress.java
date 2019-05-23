package com.millsofmn.javabasics.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {
    public static void main(String[] args) {
        try {
            InetAddress localHost =InetAddress.getLocalHost();
            System.out.println("LocalHost : " + localHost);

            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("loopback : " + loopback);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
