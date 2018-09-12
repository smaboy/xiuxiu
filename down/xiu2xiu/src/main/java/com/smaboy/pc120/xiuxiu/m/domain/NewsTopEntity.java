package com.smaboy.pc120.xiuxiu.m.domain;

import java.util.List;

/**
 * Created by Smaboy on 2018/3/8-21:49.
 * WHERE IS A WILL,THERE IS A WAY!
 */

public class NewsTopEntity {

    @Override
    public String toString() {
        return "NewsTopEntity{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"c48766abe7deb1a3164cb3af2650a878","title":"健身老手们都非常重视肩部的训练，新手练不对很容易受伤","date":"2018-03-08 20:16","category":"头条","author_name":"健身刊","url":"http://mini.eastday.com/mobile/180308201636502.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_4_mwpm_03200403.jpg"},{"uniquekey":"9f252c592ee5d16159194ac857fd0672","title":"新人正在酒店举行婚礼，大屏幕上突然出现了这么一幕","date":"2018-03-08 20:36","category":"头条","author_name":"半岛晨报","url":"http://mini.eastday.com/mobile/180308203609545.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308203609_2ecefaf889abdad04f57dd0dbf9b46f7_1_mwpm_03200403.jpg"},{"uniquekey":"3b68937e0fce933386dd990f61ada150","title":"政协第二场记者会 5位委员回应了哪些经济热点？","date":"2018-03-08 20:26","category":"头条","author_name":"海外网","url":"http://mini.eastday.com/mobile/180308202655959.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308202655_a1a559ab464f38e41cf8de7e1f2eb765_1_mwpm_03200403.jpg"},{"uniquekey":"d97240506d9a0d193740f0405f69221e","title":"雍成瀚：劝耕贷在安徽取得硕果","date":"2018-03-08 20:17","category":"头条","author_name":"东北网","url":"http://mini.eastday.com/mobile/180308201721155.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308201721_b56e4a0e86ab8c3a4de8dcb4ac94b04c_1_mwpm_03200403.jpg"},{"uniquekey":"265bc860ed08233e5ac1d0b92ce7f6d8","title":"【大使看两会】中国在这些方面为全世界树立了榜样！","date":"2018-03-08 20:12","category":"头条","author_name":"中国甘肃网","url":"http://mini.eastday.com/mobile/180308201245589.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308201245_52b557f35516783dcc2e9d87e02e511f_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308201245_52b557f35516783dcc2e9d87e02e511f_2_mwpm_03200403.jpg"},{"uniquekey":"d9351b5b7b034f279b14eabaaa762000","title":"蒋超良在回答人民日报记者提问时提出 做好长江大保护\u201c辩证法\u201d","date":"2018-03-08 20:08","category":"头条","author_name":"长江网","url":"http://mini.eastday.com/mobile/180308200825601.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308200825_40a0a328d6b56626d673acc8b9209d78_1_mwpm_03200403.jpg"},{"uniquekey":"878bf00bf82117dfc5cfa47412e11d35","title":"全球最大、航母最多、设施最完善的海军基地：诺福克海军基地","date":"2018-03-08 20:05","category":"头条","author_name":"西海舰队","url":"http://mini.eastday.com/mobile/180308200537773.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308_8842670f50d4eb2e0106158eaf323773_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180308/20180308_6e29cda64260d4ff3b50e38933a12cb5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180308/20180308_77dd1294c9d7d0e726bc6a0cc9a25394_cover_mwpm_03200403.jpg"},{"uniquekey":"dfc87082d8873efb4a279ab35d384394","title":"美军大量武器输送到乌克兰 俄乌一片混战已成必然！","date":"2018-03-08 20:04","category":"头条","author_name":"军谈小酒吧","url":"http://mini.eastday.com/mobile/180308200404207.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308_fc25ef4b2b2aa10f4d0d7ff6d52d00ac_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308_8251c8d7f86638f3228f0a4cee8dfa94_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308_6c5e3a6737105396a8d56c5a5f648729_cover_mwpm_03200403.jpg"},{"uniquekey":"9c6f26d1424943477f24f9107ff1223e","title":"中国比特币持有量第一人：账上现金都买成虚拟币，经常被限制出境","date":"2018-03-08 19:43","category":"头条","author_name":"科技圈子","url":"http://mini.eastday.com/mobile/180308194317715.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_2_mwpm_03200403.jpg"},{"uniquekey":"d406658d4f7e2d91f3c41d17f48b87f6","title":"上百万的背部就靠这4大绝招！","date":"2018-03-08 19:18","category":"头条","author_name":"谦神","url":"http://mini.eastday.com/mobile/180308191847879.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_6_mwpm_03200403.jpg"},{"uniquekey":"27088dcbe462eb577c4b753ba25f2d78","title":"「活着不孝，死后乱叫」：生前不让爹娘吃，死后何必去祭坟","date":"2018-03-08 19:01","category":"头条","author_name":"美文共享","url":"http://mini.eastday.com/mobile/180308190152556.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_7_mwpm_03200403.jpg"},{"uniquekey":"a490d6853af1985b8289955d4b5eb9c2","title":"5岁熊孩子暗地策划逃学 \u201c越狱\u201d后仍一步三回头","date":"2018-03-08 18:57","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180308185751536.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_3_mwpm_03200403.jpg"},{"uniquekey":"d4343a7dff6f20215ef35a5fd3f24887","title":"能力创造价值 国美\u201c黑伍\u201d助力家庭美好生活实现","date":"2018-03-08 18:56","category":"头条","author_name":"中国质量新闻网","url":"http://mini.eastday.com/mobile/180308185639212.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_1_mwpm_03200403.jpg"},{"uniquekey":"b948e0245a79e1f85befc9a7e60c8c35","title":"美舰\u201c麦凯恩\u201d号撞船事故因急转弯，船员系抽调或不熟悉操作","date":"2018-03-08 18:55","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/180308185508745.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308185508_868927bbf5958acface7a3903e6e4a27_1_mwpm_03200403.jpg"},{"uniquekey":"2abd2cce0a7e824e2767badf62279399","title":"波比跳，居家燃脂好方法，不想跑步就试试这个吧！","date":"2018-03-08 18:47","category":"头条","author_name":"浇忆恋j02","url":"http://mini.eastday.com/mobile/180308184704916.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_2_mwpm_03200403.jpg"},{"uniquekey":"4da9848bb82ca9dc606445f206d35bf3","title":"美国14岁华裔学生开发app，帮助阿兹海默症患者记起亲人","date":"2018-03-08 18:44","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/180308184454914.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308184454_1f676cac83d2c4ed8379e1bba81a607e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308184454_1f676cac83d2c4ed8379e1bba81a607e_2_mwpm_03200403.jpg"},{"uniquekey":"2931c8ca736abbd810623430152eb645","title":"\u201c三八\u201d节坚守岗位的导游为游客服务 展巾帼风采","date":"2018-03-08 18:44","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308184441512.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_2_mwpm_03200403.jpg"},{"uniquekey":"d9ce2ca757cf9986e11e0116e32cb3c9","title":"贵州省委书记：来一场振兴农村经济的深刻产业革命","date":"2018-03-08 18:44","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308184441217.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308184441_26d8bfaa6a578f94259cf73bedaa56d7_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308184441_26d8bfaa6a578f94259cf73bedaa56d7_1_mwpm_03200403.jpg"},{"uniquekey":"48c633a2896643db459adc86354d29db","title":"两会\u201c炊事班\u201d丨如果战斗在今夜打响，信心底气从实战化练兵中来","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184116698.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_b02bf169d9b8f6fb023feeeeff4e5400_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_85f9beb0b931dc0b7bff2357452ab2e5_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_f96517bcc1a2427ae078026ecacd90e0_1_mwpm_03200403.jpg"},{"uniquekey":"3496f11da306e93cc7b5e13de4ed5005","title":"全国人大代表杜家毫：还洞庭湖一湖清水 坚定不移","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184115801.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308184115_9cf282f68ec511f2da5b3d1443fa2639_1_mwpm_03200403.jpg"},{"uniquekey":"0de9a26309a371844ed0019a1f34f837","title":"军队人大代表王天目：基层实战化训练方式手段不断创新","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184115357.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308184115_0a7d7b1e7be8d4919436117cb9f6b7ec_1_mwpm_03200403.jpg"},{"uniquekey":"6ad7393e78dc7df1dcf246a15dc2111c","title":"组图：黎姿晒美照庆祝妇女节 送\u201c鸡汤\u201d祝大家心灵成熟又可爱","date":"2018-03-08 18:40","category":"头条","author_name":"大众网","url":"http://mini.eastday.com/mobile/180308184043236.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_3_mwpm_03200403.jpg"},{"uniquekey":"843b7258d18ba7b1cf17ed46b779e1b3","title":"华媒看两会：历史机遇期 修宪助\u201c定海神针\u201d发挥作用","date":"2018-03-08 18:24","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308182428856.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308182428_63b9ac1a91ec06a75b99915fccffb7ff_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308182428_63b9ac1a91ec06a75b99915fccffb7ff_1_mwpm_03200403.jpg"},{"uniquekey":"2d379bcba38d57af6d08ef8bed89cfc9","title":"\u201c梦伴京程\u201d音乐家的摇篮：中国音乐学院附属幼儿园","date":"2018-03-08 18:21","category":"头条","author_name":"北方网","url":"http://mini.eastday.com/mobile/180308182145998.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_4_mwpm_03200403.jpg"},{"uniquekey":"b5cb79d26e1544efd7094e0aa17cce5f","title":"全国人大代表鹿新弟:工匠精神塑造东北振兴的人才内核 新时代劳模着重创新力","date":"2018-03-08 18:21","category":"头条","author_name":"东北网","url":"http://mini.eastday.com/mobile/180308182128100.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308182128_a6e37f8cc4e771e94bae40a2a452ede1_1_mwpm_03200403.jpg"},{"uniquekey":"763bc42cd27eb36a498da3a64fe8adca","title":"2018中国家电及消费电子博览会今开幕 家电企业纷纷再触\u201c电\u201d","date":"2018-03-08 18:20","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180308182036052.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180308/20180308182036_552e78881d5ffe72644e1dfe195c1c9e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180308/20180308182036_552e78881d5ffe72644e1dfe195c1c9e_2_mwpm_03200403.jpg"},{"uniquekey":"8303cb1fb0afd4c35e6bb6b1453d87c7","title":"柳州妹子用\u201c滴滴出行\u201d去拉堡 人还没上车钱就没了","date":"2018-03-08 18:16","category":"头条","author_name":"中国经济网","url":"http://mini.eastday.com/mobile/180308181636976.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_2_mwpm_03200403.jpg"},{"uniquekey":"c3c2a0f392ce7b88b0b4f31a17438b16","title":"克缇连续两年纳税上海松江区第一 区委领导一行参访","date":"2018-03-08 18:16","category":"头条","author_name":"中国经济网","url":"http://mini.eastday.com/mobile/180308181636828.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_4_mwpm_03200403.jpg"},{"uniquekey":"ccad95e0ba54c2bdec746cbfc561b823","title":"【2018两会\u2022改革新征程】中国有实力继续为世界经济做贡献","date":"2018-03-08 18:15","category":"头条","author_name":"国际在线","url":"http://mini.eastday.com/mobile/180308181511215.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308181511_5a3d86220607ac3eece2ca0b94d0f3e7_1_mwpm_03200403.jpg"},{"uniquekey":"8830f0f0de92e6733c2b2647428381f3","title":"\u201c三八\u201d妇女节近万朵厄瓜多尔玫瑰致敬南航女性乘客","date":"2018-03-08 18:14","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308181424699.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_1_mwpm_03200403.jpg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"c48766abe7deb1a3164cb3af2650a878","title":"健身老手们都非常重视肩部的训练，新手练不对很容易受伤","date":"2018-03-08 20:16","category":"头条","author_name":"健身刊","url":"http://mini.eastday.com/mobile/180308201636502.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_4_mwpm_03200403.jpg"},{"uniquekey":"9f252c592ee5d16159194ac857fd0672","title":"新人正在酒店举行婚礼，大屏幕上突然出现了这么一幕","date":"2018-03-08 20:36","category":"头条","author_name":"半岛晨报","url":"http://mini.eastday.com/mobile/180308203609545.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308203609_2ecefaf889abdad04f57dd0dbf9b46f7_1_mwpm_03200403.jpg"},{"uniquekey":"3b68937e0fce933386dd990f61ada150","title":"政协第二场记者会 5位委员回应了哪些经济热点？","date":"2018-03-08 20:26","category":"头条","author_name":"海外网","url":"http://mini.eastday.com/mobile/180308202655959.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308202655_a1a559ab464f38e41cf8de7e1f2eb765_1_mwpm_03200403.jpg"},{"uniquekey":"d97240506d9a0d193740f0405f69221e","title":"雍成瀚：劝耕贷在安徽取得硕果","date":"2018-03-08 20:17","category":"头条","author_name":"东北网","url":"http://mini.eastday.com/mobile/180308201721155.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308201721_b56e4a0e86ab8c3a4de8dcb4ac94b04c_1_mwpm_03200403.jpg"},{"uniquekey":"265bc860ed08233e5ac1d0b92ce7f6d8","title":"【大使看两会】中国在这些方面为全世界树立了榜样！","date":"2018-03-08 20:12","category":"头条","author_name":"中国甘肃网","url":"http://mini.eastday.com/mobile/180308201245589.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308201245_52b557f35516783dcc2e9d87e02e511f_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308201245_52b557f35516783dcc2e9d87e02e511f_2_mwpm_03200403.jpg"},{"uniquekey":"d9351b5b7b034f279b14eabaaa762000","title":"蒋超良在回答人民日报记者提问时提出 做好长江大保护\u201c辩证法\u201d","date":"2018-03-08 20:08","category":"头条","author_name":"长江网","url":"http://mini.eastday.com/mobile/180308200825601.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308200825_40a0a328d6b56626d673acc8b9209d78_1_mwpm_03200403.jpg"},{"uniquekey":"878bf00bf82117dfc5cfa47412e11d35","title":"全球最大、航母最多、设施最完善的海军基地：诺福克海军基地","date":"2018-03-08 20:05","category":"头条","author_name":"西海舰队","url":"http://mini.eastday.com/mobile/180308200537773.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308_8842670f50d4eb2e0106158eaf323773_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180308/20180308_6e29cda64260d4ff3b50e38933a12cb5_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180308/20180308_77dd1294c9d7d0e726bc6a0cc9a25394_cover_mwpm_03200403.jpg"},{"uniquekey":"dfc87082d8873efb4a279ab35d384394","title":"美军大量武器输送到乌克兰 俄乌一片混战已成必然！","date":"2018-03-08 20:04","category":"头条","author_name":"军谈小酒吧","url":"http://mini.eastday.com/mobile/180308200404207.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308_fc25ef4b2b2aa10f4d0d7ff6d52d00ac_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308_8251c8d7f86638f3228f0a4cee8dfa94_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308_6c5e3a6737105396a8d56c5a5f648729_cover_mwpm_03200403.jpg"},{"uniquekey":"9c6f26d1424943477f24f9107ff1223e","title":"中国比特币持有量第一人：账上现金都买成虚拟币，经常被限制出境","date":"2018-03-08 19:43","category":"头条","author_name":"科技圈子","url":"http://mini.eastday.com/mobile/180308194317715.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_7_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180308/20180308194317_c7a81159e8f22284cd1f6b8ccef481e0_2_mwpm_03200403.jpg"},{"uniquekey":"d406658d4f7e2d91f3c41d17f48b87f6","title":"上百万的背部就靠这4大绝招！","date":"2018-03-08 19:18","category":"头条","author_name":"谦神","url":"http://mini.eastday.com/mobile/180308191847879.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_9_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180308/20180308191847_c96be9e248504a0533a66ecf1dd1115f_6_mwpm_03200403.jpg"},{"uniquekey":"27088dcbe462eb577c4b753ba25f2d78","title":"「活着不孝，死后乱叫」：生前不让爹娘吃，死后何必去祭坟","date":"2018-03-08 19:01","category":"头条","author_name":"美文共享","url":"http://mini.eastday.com/mobile/180308190152556.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308190152_4ec0e9f5e42317cadaaa01c386adfa20_7_mwpm_03200403.jpg"},{"uniquekey":"a490d6853af1985b8289955d4b5eb9c2","title":"5岁熊孩子暗地策划逃学 \u201c越狱\u201d后仍一步三回头","date":"2018-03-08 18:57","category":"头条","author_name":"看看新闻网","url":"http://mini.eastday.com/mobile/180308185751536.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308185751_4de81686dedc502df661ddadda6cc125_3_mwpm_03200403.jpg"},{"uniquekey":"d4343a7dff6f20215ef35a5fd3f24887","title":"能力创造价值 国美\u201c黑伍\u201d助力家庭美好生活实现","date":"2018-03-08 18:56","category":"头条","author_name":"中国质量新闻网","url":"http://mini.eastday.com/mobile/180308185639212.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180308/20180308185639_a790fb107c062fa1c21713f1b37940f8_1_mwpm_03200403.jpg"},{"uniquekey":"b948e0245a79e1f85befc9a7e60c8c35","title":"美舰\u201c麦凯恩\u201d号撞船事故因急转弯，船员系抽调或不熟悉操作","date":"2018-03-08 18:55","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/180308185508745.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308185508_868927bbf5958acface7a3903e6e4a27_1_mwpm_03200403.jpg"},{"uniquekey":"2abd2cce0a7e824e2767badf62279399","title":"波比跳，居家燃脂好方法，不想跑步就试试这个吧！","date":"2018-03-08 18:47","category":"头条","author_name":"浇忆恋j02","url":"http://mini.eastday.com/mobile/180308184704916.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180308/20180308184704_9a45319159c581a7fc9734add8ffb55f_2_mwpm_03200403.jpg"},{"uniquekey":"4da9848bb82ca9dc606445f206d35bf3","title":"美国14岁华裔学生开发app，帮助阿兹海默症患者记起亲人","date":"2018-03-08 18:44","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/180308184454914.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308184454_1f676cac83d2c4ed8379e1bba81a607e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308184454_1f676cac83d2c4ed8379e1bba81a607e_2_mwpm_03200403.jpg"},{"uniquekey":"2931c8ca736abbd810623430152eb645","title":"\u201c三八\u201d节坚守岗位的导游为游客服务 展巾帼风采","date":"2018-03-08 18:44","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308184441512.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180308/20180308184441_28e4ba2b6de2b683d86e906fd0c09b6f_2_mwpm_03200403.jpg"},{"uniquekey":"d9ce2ca757cf9986e11e0116e32cb3c9","title":"贵州省委书记：来一场振兴农村经济的深刻产业革命","date":"2018-03-08 18:44","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308184441217.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308184441_26d8bfaa6a578f94259cf73bedaa56d7_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308184441_26d8bfaa6a578f94259cf73bedaa56d7_1_mwpm_03200403.jpg"},{"uniquekey":"48c633a2896643db459adc86354d29db","title":"两会\u201c炊事班\u201d丨如果战斗在今夜打响，信心底气从实战化练兵中来","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184116698.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_b02bf169d9b8f6fb023feeeeff4e5400_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_85f9beb0b931dc0b7bff2357452ab2e5_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180308/20180308184116_f96517bcc1a2427ae078026ecacd90e0_1_mwpm_03200403.jpg"},{"uniquekey":"3496f11da306e93cc7b5e13de4ed5005","title":"全国人大代表杜家毫：还洞庭湖一湖清水 坚定不移","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184115801.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308184115_9cf282f68ec511f2da5b3d1443fa2639_1_mwpm_03200403.jpg"},{"uniquekey":"0de9a26309a371844ed0019a1f34f837","title":"军队人大代表王天目：基层实战化训练方式手段不断创新","date":"2018-03-08 18:41","category":"头条","author_name":"央广网","url":"http://mini.eastday.com/mobile/180308184115357.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308184115_0a7d7b1e7be8d4919436117cb9f6b7ec_1_mwpm_03200403.jpg"},{"uniquekey":"6ad7393e78dc7df1dcf246a15dc2111c","title":"组图：黎姿晒美照庆祝妇女节 送\u201c鸡汤\u201d祝大家心灵成熟又可爱","date":"2018-03-08 18:40","category":"头条","author_name":"大众网","url":"http://mini.eastday.com/mobile/180308184043236.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180308/20180308184043_786600914c0d2b64f61ee2fc36cb3f28_3_mwpm_03200403.jpg"},{"uniquekey":"843b7258d18ba7b1cf17ed46b779e1b3","title":"华媒看两会：历史机遇期 修宪助\u201c定海神针\u201d发挥作用","date":"2018-03-08 18:24","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308182428856.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180308/20180308182428_63b9ac1a91ec06a75b99915fccffb7ff_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180308/20180308182428_63b9ac1a91ec06a75b99915fccffb7ff_1_mwpm_03200403.jpg"},{"uniquekey":"2d379bcba38d57af6d08ef8bed89cfc9","title":"\u201c梦伴京程\u201d音乐家的摇篮：中国音乐学院附属幼儿园","date":"2018-03-08 18:21","category":"头条","author_name":"北方网","url":"http://mini.eastday.com/mobile/180308182145998.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180308/20180308182145_6ade006c0810b5df238343ab234fa446_4_mwpm_03200403.jpg"},{"uniquekey":"b5cb79d26e1544efd7094e0aa17cce5f","title":"全国人大代表鹿新弟:工匠精神塑造东北振兴的人才内核 新时代劳模着重创新力","date":"2018-03-08 18:21","category":"头条","author_name":"东北网","url":"http://mini.eastday.com/mobile/180308182128100.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308182128_a6e37f8cc4e771e94bae40a2a452ede1_1_mwpm_03200403.jpg"},{"uniquekey":"763bc42cd27eb36a498da3a64fe8adca","title":"2018中国家电及消费电子博览会今开幕 家电企业纷纷再触\u201c电\u201d","date":"2018-03-08 18:20","category":"头条","author_name":"新民网","url":"http://mini.eastday.com/mobile/180308182036052.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180308/20180308182036_552e78881d5ffe72644e1dfe195c1c9e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180308/20180308182036_552e78881d5ffe72644e1dfe195c1c9e_2_mwpm_03200403.jpg"},{"uniquekey":"8303cb1fb0afd4c35e6bb6b1453d87c7","title":"柳州妹子用\u201c滴滴出行\u201d去拉堡 人还没上车钱就没了","date":"2018-03-08 18:16","category":"头条","author_name":"中国经济网","url":"http://mini.eastday.com/mobile/180308181636976.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180308/20180308181636_82e84400615cdaf9f44450e6b5147330_2_mwpm_03200403.jpg"},{"uniquekey":"c3c2a0f392ce7b88b0b4f31a17438b16","title":"克缇连续两年纳税上海松江区第一 区委领导一行参访","date":"2018-03-08 18:16","category":"头条","author_name":"中国经济网","url":"http://mini.eastday.com/mobile/180308181636828.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180308/20180308181636_8b6c9905b76ebdafe9d1ac4d5f1b5479_4_mwpm_03200403.jpg"},{"uniquekey":"ccad95e0ba54c2bdec746cbfc561b823","title":"【2018两会\u2022改革新征程】中国有实力继续为世界经济做贡献","date":"2018-03-08 18:15","category":"头条","author_name":"国际在线","url":"http://mini.eastday.com/mobile/180308181511215.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180308/20180308181511_5a3d86220607ac3eece2ca0b94d0f3e7_1_mwpm_03200403.jpg"},{"uniquekey":"8830f0f0de92e6733c2b2647428381f3","title":"\u201c三八\u201d妇女节近万朵厄瓜多尔玫瑰致敬南航女性乘客","date":"2018-03-08 18:14","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180308181424699.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180308/20180308181424_4c693dc93998bab859e1e3aecb40b838_1_mwpm_03200403.jpg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : c48766abe7deb1a3164cb3af2650a878
             * title : 健身老手们都非常重视肩部的训练，新手练不对很容易受伤
             * date : 2018-03-08 20:16
             * category : 头条
             * author_name : 健身刊
             * url : http://mini.eastday.com/mobile/180308201636502.html
             * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_2_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_5_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20180308/20180308201636_9cb86c5420b0e7de732c9ed5854cd618_4_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }


}
