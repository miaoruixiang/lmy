package com.niit.lmy.service;

import com.niit.lmy.entity.*;
import com.niit.lmy.utils.ResponseMessage;

import java.util.List;

public interface CourseService {
    /**
     * 获得用户所有班课
     * @param account
     * @return
     */
    ResponseMessage getCourses(String account);

    /**
     * 创建班课
     * @param course
     * @return
     */
    ResponseMessage newCourse(Course course);

    /**
     * 修改班课信息
     * @param course
     * @return
     */
    ResponseMessage updateCourse(Course course);

    /**
     * 修改班课logo
     * @param course
     * @return
     */
    ResponseMessage updateCourseLogo(Course course);

    /**
     * 结束班课
     * @param courseId
     * @return
     */
    ResponseMessage finishCourse(int courseId);

    /**
     * 删除班课
     * @param courseId
     * @return
     */
    ResponseMessage deleteCourse(int courseId);

    /**
     * 获取角色权限
     * @param roleId
     * @return
     */
    ResponseMessage getPermission(int roleId);

    /**
     * 获取班课成员
     * @param courseId
     * @return
     */
    ResponseMessage getUsers(int courseId);

    /**
     *加入班课
     * @param userAccount
     * @return
     */
    ResponseMessage addUser(String userAccount,String courseInviteId);

    /**
     * 移除班课成员
     * @param userAccount
     * @param courseId
     * @return
     */
    ResponseMessage removeUser(String userAccount,int courseId);

    /**
     * 设置为助教
     * @param userAccount
     * @param courseId
     * @return
     */
    ResponseMessage setRole(String userAccount,int courseId);

    /**
     * 解除助教角色
     * @param userAccount
     * @param courseId
     * @return
     */
    ResponseMessage deleteRole(String userAccount,int courseId);

    /**
     * 获取班课的分组
     * @param courseId
     * @return
     */
    ResponseMessage getGroup(int courseId);

    /**
     * 新建班课的分组
     * @param group
     * @return
     */
    ResponseMessage newGroup(Group group);

    /**
     * 删除班课的分组
     * @param groupId
     * @return
     */
    ResponseMessage deleteGroup(int groupId);

    /**
     * 修改班课的分组
     * @param group
     * @return
     */
    ResponseMessage updateGroup(Group group);

    /**
     * 获取班课里的活动
     * @param courseId
     * @return
     */
    ResponseMessage getActivity(int courseId);

    /**
     * 新建班课活动
     * @param activity
     * @return
     */
    ResponseMessage newActivity(Activity activity);

    /**
     * 修改班课活动信息
     * @param activity
     * @return
     */
    ResponseMessage updateActivity(Activity activity);

    /**
     * 修改班课活动状态
     * @param activity
     * @return
     */
    ResponseMessage updateActivityStatus(Activity activity);

    /**
     * 删除班课活动
     * @param activityId
     * @return
     */
    ResponseMessage deleteActivity(int activityId);

    /**
     * 获取活动id
     * @return
     */
    int getActivityId();

    /**
     * 新建班课活动的资源
     * @param activityResources
     * @return
     */
    ResponseMessage newActivityResources(ActivityResources activityResources);

    /**
     * 获取提交的头脑风暴
     * @param activityId
     * @return
     */
    ResponseMessage getStormingRefer(int activityId);

    /**
     * 获取用户已提交的头脑风暴
     * @param account
     * @return
     */
    ResponseMessage getStormRefer(int activityId,String account);

    /**
     * 提交头脑风暴
     * @param stormingRefer
     * @return
     */
    ResponseMessage referStorm(ActivityBrainStormingRefer stormingRefer);

    /**
     * 修改提交的头脑风暴
     * @param stormingRefer
     * @return
     */
    ResponseMessage updateStorm(ActivityBrainStormingRefer stormingRefer);

    /**
     * 获取提交的作业
     * @param activityId
     * @return
     */
    ResponseMessage getWorkRefer(int activityId);

    /**
     * 获取用户已提交的作业
     * @param activityId
     * @param account
     * @return
     */
    ResponseMessage getUserWorkRefer(int activityId,String account);

    /**
     * 提交作业
     * @param activityWorkRefer
     * @return
     */
    ResponseMessage referWork(ActivityWorkRefer activityWorkRefer);

    /**
     * 修改提交的作业
     * @param activityWorkRefer
     * @return
     */
    ResponseMessage updateWork(ActivityWorkRefer activityWorkRefer);

    /**
     * 获得提交作业id
     * @return
     */
    int getWorkReferId();

    /**
     * 新建提交的作业资源
     * @param workReferResources
     * @return
     */
    ResponseMessage newWorkReferResource(ActivityWorkReferResources workReferResources);

    /**
     * 获得提交作业资源的id
     * @return
     */
    List<Integer> getWorkReferResourceId(int workReferId);

    /**
     * 删除提交的作业资源
     * @param workReferResourceId
     * @return
     */
    ResponseMessage deleteWorkReferResource(int workReferResourceId);

    /**
     * 获取班课里面的消息
     * @param courseId
     * @return
     */
    ResponseMessage getNotice(int courseId);

    /**
     * 新建一条消息
     * @param notice
     * @return
     */
    ResponseMessage newNotice(Notice notice);

    /**
     * 删除一条消息
     * @param noticeId
     * @return
     */
    ResponseMessage deleteNotice(int noticeId);

    /**
     * 获取班课里的资源
     * @param courseId
     * @return
     */
    ResponseMessage getResource(int courseId);

    /**
     * 发布资源
     * @param resource
     * @return
     */
    ResponseMessage newResource(Resource resource);

    /**
     * 修改资源信息
     * @param resource
     * @return
     */
    ResponseMessage updateResource(Resource resource);

    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    ResponseMessage deleteResource(int resourceId);

    /**
     * 查看资源查看情况
     * @param resourceId
     * @return
     */
    ResponseMessage getResourceCheck(int resourceId);

    /**
     * 查看资源
     * @param userAccount
     * @param resourceId
     * @return
     */
    ResponseMessage checkResource(String userAccount,int resourceId);
}
