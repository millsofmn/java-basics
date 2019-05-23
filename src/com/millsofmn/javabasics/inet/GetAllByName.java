package com.millsofmn.javabasics.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetAllByName {
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");

            for(InetAddress address : addresses){
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
