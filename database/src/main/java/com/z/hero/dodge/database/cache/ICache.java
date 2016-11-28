package com.z.hero.dodge.database.cache;


import com.google.gson.reflect.TypeToken;

/**
 * Created by moo on 16/4/23.
 */
public interface ICache {


    long EXPIRE_ONE_HOUR = 3600 * 1000;              //1小时

    long EXPIRE_ONE_DAY = 7 * 24 * EXPIRE_ONE_HOUR;     //1天

    long EXPIRE_SEVEN_DAY = 7 * EXPIRE_ONE_DAY;   //一星期

    long EXPIRE_ONE_MONTH = 30 * EXPIRE_ONE_DAY;   //一个月

    <T> T get(String key, T defaultValue);

    <T> void set(String key, T value, long expire);

    <T> void set(String key, T value);

    <T> T get(String key, Class<T> clazz);

    <T> void set(String key, T value, Class<T> clazz, long expire);

    <T> T get(String key, TypeToken<T> typeToken);

    <T> void set(String key, T value, TypeToken<T> typeToken, long expire);

    boolean containKey(String key);

    void remove(String key);

    void clear();
}
