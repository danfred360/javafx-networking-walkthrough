package psu.edu;

import java.net.InetAddress;

public class NetWorker {
    public NetWorker() {
        // constructor
    }

    public static String get_ip_from_hostname(String hostname) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            return(address.getHostAddress());
        } catch (Exception unknown_host_error) {
            
            return("unknown_host_error");
        }
    }

    public static String get_hostname_from_ip(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return(address.getHostName());
        }
        catch (Exception unknown_host_error) {
            return("unknown_host_error");
        }
    }
}