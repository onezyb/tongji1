package com.zyb.tjpkg.util.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Yambo Zhang on 2020-06-30.
 */
public class BasicTypeDataTest {

    private static int count00 = 0;
//    private static AtomicInteger count00 = new AtomicInteger(0);
    private static Integer intger00 = new Integer(9999);

    //多次试验发现，现在的计算机性能可能显现不了1000*1000的量，可适当增加forSize
    private static final int forSize = 1000;
    private static CountDownLatch countDownLatch = new CountDownLatch(forSize);



    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < forSize; i++) {
            Runnable0 runnable0 = new Runnable0();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < forSize; i++) {
//                        count00++;
//                    }
//                    countDownLatch.countDown();
//                }
//            }).start();
            new Thread(runnable0).start();
        }
        countDownLatch.await();
        System.out.println(count00);
    }

    static class Runnable0 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < forSize; i++) {
                count00++;
//                count00.incrementAndGet();
            }
            countDownLatch.countDown();
        }
    }
}
