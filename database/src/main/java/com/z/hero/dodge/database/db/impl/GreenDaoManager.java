package com.z.hero.dodge.database.db.impl;


import com.z.hero.dodge.database.db.IDaoEntity;
import com.z.hero.dodge.database.db.IDatabaseManager;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;

import java.util.List;

/**
 * GreenDao 数据库管理 实现类
 * Created by LinZheng on 2016/10/12.
 */
public class GreenDaoManager implements IDatabaseManager {

    private AbstractDaoSession mDaoSession;

    public GreenDaoManager(AbstractDaoSession daoSession) {
        mDaoSession = daoSession;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractDao> T getDao(Class<? extends IDaoEntity> entityClass) {
        AbstractDao<?, ?> dao = mDaoSession.getDao(entityClass);
        if (dao == null) {
            throw new IllegalStateException("找不到" + entityClass.getName() + "对应的Dao");
        }
        return (T) dao;
    }

    /**
     * 获取表的记录条数
     *
     * @param <T> 泛型
     * @return 记录数量
     */
    @Override
    public <T extends IDaoEntity> long count(Class<T> tClass) {
        AbstractDao<T, ?> dao = getDao(tClass);
        return dao.count();
    }

    /**
     * 删除数据(同步)
     *
     * @param entity 实体
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void delete(T entity) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.delete(entity);
    }


    /**
     * 删除(同步)
     *
     * @param entities 数据集合
     * @param tClass   实体类型
     * @param <T>      泛型
     */
    @Override
    public <T extends IDaoEntity> void delete(Iterable<T> entities, Class<T> tClass) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.deleteInTx(entities);
    }


    /**
     * 保存数据(同步)
     *
     * @param entity 实体
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void insert(T entity) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.insert(entity);
    }


    /**
     * 保存数据(同步)
     *
     * @param entities 数据集合
     * @param tClass   数据类型
     * @param <T>      泛型
     */
    @Override
    public <T extends IDaoEntity> void insert(Iterable<T> entities, Class<T> tClass) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.insertInTx(entities);
    }


    @Override
    public <T extends IDaoEntity> void update(T entity) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.insertOrReplace(entity);
    }


    /**
     * 加载所以列表(同步)
     *
     * @param tClass 实体类型
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> List<T> loadAll(Class<T> tClass) {
        AbstractDao<T, ?> dao = getDao(tClass);
        return dao.loadAll();
    }


    /**
     * 加载数据列表(同步)
     *
     * @param tClass 实体类型
     * @param size   集合大小
     * @param <T>    泛型
     * @return 数据集合
     */
    @Override
    public <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size) {
        return loadList(tClass, size, 0);
    }

    @Override
    public <T extends IDaoEntity> List<T> loadList(Class<T> tClass, String where, String... arg) {
        AbstractDao<T, ?> dao = getDao(tClass);
        return dao.queryRaw(where, arg);
    }

    /**
     * 加载数据列表(同步)
     *
     * @param tClass 实体类型
     * @param size   集合大小
     * @param offset 偏移量
     * @param <T>    泛型
     * @return 数据集合
     */
    @Override
    public <T extends IDaoEntity> List<T> loadList(Class<T> tClass, int size, int offset) {
        AbstractDao<T, ?> dao = getDao(tClass);
        return dao.queryBuilder()
                .offset(offset)
                .limit(size)
                .list();
    }


    /**
     * 执行SQL
     *
     * @param tClass 实体类型
     * @param sql    SQL
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void execSQL(Class<T> tClass, String sql) {
        getDao(tClass).getDatabase().execSQL(sql);
    }


}
