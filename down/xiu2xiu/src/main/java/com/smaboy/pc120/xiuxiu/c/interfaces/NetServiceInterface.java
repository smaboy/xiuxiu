package com.smaboy.pc120.xiuxiu.c.interfaces;

import com.smaboy.pc120.xiuxiu.m.domain.JokeEnty;
import com.smaboy.pc120.xiuxiu.m.domain.NewsTopEntity;
import com.smaboy.pc120.xiuxiu.m.domain.WeiXinChoiceEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Smaboy on 2018/3/8-21:06.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public interface NetServiceInterface {
//        AppKey：a30ef33c261ff9bc9b809a87def82dfa
//         新闻头条
//        请求地址：http://v.juhe.cn/toutiao/index
//        请求参数：type=&key=a30ef33c261ff9bc9b809a87def82dfa
//        请求方式：GET
//        type	string	否	类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),
//        tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
//    http://v.juhe.cn/toutiao/index?type=shehui&key=a30ef33c261ff9bc9b809a87def82dfa


    /**
     * 新闻页面请求接口
     * http://v.juhe.cn/toutiao/index?type=shehui&key=a30ef33c261ff9bc9b809a87def82dfa
     * @param type  类型，默认头条
     * @param key   在聚合数据，的key
     * @return
     */
    @GET("toutiao/index")
    Call<NewsTopEntity> getNewsByType(@Query("type") String type, @Query("key") String key);




    /**
     *
     *看点选项卡中的微信精选
     * http://v.juhe.cn/weixin/query?pno=&ps=&dtype=&key=5485d3c0541ca710b6b7e713f6ee4dba
     * @param pno  当前页数，默认1
     * @param ps   每条返回数，最大50，默认20
     * @param dtype 返回的数据格式，xml或json，默认是json
     * @return
     */
    @GET("weixin/query")
    Call<WeiXinChoiceEntity> getWeiXinChoice(@Query("pno") int pno, @Query("ps") int ps, @Query("dtype") String dtype, @Query("key") String key);



    /**
     * 看点选项卡中的笑话大全
     * http://v.juhe.cn/joke/randJoke.php?key=f95e5bf08f62e4bb4943128b63ba4042  //随机获取笑话
     *
     * @param key key
     * @return
     */
    @GET("joke/randJoke.php")
    Call<JokeEnty> getJoke( @Query("key") String key);

}
