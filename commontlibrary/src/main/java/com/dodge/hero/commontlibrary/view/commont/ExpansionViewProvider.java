package com.dodge.hero.commontlibrary.view.commont;

import android.widget.FrameLayout;

/**
 * Created by LinZheng on 2016/10/9.
 */

public abstract class ExpansionViewProvider {

    public abstract ExpansionView createExpansionView(FrameLayout frameLayout);

    public static ExpansionViewProvider DEFAULT = new ExpansionViewProvider() {
        @Override
        public ExpansionView createExpansionView(FrameLayout frameLayout) {
            return new DefaultExpansionView(frameLayout);
        }
    };

}
