package com.yitao.notice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能类
 * @author 
 */
@Data
@TableName(value = "t_user_notice")
public class NoticeInfoEntity implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 描述信息
     */
    @TableField(value = "notice_info")
    private String noticeInfo;

    /**
     * 链接地址
     */
    @TableField(value = "open_url")
    private String openUrl;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;
    /**
     * 类型 0是系统功能描述 1是用户过期提醒
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 登录小号的名称   系统级消息用户名为null
     */
    @TableField(value = "unick")
    private String unick;


}