package com.dodge.hero.commontlibrary.data.database.impl;

import com.dodge.hero.commontlibrary.clean.callback.AsyncCallBack;
import com.dodge.hero.commontlibrary.clean.callback.RxCallBackSubscribe;
import com.dodge.hero.commontlibrary.data.database.IDaoEntity;
import com.dodge.hero.commontlibrary.data.database.IDatabaseManager;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

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
    private <T extends AbstractDao> T getDao(Class<? extends IDaoEntity> entityClass) {
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
     * 删除数据(异步)
     *
     * @param entity 实体
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void delete(T entity, AsyncCallBack<Void> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.rx().delete(entity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
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
     * 删除(异步)
     *
     * @param entities      数据集合
     * @param tClass        实体类型
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void delete(Iterable<T> entities, Class<T> tClass, AsyncCallBack<Void> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.rx().deleteInTx(entities)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }

    /**
     * 删除所以(异步)
     *
     * @param tClass        实体类型
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void deleteAll(Class<T> tClass, AsyncCallBack<Void> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.rx().deleteAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }

    /**
     * 保存数据(同步)
     *
     * @param entity 实体
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void save(T entity) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.save(entity);
    }

    /**
     * 保存数据(异步)
     *
     * @param entity        实体
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void save(T entity, AsyncCallBack<T> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(entity.getClass());
        dao.rx().save(entity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }

    /**
     * 保存数据(同步)
     *
     * @param entities 数据集合
     * @param tClass   数据类型
     * @param <T>      泛型
     */
    @Override
    public <T extends IDaoEntity> void save(Iterable<T> entities, Class<T> tClass) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.saveInTx(entities);
    }

    /**
     * 保存数据(异步)
     *
     * @param entities      数据集合
     * @param tClass        实体类型
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void save(Iterable<T> entities, Class<T> tClass, AsyncCallBack<Iterable<T>> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.rx().saveInTx(entities)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
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
     * 加载所以列表(异步)
     *
     * @param tClass 实体类型
     * @param <T>    泛型
     */
    @Override
    public <T extends IDaoEntity> void loadAll(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.rx().loadAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
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
     * 加载数据列表(异步)
     *
     * @param tClass        实体类型
     * @param size          集合大小
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void loadList(Class<T> tClass, int size, AsyncCallBack<List<T>> asyncCallBack) {
        loadList(tClass, size, 0, asyncCallBack);
    }

    /**
     * 加载数据列表(异步)
     *
     * @param tClass        实体类型
     * @param size          集合大小
     * @param offset        偏移量
     * @param asyncCallBack 回调
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void loadList(Class<T> tClass, int size, int offset, AsyncCallBack<List<T>> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.queryBuilder()
                .offset(offset)
                .limit(size)
                .rx()
                .list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }

    /**
     * 查询数据(异步)
     *
     * @param tClass        实体类型
     * @param asyncCallBack 回调
     * @param where         查询条件
     * @param selectionArg  查询参数
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void loadList(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack, String where, Object... selectionArg) {
        AbstractDao<T, ?> dao = getDao(tClass);
        List<T> list = dao.queryRawCreate(where, selectionArg)
                .forCurrentThread()
                .list();
        Observable<List<T>> observable = Observable.just(list);
        observable.subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }

    /**
     * 查询数据(异步)
     *
     * @param tClass        实体类型
     * @param asyncCallBack 回调
     * @param where         查询条件
     * @param selectionArg  查询参数
     * @param <T>           泛型
     */
    @Override
    public <T extends IDaoEntity> void loadList(Class<T> tClass, AsyncCallBack<List<T>> asyncCallBack, String where, String... selectionArg) {
        AbstractDao<T, ?> dao = getDao(tClass);
        List<T> list = dao.queryRaw(where, selectionArg);
        Observable<List<T>> observable = Observable.just(list);
        observable.subscribe(new RxCallBackSubscribe<>(asyncCallBack));
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

    @Override
    public <T extends IDaoEntity> void loadList(Class<T> tClass, WhereCondition whereCondition, int size, int offset, AsyncCallBack<List<T>> asyncCallBack) {
        AbstractDao<T, ?> dao = getDao(tClass);
        dao.queryBuilder()
                .where(whereCondition)
                .offset(offset)
                .limit(size)
                .rx()
                .list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallBackSubscribe<>(asyncCallBack));
    }


}
