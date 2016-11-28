package com.z.hero.dodge.database.cache.impl;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences.Preference;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by moo on 16/4/16.
 */
public class GsonPreferenceAdapter<T> implements Preference.Adapter<T> {

    final Gson gson;
    private Class<T> clazz;
    private Type type;

    public GsonPreferenceAdapter(Class<T> clazz) {
        this(null, clazz);
    }

    public GsonPreferenceAdapter(Gson gson, Class<T> clazz) {
        if (gson == null) {
            gson = new Gson();
        }
        this.gson = gson;
        this.clazz = clazz;
    }

    public GsonPreferenceAdapter(Type type) {
        this(null, type);
    }

    public GsonPreferenceAdapter(Gson gson, Type type) {
        if (gson == null) {
            gson = new Gson();
        }
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T get(@NonNull String key, @NonNull SharedPreferences preferences) {
        if (clazz != null) {
            return gson.fromJson(preferences.getString(key, null), clazz);
        } else if (type != null) {
            return gson.fromJson(preferences.getString(key, null), type);
        }
        return null;
    }

    @Override
    public void set(@NonNull String key, @NonNull T value, @NonNull SharedPreferences.Editor editor) {
        editor.putString(key, gson.toJson(value));
    }
}
