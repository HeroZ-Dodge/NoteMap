package com.dodge.hero.notemap.data;

import android.content.Context;

import com.dodge.hero.notemap.dao.DaoMaster;
import com.dodge.hero.notemap.dao.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

import java.util.List;

import javax.inject.Inject;


/**
 * 数据库 管理工具
 * Created by LinZheng on 2016/10/12.
 */
public class DataBaseManager {

    public static final boolean ENCRYPTED = false;
    public static final String DATA_BASE_NAME = "ai_pai_db";
    public static final String DATA_BASE_NAME_ENCRYPTED = "ai_pai_db_encrypted";
    public static final String DATA_BASE_PASSWORD = "super-secret";

    private DaoSession mDaoSession;


    @Inject
    public DataBaseManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, ENCRYPTED ? DATA_BASE_NAME_ENCRYPTED : DATA_BASE_NAME);
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb(DATA_BASE_PASSWORD) : helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }


    public  <T extends AbstractDao> T getDao(Class<? extends Object> entityClass) {
        AbstractDao<?, ?> dao = mDaoSession.getDao(entityClass);
        return (T) dao;
    }

    public <T, K> void delete(T entity) {
        AbstractDao<T, K> dao = getDao(entity.getClass());
        dao.delete(entity);
    }

    public <T, K> void delete(Iterable<T> entities, Class<T> tClass) {
        AbstractDao<T, K> dao = getDao(tClass);
        dao.deleteInTx(entities);
    }

    public <T, K> void insert(T entity) {
        AbstractDao<T, K> dao = getDao(entity.getClass());
        dao.insert(entity);
    }

    public <T, K> void insert(Iterable<T> entities, Class<T> tClass) {
        AbstractDao<T, K> dao = getDao(tClass);
        dao.insertInTx(entities);
    }

    public <T> List<T> loadList(Class<T> tClass, int size) {
        return loadList(tClass, size, 0);
    }

    public <T, K> List<T> loadList(Class<T> tClass, int size, int offset) {
        AbstractDao<T, K> dao = getDao(tClass);
        return dao.queryBuilder()
                .offset(offset)
                .limit(size)
                .list();
    }

}
