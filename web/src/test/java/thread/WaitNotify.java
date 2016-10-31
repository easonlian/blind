/*
* Copyright (c) 2016 Qunar.com. All Rights Reserved.
*/
package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: jianyu.lin
 * Date: 2016/10/16 Time: 下午3:12
 */
public class WaitNotify {

    private static boolean flag = true;
    private static Object lock = new Object();

    private static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ "
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    private static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + "hold lock. notify @ "
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.notifyAll();
                    flag = false;
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread() + "hold lock again. sleep @ "
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }
}
