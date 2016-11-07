package com.dodge.hero.notemap.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LinZheng on 2016/10/12.
 */
@Entity
public class UrlInfo {



    private String url;

    @Generated(hash = 2050507731)
    public UrlInfo(String url) {
        this.url = url;
    }

    @Generated(hash = 1350139298)
    public UrlInfo() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
