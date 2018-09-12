package com.smaboy.pc120.xiuxiu.c.interfaces;

/**
 * Created by Smaboy on 2017/12/21-15:16.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 这个Handler的用途是在发送短信之前，开发者自己执行一个操作，来根据电话号码判断是否需要发送短信
 *
 */

public interface MyOnSendMessageHandler extends cn.smssdk.OnSendMessageHandler{

    //#if def{lang} == cn
    /**
     * 此方法在发送验证短信前被调用，传入参数为接收者号码
     * 返回true表示此号码无须实际接收短信
     */
    //#elif def{lang} == en
    /**
     * This method will be called before verification message being to sent,
     * input params are the message receiver
     * return true means this number won't actually receive the message
     */
    //#endif
    public boolean onSendMessage(String country, String phone);

}
