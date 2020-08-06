package com.czq.ssm.mapper;


import com.czq.ssm.model.TUserDo;
import org.springframework.stereotype.Repository;

//spring的注解，会自动创建类的实例
@Repository
public interface TUserMapper {
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

