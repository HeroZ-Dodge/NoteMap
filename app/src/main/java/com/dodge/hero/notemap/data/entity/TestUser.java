package com.dodge.hero.notemap.data.entity;

import com.dodge.hero.commontlibrary.data.database.IDaoEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by LinZheng on 2016/10/24.
 */
@Entity
public class TestUser extends User implements IDaoEntity{

    @Id
    private Long mId;

    private String address;
    private int yearsOld;
    @Generated(hash = 284724877)
    public TestUser(Long mId, String address, int yearsOld) {
        this.mId = mId;
        this.address = address;
        this.yearsOld = yearsOld;
    }
    @Generated(hash = 925009630)
    public TestUser() {
    }
    public Long getId() {
        return this.mId;
    }
    public void setId(Long id) {
        this.mId = id;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getYearsOld() {
        return this.yearsOld;
    }
    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }





}
