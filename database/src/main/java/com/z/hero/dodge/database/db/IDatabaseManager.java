package com.z.hero.dodge.database.db;


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


    <T extends IDaoEntity> void delete(Iterable<T> entities, Class<T> tClass);


    <T extends IDaoEntity> void insert(T entity);


    <T extends IDaoEntity> void insert(Iterable<T> entities, Class<T> tClass);


    <T extends IDaoEntity> void update(T entity);


    <T extends IDaoEntity> List<T> loadAll(Class<T> tClass);


    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size);

    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, String where, String... arg);

    <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size, int offset);



    <T extends IDaoEntity> void execSQL(Class<T> tClass, String sql);


}
