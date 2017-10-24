package MemcachedApplication;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MemcachedApplication {
    public static void main(String[] args) {
        try {
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            mcc.set("key1", 0, "Memcached first value");
            mcc.set("key2", 0, "Memcached second value");
            mcc.set("key3", 0, "Memcached is fast");
            mcc.set("key4", 0, "Memcached is simple");

            for(int i=1;i<5;i++){
                System.out.println(mcc.get("key"+i));
            }
            System.out.println(mcc.getStats());
            System.out.println(mcc.getVersions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
