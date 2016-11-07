package com.dodge.hero.notemap;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LinZheng on 2016/10/12.
 */

@Entity
public class Book {

    @Id
    private Long id;

    @Generated(hash = 1128579675)
    public Book(Long id) {
        this.id = id;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
