package com.millsofmn.javabasics.inet;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceListener {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while(interfaces.hasMoreElements()){
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
            System.out.println("add : " + ni.getInetAddresses());
            System.out.println("display : " + ni.getDisplayName());
        }
    }
}
