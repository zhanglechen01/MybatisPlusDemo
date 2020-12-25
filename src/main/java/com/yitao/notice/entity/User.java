package com.yitao.notice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yitao.utils.bean.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * user
 * @author 
 */
@Data
@TableName("t_user ")
public class User extends BaseEntity {
    /**
     * 旺旺
     */
    @TableField(value = "uNick")
    private String uNick;

    /**
     * 订购等级
     */
    private String uLevel;

    /**
     * 到期时间
     */
    @TableField(value = "uExpireDate")
    private String uExpireDate;

    /**
     * 到期时间
     */
    private Date uLastBuyDate;

    /**
     * 上次复制用的类目
     */
    private String uLastCopyCat;

    private String uLastSellerCat;

    private String uLastpostfee;

    @TableField(value = "SessionKey")
    private String sessionKey;


    /**
     * 到期时间
     */
    @TableField(value = "SessionDate")
    private Date sessionDate;

    private String code;

}