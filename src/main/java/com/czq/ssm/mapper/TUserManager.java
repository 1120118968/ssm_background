package com.czq.ssm.mapper;

import com.czq.ssm.model.TUserDo;

public interface TUserManager {
    /**
     * insert selective.
     */
    int insertSelective(TUserDo record);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(TUserDo record);

    /**
     * select by primary key.
     */
    TUserDo selectByPrimaryKey(Long id);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(TUserDo record);
}
