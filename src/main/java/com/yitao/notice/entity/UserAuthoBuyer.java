package com.yitao.notice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yitao.utils.bean.BaseEntity;
import lombok.Data;

/**
 * t_user_authorizetobuyer
 */
@Data
@TableName("t_user_authorizetobuyer")
public class UserAuthoBuyer extends BaseEntity {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    /**
     * 店铺旺旺
     */
    @TableField(value = "nick")
    private String nick;

    /**
     * 授权小号
     */
    @TableField(value = "to_nick")
    private String toNick;

    /**
     * 授权时间
     */
    @TableField(value = "autho_time")
    private String authoTime;

    /**
     * 密码
     */
    @TableField(value = "passWord")
    private String passWord;

    /**
     * 二级密码
     */
    @TableField(value = "sec_pw")
    private String secPw;

}