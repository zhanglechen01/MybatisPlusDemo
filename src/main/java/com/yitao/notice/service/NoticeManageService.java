package com.yitao.notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yitao.notice.constant.ServerRetResponse;
import com.yitao.notice.dao.source1.NoticeManageMapper;
import com.yitao.notice.dao.source1.UserOpenNoticeMapper;
import com.yitao.notice.entity.NoticeInfoEntity;
import com.yitao.notice.entity.PageRes;
import com.yitao.utils.bean.MessageBody;
import com.yitao.utils.enums.retcode.EnumSystemRetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeManageService {

	private final Logger logger = LoggerFactory.getLogger(NoticeManageService.class);

    @Autowired
    private NoticeManageMapper noticeManageMapper;
	@Autowired
	private UserOpenNoticeMapper userOpenNoticeMapper;



	/**
	 * 保存用户最后打开通知时间
	 * @param unick
	 * @return
	 */
	public MessageBody saveOpenNoticeTime(String unick){
		if(unick == null || "".equals(unick.trim())){
			//用户名不能为空
			return new MessageBody(EnumSystemRetCode.NOTICE_USER_NULL);
		}
		//保存
		userOpenNoticeMapper.insert(unick);
		return new MessageBody(EnumSystemRetCode.NOTICE_ADD_SUCCESS);
	}

	/**
	 * 查询是否显示消息通知铃铛上的小红点
	 * @param unick
	 * @return
	 */
	public MessageBody<Boolean> getNoticeRedDot(String unick){
		if(unick == null || "".equals(unick.trim())){
			return new MessageBody(EnumSystemRetCode.NOTICE_USER_NULL);
		}
		//查询用户最后打开通知的时间
		Date openTime = userOpenNoticeMapper.getOpenTimeByName(unick);
		//查询用户对应消息的最后创建时间
		Date maxSystemTime = noticeManageMapper.getMaxSystemTime(unick);
		//msg设为 0:表示不显示，1：表示显示
		if(maxSystemTime ==null){
			//只要系统没有消息，不显示，目前消息表只有系统消息
			return new MessageBody(EnumSystemRetCode.NOTICE_UNSHOW,false);
		}
		if(openTime == null){
			return new MessageBody(EnumSystemRetCode.NOTICE_SHOW,true);
		}
		if(openTime.before(maxSystemTime)){
			return new MessageBody(EnumSystemRetCode.NOTICE_SHOW,true);
		}else{
			return new MessageBody(EnumSystemRetCode.NOTICE_UNSHOW,false);
		}
	}
	/**
	 * 分页查询用户的通知信息
	 * @param unick   用户旺旺名，保留字段，为以后拓展查询用户级别使用
	 * @param pageNo  当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	public MessageBody<IPage<NoticeInfoEntity>> getUserNotices(String unick, Integer pageNo, Integer pageSize){
		//当前页面没传值默认是第一页
		if(pageNo == null || pageNo <= 0){
			pageNo = 1;
		}
		//每页显示没传值，默认20条
		if(pageSize == null || pageSize <= 0){
			pageSize = 20;
		}
		//保存
		Page<NoticeInfoEntity> page = new Page(pageNo,pageSize);
		IPage<NoticeInfoEntity> nieList = noticeManageMapper.selectSystemNoticeAll(page,unick);
		return new MessageBody(EnumSystemRetCode.NOTICE_SELECT_SUCCESS,nieList);

	}


}
