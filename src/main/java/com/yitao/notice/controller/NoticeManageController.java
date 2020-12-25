package com.yitao.notice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yitao.notice.constant.ServerRetResponse;
import com.yitao.notice.entity.NoticeInfoEntity;
import com.yitao.notice.entity.PageRes;
import com.yitao.notice.service.NoticeManageService;
import com.yitao.utils.bean.BaseController;
import com.yitao.utils.bean.MessageBody;
import com.yitao.utils.bean.session.UserSession;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 消息管理模块
 */
@Api(tags = "消息管理模块")
@RestController
@RequestMapping(value = "/noticeManage")
public class NoticeManageController extends BaseController {

    @Autowired
    private NoticeManageService noticeManageService;



    /**
     * 保存每个用户打开通知铃铛的时间
     */
    @PostMapping("/saveOpenNoticeTime")
    @ApiOperation(value = "保存每个用户打开通知铃铛的时间", notes = "")
    public MessageBody saveOpenNoticeTime(){
        UserSession userSession = getUserSession();
        return noticeManageService.saveOpenNoticeTime(userSession.getLoginName());
    }

	/**
     * 查询是否显示消息通知铃铛上的小红点
     */
    @GetMapping("/getNoticeRedDot")
    @ApiOperation(value = "查询是否显示消息通知铃铛上的小红点", notes = "")
    public MessageBody getNoticeRedDot(){
        UserSession userSession = getUserSession();
        return noticeManageService.getNoticeRedDot(userSession.getLoginName());
    }


    /**
     * 查询用户的消息数据
     * @param pageNo 当前的页数
     * @param pageSize 每页显示的条数
     * @return
     */
    @GetMapping("/getUserNotices")
    @ApiOperation(value = "查询用户的消息数据", notes = "")
    public MessageBody<IPage<NoticeInfoEntity>> getUserNotices(Integer pageNo, Integer pageSize){
        UserSession userSession = getUserSession();
        return noticeManageService.getUserNotices("马连强2020",pageNo,pageSize);
    }

}













