package com.niit.lmy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author miao
 * @since 2018-06-03
 */
@TableName("t_notice")
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;
    /**
     * 班课id
     */
    @TableField("course_id")
    private Integer courseId;
    /**
     * 创建人帐号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 消息内容
     */
    @TableField("notice_info")
    private String noticeInfo;
    /**
     * 发布时间
     */
    @TableField("notice_create_time")
    private Date noticeCreateTime;


    public Integer getNoticeId() {
        return noticeId;
    }

    public Notice setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Notice setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public Notice setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public String getNoticeInfo() {
        return noticeInfo;
    }

    public Notice setNoticeInfo(String noticeInfo) {
        this.noticeInfo = noticeInfo;
        return this;
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public Notice setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
        return this;
    }

    public static final String NOTICE_ID = "notice_id";

    public static final String COURSE_ID = "course_id";

    public static final String USER_ACCOUNT = "user_account";

    public static final String NOTICE_INFO = "notice_info";

    public static final String NOTICE_CREATE_TIME = "notice_create_time";

    @Override
    protected Serializable pkVal() {
        return this.noticeId;
    }

    @Override
    public String toString() {
        return "Notice{" +
        ", noticeId=" + noticeId +
        ", courseId=" + courseId +
        ", userAccount=" + userAccount +
        ", noticeInfo=" + noticeInfo +
        ", noticeCreateTime=" + noticeCreateTime +
        "}";
    }
}
