package com.smaboy.pc120.xiuxiu.m.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Smaboy on 2017/12/17-22:57.
 * WHERE IS A WILL,THERE IS A WAY!
 *
 * 联系人封装类
 */
@Entity
public class Contact {

    @Id
    private Long id;
    @Property(nameInDb = "USERUD")
    private String userId;
    @Property(nameInDb = "USERPWD")
    private String userPwd;
    @Property(nameInDb = "USERHEAD")
    private String userHead;
    @Property(nameInDb = "USERNICK")
    private String userNick;
    @Generated(hash = 1784173211)
    public Contact(Long id, String userId, String userPwd, String userHead,
            String userNick) {
        this.id = id;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userHead = userHead;
        this.userNick = userNick;
    }
    @Generated(hash = 672515148)
    public Contact() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPwd() {
        return this.userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserHead() {
        return this.userHead;
    }
    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }
    public String getUserNick() {
        return this.userNick;
    }
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }



}
