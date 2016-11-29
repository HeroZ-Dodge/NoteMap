package com.dodge.hero.notemap.view.adapter;

import android.content.Context;

import com.dodge.hero.notemap.data.model.MapPoint;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 描述:
 * Created by LinZheng on 2016/11/13.
 */

public class MapPointAdapter extends CommonAdapter<MapPoint> {

    public MapPointAdapter(Context context, int layoutId, List<MapPoint> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(ViewHolder holder, MapPoint mapPoint, int position) {

    }



}
