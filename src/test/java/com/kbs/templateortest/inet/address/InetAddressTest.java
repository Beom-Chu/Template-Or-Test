package com.kbs.templateortest.inet.address;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;

public class InetAddressTest {
    
    @Test
    public void test() throws UnknownHostException {


        System.out.println("[[[inetAddress.getHostAddress() = " + InetAddress.getLocalHost().getHostAddress());
        System.out.println("[[[InetAddress.getLocalHost().getAddress() = " + Arrays.toString(InetAddress.getLocalHost().getAddress()));
        System.out.println("[[[InetAddress.getLocalHost().getHostName() = " + InetAddress.getLocalHost().getHostName());

    }

    @DisplayName("특정 이더넷의 IP 구하기")
    @Test
    public void test2() {
        String interfaceName = "eth0";
        String gwIp = "";
        NetworkInterface networkInterface;
        try {
            networkInterface = NetworkInterface.getByName(interfaceName);
            Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
            InetAddress currentAddress;
            while (inetAddress.hasMoreElements()) {
                currentAddress = inetAddress.nextElement();
                if (currentAddress instanceof Inet4Address && !currentAddress.isLoopbackAddress()) {
                    gwIp = currentAddress.getHostAddress();
                    break;
                }
            }
        } catch (SocketException | NullPointerException e) {
            //
        }
        System.out.println("[[[gwIp = " + gwIp);
    }
}
