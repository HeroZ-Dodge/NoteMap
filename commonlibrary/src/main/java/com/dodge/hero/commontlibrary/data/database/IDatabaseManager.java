package com.dodge.hero.commontlibrary.data.database;

import com.dodge.hero.commontlibrary.clean.callback.AsyncCallBack;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * 数据管理工具 接口
 * 有 AsyncCallBack      异步执行
 * 没有 AsyncCallBack     同步执行
 * Created by LinZheng on 2016/10/12.
 */
public interface IDatabaseManager {


    @SuppressWarnings("unchecked")
    <T extends AbstractDao> T getDao(Class<? extends IDaoEntity> entityClass);

    <T extends IDaoEntity> long count(Class<T> tClass);

    <T extends IDaoEntity> void delete(T entity);

    <T extends IDaoEntity> void delete(T entity, AsyncCallBack<Void> asyncCallBack);

    <T extends IDaoEntity> void delete(Iterable<T> entities, Class<T> tClass);

    <T extends IDaoEntity> void delete(Iterable<T> entities, Class<T> tClass, AsyncCallBack<Void> asyncCallBack);

    <T extends IDaoEntity> void deleteAll(Class<T> tClass, AsyncCallBack<Void> asyncCallBack);

    <T extends IDaoEntity> void insert(T entity);

    <T extends IDaoEntity> void insert(T entity, AsyncCallBack<T> asyncCallBack);

    <T extends IDaoEntity> void insert(Iterable<T> entities, Class<T> tClass);

    <T extends IDaoEntity> void insert(Iterable<T> entities, Class<T> tClass, AsyncCallBack<Iterable<T>> asyncCallBack);

    <T extends IDaoEntity> void update(T entity);

    <T extends IDaoEntity> void update(T entity, AsyncCallBack<T> asyncCallBack);

    <T extends IDaoEntity> List<T> loadAll(Class<T> tClass);

    <T extends IDaoEntity> void loadAll(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack);

    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size);

    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, String where, String... arg);

    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size, int offset);

    <T extends IDaoEntity> void loadList(Class<T> tClass, int size, AsyncCallBack<List<T>> asyncCallBack);

    <T extends IDaoEntity> void loadList(Class<T> tClass, int size, int offset, AsyncCallBack<List<T>> asyncCallBack);

    <T extends IDaoEntity> void loadList(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack, String where, Object... selectionArg);

    <T extends IDaoEntity> void loadList(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack, String where, String... selectionArg);

    <T extends IDaoEntity> void execSQL(Class<T> tClass, String sql);

    <T extends IDaoEntity> void loadList(Class<T> tClass, WhereCondition whereCondition, int size, int offset, AsyncCallBack<List<T>> asyncCallBack);

}
