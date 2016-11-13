package com.dodge.hero.notemap.data;

import com.dodge.hero.commontlibrary.data.database.IDatabaseManager;
import com.dodge.hero.notemap.data.model.MapPoint;

import java.util.List;

import javax.inject.Inject;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */
public class DatabaseRepository {

    @Inject
    IDatabaseManager mDatabaseManager;


    @Inject
    public DatabaseRepository() {
    }


    public void inserteMapPoint(MapPoint mapPoint) {
        mDatabaseManager.insert(mapPoint);
    }

    public void deleteMapPoint(MapPoint mapPoint) {
        mDatabaseManager.delete(mapPoint);
    }

    public void deleteMapPoint(List<MapPoint> mapPoints) {
        mDatabaseManager.delete(mapPoints, MapPoint.class);
    }

    public void updataMapPoint(MapPoint mapPoint) {
        mDatabaseManager.update(mapPoint);
    }

    public List<MapPoint> loadAllMapPoint() {
        return mDatabaseManager.loadAll(MapPoint.class);
    }



    public List<MapPoint> loadMapPoint(int size, int page) {
        if (page <= 0) {
            throw new IllegalArgumentException("页数不能小于或等于0");
        }
        int offset = page * size - size;
        return mDatabaseManager.loadList(MapPoint.class, size, offset);
    }


}
