package com.dodge.hero.notemap.data.model;

import com.dodge.hero.commontlibrary.data.database.IDaoEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 地图位置实体类型
 * Created by LinZheng on 2016/10/11.
 */
@Entity
public class MapPoint implements IDaoEntity{

    @Id(autoincrement = true)
    public Long id;

    Double longitude; // 经度

    Double latitude; //  纬度

    @NotNull
    String name;

    @NotNull
    String address;

    String phoneNumber;

    String description;

    Long createData;

    Long lastModifyData;

    String pictureUri;

    @Generated(hash = 1161162431)
    public MapPoint(Long id, Double longitude, Double latitude,
            @NotNull String name, @NotNull String address, String phoneNumber,
            String description, Long createData, Long lastModifyData,
            String pictureUri) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.createData = createData;
        this.lastModifyData = lastModifyData;
        this.pictureUri = pictureUri;
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

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreateData() {
        return this.createData;
    }

    public void setCreateData(Long createData) {
        this.createData = createData;
    }

    public Long getLastModifyData() {
        return this.lastModifyData;
    }

    public void setLastModifyData(Long lastModifyData) {
        this.lastModifyData = lastModifyData;
    }

    public String getPictureUri() {
        return this.pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

}
