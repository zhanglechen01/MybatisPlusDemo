package com.yitao.notice.dao.source1;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yitao.notice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper extends BaseMapper<User>{
}