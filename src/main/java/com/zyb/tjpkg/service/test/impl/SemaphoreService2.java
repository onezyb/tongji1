package com.zyb.tjpkg.service.test.impl;

import com.zyb.tjpkg.service.test.SemaphoreService;

import java.util.concurrent.Semaphore;

public class SemaphoreService2 extends SemaphoreService{
    private Semaphore semaphore = new Semaphore(6);// 6表示总共有6个通路

    public void doSomething() {
        try {
            semaphore.acquire(2); // 2 表示进入此代码，就会消耗2个通路，2个通路从6个中扣除
            System.out.println(Thread.currentThread().getName() + ":doSomething start-" + getFormatTimeStr());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ":doSomething end-" + getFormatTimeStr());
            semaphore.release(1); // 释放占用的 1 个通路
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int availablePermits() {
        return semaphore.availablePermits();
    }
}
