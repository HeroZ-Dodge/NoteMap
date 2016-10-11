package com.dodge.hero.notemap.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LinZheng on 2016/10/11.
 */
@Entity
public class MapPoint {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    String name;

    @NotNull
    String address;


    @Generated(hash = 1085752854)
    public MapPoint(Long id, @NotNull String name, @NotNull String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Generated(hash = 876942795)
    public MapPoint() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}
