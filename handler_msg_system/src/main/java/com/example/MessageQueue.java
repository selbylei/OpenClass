package com.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by selbylei on 17/3/2.
 */

public class MessageQueue {

    Message[] items;
    int putIndex; //入队的Index
    int takeIndex; //出队的index
    int count = 0;

    Lock lock;
    //条件变量
    Condition notEmpty;
    Condition notFull;

    public MessageQueue() {
        this.items = new Message[50];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    /**
     * 消息入队(生产者)
     * 子线程
     * 生产速度比消费速度块，此时会覆盖
     * 消费速度比生产速度快，会取到控制
     *
     * @param msg
     */
    public void enqueueMessage(Message msg) {
        lock.lock();
        try {
            while (count == items.length) {
                //阻塞
                notFull.await();
            }
            //生产者队列已满，等待消费者消费
            items[putIndex] = msg;
            putIndex = (++putIndex == items.length) ? 0 : putIndex;
             //队列不为空，有产品可以消费了，通知消费者线程
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        count++;
    }

    /**
     * 消息出队(消费者)
     * 主线程
     *
     * @return
     */
    public Message next() {
        //消费者队列被掏空，等待生产者线程生产
        Message msg = null;
        try {
            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }
            msg = items[takeIndex];
            takeIndex = (++takeIndex == items.length) ? 0 : takeIndex;
            count--;
            //消费了一个产品，此时队列不为空，通知生产者生产
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return msg;
    }
}
