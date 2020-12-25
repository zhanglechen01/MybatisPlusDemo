package com.yitao.notice.dao.source1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yitao.notice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserOpenNoticeMapper extends BaseMapper<User> {
    int insert(String unick);
    Date getOpenTimeByName(String unick);
}