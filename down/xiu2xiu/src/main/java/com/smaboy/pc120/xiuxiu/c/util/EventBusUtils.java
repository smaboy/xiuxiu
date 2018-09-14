package com.smaboy.pc120.xiuxiu.c.util;


import org.greenrobot.eventbus.EventBus;

/**
 * ThreadMode.MAIN          不管从哪个线程发出的事件，MAIN模式都会在UI（主线程）线程执行
 * ThreadMode.POSTING       事件从哪个线程发布出来的就会在该线程中运行
 * ThreadMode.BACKGROUND    如果发送事件的线程是UI线程，则重新创建新的子线程执行，因此不能执行更新UI的操作
 * ThreadMode.ASYNC         不管从哪个线程发出的事件，ASYNC模式都会创建一个新的子线程来执行</span>
 *
 * Created by 40592 on 2018/7/21-13:48.
 * WHERE IS A WILL,THERE IS A WAY!
 */
public class EventBusUtils {
    private EventBusUtils() {
    }

    /**
     * 注册EventBus
     *
     * @param subscriber 订阅者对象
     */
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            LogUtil.e("register: 注册成功");
            EventBus.getDefault().register(subscriber);
        } else {
            LogUtil.e( "register: 注册失败");
        }
    }

    /**
     * 取消注册EventBus
     *
     * @param subscriber 订阅者对象
     */
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发布订阅事件
     *
     * @param event 事件对象
     */
    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发布粘性订阅事件
     *
     * @param event 事件对象
     */
    public static void postSticky(Object event) {
        EventBus.getDefault().postSticky(event);
    }

    /**
     * 移除指定的粘性订阅事件
     *
     * @param eventType class的字节码，例如：String.class
     */
    public static <T> void removeStickyEvent(Class<T> eventType) {
        T stickyEvent = EventBus.getDefault().getStickyEvent(eventType);
        if (stickyEvent != null) {
            EventBus.getDefault().removeStickyEvent((T) stickyEvent);
        }
    }
    /**
     * 移除所有的粘性订阅事件
     */
    public static void removeAllStickyEvents() {
        EventBus.getDefault().removeAllStickyEvents();
    }

    /**
     * 取消事件传送
     *
     * @param event 事件对象
     */
    public static void cancelEventDelivery(Object event) {
        EventBus.getDefault().cancelEventDelivery(event);
    }


}
