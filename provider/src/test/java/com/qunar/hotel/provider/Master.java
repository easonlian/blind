package com.qunar.hotel.provider;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author: jianyu.lin  Date: 16-8-10.
 */
public class Master implements Watcher {

    ZooKeeper zk;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws Exception {
        zk.close();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public static void main(String[] args) throws Exception {
        Master m = new Master("127.0.0.1:2181");
        m.startZK();
        Thread.sleep(60000);

        m.stopZK();
    }
}
