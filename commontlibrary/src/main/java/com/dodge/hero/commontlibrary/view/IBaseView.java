package com.dodge.hero.commontlibrary.view;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.dodge.hero.commontlibrary.view.component.expansion.ExpansionView;

/**
 * Created by LinZheng on 2016/10/10.
 */

public interface IBaseView extends IView {

    @NonNull
    ExpansionView getExpansionView();

    @NonNull
    ViewGroup getContentLayout();

}
