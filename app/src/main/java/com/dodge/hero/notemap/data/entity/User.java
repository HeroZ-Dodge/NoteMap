package com.dodge.hero.notemap.data.entity;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Entity
public class User {
    @Id
    private long id;

    @NonNull
    private String name;

    @Generated(hash = 930343602)
    public User(long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
