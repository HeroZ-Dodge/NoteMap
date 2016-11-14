package com.dodge.hero.notemap.presenter;

import com.dodge.hero.commontlibrary.presenter.BasePresenter;
import com.dodge.hero.notemap.data.DatabaseRepository;
import com.dodge.hero.notemap.data.model.MapPoint;
import com.dodge.hero.notemap.view.activity.IMapPointListView;

import java.util.List;

import javax.inject.Inject;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public class MapPointListPresenter extends BasePresenter<IMapPointListView, Object> {

    @Inject
    DatabaseRepository mRepository;

    public static final int PAGE_SIZE = 20;
    private int mCurrentPage = 1;

    @Inject
    public MapPointListPresenter() {

    }

    @Override
    public void present() {
        List<MapPoint> mapPoints = mRepository.loadMapPoint(PAGE_SIZE, mCurrentPage);
        if (mapPoints != null && !mapPoints.isEmpty()) {
            mView.loadFirstPageSuccess(mapPoints);
        } else {
//            mView.getExpansionView().showEmptyView();
        }
    }


    public void refreshList() {
        mCurrentPage = 1;
        present();
    }


    public void loadNextPage() {
        mCurrentPage += 1;
        List<MapPoint> mapPoints = mRepository.loadMapPoint(PAGE_SIZE, mCurrentPage);
        if (mapPoints != null && !mapPoints.isEmpty()) {

            // TODO 添加数据
        } else {
            // TODO 没有数据了
        }
    }

    public void deleteMapPoint(MapPoint mapPoint) {
        mRepository.deleteMapPoint(mapPoint);

    }


}
