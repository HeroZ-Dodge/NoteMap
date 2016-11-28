package com.z.hero.dodge.database.cache.impl;

import android.content.SharedPreferences;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.google.gson.reflect.TypeToken;
import com.z.hero.dodge.database.cache.ICache;


/**
 * 缓存
 * Created by moo on 16/4/23.
 */
public class PreferenceCache implements ICache {
    private RxSharedPreferences rxSharedPreferences;
    private SharedPreferences sharedPreferences;

    public PreferenceCache(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.rxSharedPreferences = RxSharedPreferences.create(sharedPreferences);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String key, T defaultValue) {
        if (!isExpired(key)) {
            if (defaultValue instanceof String) {
                return (T) rxSharedPreferences.getString(key, (String) defaultValue).get();
            } else if (defaultValue instanceof Long) {
                return (T) rxSharedPreferences.getLong(key, (Long) defaultValue).get();
            } else if (defaultValue instanceof Float) {
                return (T) rxSharedPreferences.getFloat(key, (Float) defaultValue).get();
            } else if (defaultValue instanceof Integer) {
                return (T) rxSharedPreferences.getInteger(key, (Integer) defaultValue).get();
            } else if (defaultValue instanceof Boolean) {
                return (T) rxSharedPreferences.getBoolean(key, (Boolean) defaultValue).get();
            } else {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    @Override
    public <T> void set(String key, T value, long expire) {
        if (value instanceof String) {
            rxSharedPreferences.getString(key).set((String) value);
        } else if (value instanceof Long) {
            rxSharedPreferences.getLong(key).set((Long) value);
        } else if (value instanceof Float) {
            rxSharedPreferences.getFloat(key).set((Float) value);
        } else if (value instanceof Integer) {
            rxSharedPreferences.getInteger(key).set((Integer) value);
        } else if (value instanceof Boolean) {
            rxSharedPreferences.getBoolean(key).set((Boolean) value);
        }
        saveExpiredTime(key, expire);
    }

    @Override
    public <T> void set(String key, T value) {
        set(key, value, ICache.EXPIRE_ONE_MONTH);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if (!isExpired(key)) {
            return rxSharedPreferences.getObject(key, null, new GsonPreferenceAdapter<>(clazz)).get();
        }
        return null;
    }

    @Override
    public <T> void set(String key, T value, Class<T> clazz, long expire) {
        rxSharedPreferences.getObject(key, null, new GsonPreferenceAdapter<>(clazz)).set(value);
        saveExpiredTime(key, expire);
    }

    @Override
    public <T> void set(String key, T value, TypeToken<T> typeToken, long expire) {
        rxSharedPreferences.getObject(key, null, new GsonPreferenceAdapter<>(typeToken.getType())).set(value);
        saveExpiredTime(key, expire);
    }

    @Override
    public boolean containKey(String key) {
        return sharedPreferences.contains(key);
    }

    @Override
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public <T> T get(String key, TypeToken<T> typeToken) {
        if (!isExpired(key)) {
            return rxSharedPreferences.getObject(key, null, new GsonPreferenceAdapter<T>(typeToken.getType())).get();
        }
        return null;
    }

    private boolean isExpired(String key) {
        key = key + "_expired";
        long expiredTime = rxSharedPreferences.getLong(key).get();
        if (expiredTime == 0l) {
            return false;
        }
        long time = System.currentTimeMillis();
        return time > expiredTime;
    }

    private void saveExpiredTime(String key, long expire) {
        if (expire > 0) {
            key = key + "_expired";
            long time = System.currentTimeMillis() + expire;
            rxSharedPreferences.getLong(key).set(time);
        }
    }
}
