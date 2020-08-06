package com.czq.ssm.mapper;


import com.czq.ssm.model.TUserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@Component
public class TUserManagerImpl implements TUserManager {
    //从spring中获取自动创建的实例
    @Autowired
    protected TUserMapper tUserMapper;


    public int insertSelective(TUserDo record) {
        return tUserMapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(TUserDo record) {
        return tUserMapper.deleteByPrimaryKey(record);
    }

    public TUserDo selectByPrimaryKey(Long id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TUserDo record) {
        return tUserMapper.updateByPrimaryKeySelective(record);
    }
}
