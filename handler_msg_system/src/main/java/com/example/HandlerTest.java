package com.example;

import java.util.UUID;

/**
 * Created by selbylei on 17/3/2.
 */

public class HandlerTest {

    public static void main(String[] args) {

        final Handler handler = new Handler() {

            @Override
            public void handlerMessage(Message msg) {
                System.out.println("Thread:" + Thread.currentThread().getName());
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 1;
                msg.object = UUID.randomUUID().toString();
                System.out.println("Thread:" + Thread.currentThread().getName()+"||"+msg);
                handler.sendMessage(msg);
            }
        }.start();

        Looper.loop();
    }

}
