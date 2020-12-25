package com.yitao.notice.dao.source1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yitao.notice.entity.NoticeInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface NoticeManageMapper extends BaseMapper<NoticeInfoEntity> {
    int insertNotice(NoticeInfoEntity nie);

	/**
	 * 查询所有的通知
     * @return
	 */
    IPage<NoticeInfoEntity> selectSystemNoticeAll(Page page, @Param("unick") String unick);
    //查询最后的消息创建时间
    Date getMaxSystemTime(@Param("unick") String unick);
}