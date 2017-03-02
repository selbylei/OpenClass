package com.example;

/**
 * Created by selbylei on 17/3/2.
 */

public class Looper {

    MessageQueue mQueue;

    private static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();


    public Looper() {
        this.mQueue = new MessageQueue();
    }

    /**
     * 返回当前线程绑定的Looper对象
     *
     * @return
     */
    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    //创建looper对象
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("一个线程只能有一个looper对象");
        }
        sThreadLocal.set(new Looper());
    }

    /**
     * loop轮询
     */
    public static void loop() {
        Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("no Looper");
        }
        MessageQueue mQueue = me.mQueue;
        for (; ; ) {
            Message message = mQueue.next();
            if (message != null) {
                continue;
            }
        }
    }

}
