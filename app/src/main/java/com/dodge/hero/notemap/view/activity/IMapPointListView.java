package com.dodge.hero.notemap.view.activity;

import com.dodge.hero.commontlibrary.view.IBaseView;
import com.dodge.hero.notemap.data.model.MapPoint;

import java.util.List;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public interface IMapPointListView extends IBaseView {

    void loadFirstPageSuccess(List<MapPoint> mapPoints);

    void loadNextPageSuccess(List<MapPoint> mapPoints);

    void deleteSuccess();

    void deleteFailure();

}
