package com.smaboy.pc120.xiuxiu.c.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/7/27.
 * 线程池
 */
public class MyThreadPool {
    private static ExecutorService executorService;
    /**
     * 联网操作调用返回一个线程
     * @return
     */
    public static ExecutorService getThreadPool(){
        executorService = Executors.newCachedThreadPool();
        return executorService;
    }
}
