package com.example;

/**
 * Created by selbylei on 17/3/2.
 */

public class Handler {

    private Looper mLooper; //
    private MessageQueue mQueue;

    public Handler() {
        Looper.prepare();  //为线程创建唯一的Looper
        mLooper = Looper.myLooper(); //获取线程的looper
        mQueue = mLooper.mQueue; //looper的消息队列
    }

    /**
     * 子线程发送消息
     *
     * @param msg
     */
    public void sendMessage(Message msg) {
        msg.target = this;
        mQueue.enqueueMessage(msg);
        msg.target.handlerMessage(msg);
    }


    /**
     * 总线程处理消息
     *
     * @param msg
     */
    public void handlerMessage(Message msg) {

    }

}
