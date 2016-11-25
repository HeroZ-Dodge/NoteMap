package com.dodge.hero.notemap.view.fragment;

import com.dodge.hero.commontlibrary.view.IBaseView;
import com.dodge.hero.notemap.data.model.MapPoint;

import java.util.List;

/**
 * Created by PC-239 on 2016/11/25.
 */

public interface IMapPointListView extends IBaseView {

    void loadFirstPageSuccess(List<MapPoint> mapPoints);

    void loadNextPageSuccess(List<MapPoint> mapPoints);

    void deleteSuccess();

    void deleteFailure();

}