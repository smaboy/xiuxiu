package com.smaboy.pc120.xiuxiu.c;

/**
 * 类名: MessageEvent
 * 类作用描述: Eventbus消息类
 * 作者: Smaboy
 * 创建时间: 2018/9/14 15:47
 */
public class MessageEvent {

    private String message;

    public MessageEvent() {

    }
    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
