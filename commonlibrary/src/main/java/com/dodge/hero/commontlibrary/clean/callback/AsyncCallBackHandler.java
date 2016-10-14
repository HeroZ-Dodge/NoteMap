package com.dodge.hero.commontlibrary.clean.callback;


/**
 * Created by moo on 16/5/12.
 */
public class AsyncCallBackHandler {
    public static <T> boolean handleSuccessCallBack(T data, AsyncCallBack<T> asyncCallBack) {
        if (asyncCallBack != null) {
            asyncCallBack.onSuccess(data);
            return true;
        }
        return false;
    }

    public static <T> boolean handleFailureCalBack(Throwable throwable, AsyncCallBack<T> asyncCallBack) {
        if (asyncCallBack != null) {
            asyncCallBack.onFailure(-1, throwable.getMessage());
            return true;
        }
        return false;
    }

    public static <T> boolean handleReceiveCacheData(T data, AsyncCallBack<T> asyncCallBack) {
        if (asyncCallBack != null) {
            asyncCallBack.onGetCacheData(data);
            return true;
        }
        return false;
    }

    public static <T> boolean handleCancel(AsyncCallBack<T> asyncCallBack) {
        if (asyncCallBack != null) {
            asyncCallBack.onCancel();
            return true;
        }
        return false;
    }
}
