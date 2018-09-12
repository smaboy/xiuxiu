package com.smaboy.pc120.xiuxiu.c.constant;

/**
 * Created by Smoboy on 2017/8/7.
 *该类用于存放app网络请求地址
 *
 */

public class NetUrl {

    //浏览页面和看点页面，采用的是聚合数据的接口
    public static String JH_BASEURL = "http://v.juhe.cn/";
//    1.聊天页面


//    2.浏览页面
//    http://v.juhe.cn/toutiao/index?type=&key=a30ef33c261ff9bc9b809a87def82dfa
    public static String JH_NEWS_APPKEY = "a30ef33c261ff9bc9b809a87def82dfa";//聚合数据key

//    top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
    public static String LOOKING_TOP="top";
    public static String LOOKING_SHEHUI="shehui";
    public static String LOOKING_GUONEI="guonei";
    public static String LOOKING_GUOJI="guoji";
    public static String LOOKING_YULE="yule";
    public static String LOOKING_TIYU="tiyu";
    public static String LOOKING_JUNSHI="junshi";
    public static String LOOKING_KEJI="keji";
    public static String LOOKING_CAIJING="caijing";
    public static String LOOKING_SHISHANG="shishang";



//    3.看点页面
    public static String JH_WEIXIN_CHOICE_APPKEY = "5485d3c0541ca710b6b7e713f6ee4dba";//聚合数据微信精选key

    public static String JH_JOKE_APPKEY= "f95e5bf08f62e4bb4943128b63ba4042";//聚合数据笑话大全key

//    4。我的页面

    //app下载路径
    public static String UPAPP="https://raw.githubusercontent.com/smaboy/xiuxiu/master/xiu2xiu-release.apk";

}
