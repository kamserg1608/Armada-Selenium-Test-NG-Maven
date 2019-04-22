package ru.qa.armada.n05_downloadAndInstallDistribution.tools.workWithIPv4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class WorkWithLocalIP {
    private String localIPv4;
    private InetAddress IP;

    public WorkWithLocalIP() {
        this.localIPv4 = "127.0.0.1";
    }

    public String  takeLocalIP() {
        try {
            IP = InetAddress.getLocalHost();
            localIPv4 = IP.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localIPv4;
    }
}
