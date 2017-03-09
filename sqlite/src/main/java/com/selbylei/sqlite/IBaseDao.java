package com.selbylei.sqlite;

/**
 * Created by selbylei on 17/3/8.
 * 数据库
 */

public interface IBaseDao<T> {

    Long insert(T t);

    Long update(T t);

}
