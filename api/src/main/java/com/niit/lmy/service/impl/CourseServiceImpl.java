package com.niit.lmy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.niit.lmy.entity.*;
import com.niit.lmy.mapper.*;
import com.niit.lmy.service.CourseService;
import com.niit.lmy.utils.ConstConfig;
import com.niit.lmy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service //标志为一个Service组件
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityBrainStormingReferMapper activityBrainStormingReferMapper;
    @Autowired
    private ActivityWorkReferMapper activityWorkReferMapper;
    @Autowired
    private ActivityWorkReferResourcesMapper activityWorkReferResourcesMapper;
    @Autowired
    private ActivityResourcesMapper activityResourcesMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private UserCourseMapper userCourseMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private UserResourceCheckMapper userResourceCheckMapper;

    @Override
    public ResponseMessage getCourses(String account) {
        ResponseMessage responseMessage = null;
        JSONArray jsonArray = new JSONArray();
        List<Course> list = courseMapper.getCourses(account);
        if (list.size() != 0){
            for (int i = 0;i < list.size();i ++){
               List<Role> roles = roleMapper.getRole(account,list.get(i).getCourseId());
               UserInfo userInfo = userInfoMapper.selectList(
                       new EntityWrapper<UserInfo>().eq("user_account",list.get(i).getCreateUserAccount())
               ).get(0);
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("course",list.get(i));
               jsonObject.put("createUser",userInfo);
               jsonObject.put("role",roles);
               jsonArray.add(jsonObject);
            }
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,jsonArray);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage newCourse(Course course) {
        ResponseMessage responseMessage = null;
        ResponseMessage res = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);;
         UserInfo userInfo = userInfoMapper.selectList(
                 new EntityWrapper<UserInfo>().eq("user_account",course.getCreateUserAccount())
         ).get(0);
        course.setCourseSchool(userInfo.getUserSchool());
        course.setCourseDepartment(userInfo.getUserDepartment());

        int n = courseMapper.insert(course);
        if (n != 0){
            int courseId = courseMapper.getCourseId();
            String account = course.getCreateUserAccount();

            UserCourse userCourse = new UserCourse();
            userCourse.setUserAccount(account);
            userCourse.setCourseId(courseId);
            userCourse.setUserNickname(userInfo.getUserName());
            userCourse.setUserNumber(userInfo.getUserNumber());

            UserRole userRole = new UserRole();
            userRole.setUserAccount(account);
            userRole.setRoleId(1);
            userRole.setCourseId(courseId);

            int a = userCourseMapper.insert(userCourse);
            int b = userRoleMapper.insert(userRole);
            int c = 0;

            String[] groupName = new String[]{"00.全课", "01.第一单元","02.第二单元","03.第三单元"};
            for (int j = 0;j < groupName.length;j ++){
                Group group = new Group();
                group.setCourseId(courseId);
                group.setGroupName(groupName[j]);
                c = groupMapper.insert(group);
            }

            int m =0;
            if (a != 0 && b != 0 && c != 0){
                Date date = new Date();
                userInfo.setUserCreateCourse(userInfo.getUserCreateCourse()+1);
                userInfo.setUserUpdateTime(date);
                m = userInfoMapper.updateById(userInfo);
            }

            if (m != 0){
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,null);
            }else {
                responseMessage = res;
            }
        }else {
            responseMessage = res;
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateCourse(Course course) {
        ResponseMessage responseMessage = null;
        int n = courseMapper.updateById(course);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateCourseLogo(Course course) {
        ResponseMessage responseMessage = null;
        int n = courseMapper.updateById(course);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage finishCourse(int courseId) {
        ResponseMessage responseMessage = null;
        Course course = courseMapper.selectById(courseId);
        course.setCourseStatus(1);
        int n = courseMapper.updateById(course);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage deleteCourse(int courseId) {
        ResponseMessage responseMessage = null;
        ResponseMessage res = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);;

        Course course = courseMapper.selectById(courseId);
        int n = courseMapper.deleteById(courseId);

        if (n != 0){
            int a = userCourseMapper.delete(
                    new EntityWrapper<UserCourse>().eq("course_id",courseId)
            );

            int b = userRoleMapper.delete(
                    new EntityWrapper<UserRole>().eq("course_id",courseId)
            );

            int c = groupMapper.delete(
                    new EntityWrapper<Group>().eq("course_id",courseId)
            );

            if (a != 0 && b != 0 && c != 0){
                String account = course.getCreateUserAccount();
                UserInfo userInfo = userInfoMapper.selectList(
                        new EntityWrapper<UserInfo>().eq("user_account",account)
                ).get(0);
                userInfo.setUserCreateCourse(userInfo.getUserCreateCourse()-1);

                int m = userInfoMapper.updateById(userInfo);
                if (m != 0){
                    responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
                }else {
                    responseMessage = res;
                }
            }
        }else {
            responseMessage = res;
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getPermission(int roleId) {
        ResponseMessage responseMessage = null;
        List<Permission> list = permissionMapper.getPermission(roleId);
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getUsers(int courseId) {
        ResponseMessage responseMessage = null;
        JSONArray jsonArray = new JSONArray();
        List<UserCourse> list = userCourseMapper.selectList(
                new EntityWrapper<UserCourse>().eq("course_id",courseId)
        );
        if (list.size() != 0){
            for (int i = 0;i < list.size();i ++){
                List<Role> role = roleMapper.getRole(list.get(i).getUserAccount(),courseId);
                UserInfo userInfo = userInfoMapper.selectList(
                        new EntityWrapper<UserInfo>().eq("user_account",list.get(i).getUserAccount())
                ).get(0);
                List<Resource> resources = resourceMapper.getResource(courseId);
                List<Activity> activities = activityMapper.getActivity(courseId);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("role",role);
                jsonObject.put("user",list.get(i));
                jsonObject.put("resourceNumber",resources.size());
                jsonObject.put("activityNumber",activities.size());
                jsonArray.add(jsonObject);
            }
        }
        responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,jsonArray);

        return responseMessage;
    }

    @Override
    public ResponseMessage addUser(String userAccount, String courseInviteId) {
        ResponseMessage responseMessage = null;
        Course course = courseMapper.selectList(
                new EntityWrapper<Course>().eq("course_invite_id",courseInviteId)
        ).get(0);
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",userAccount)
        ).get(0);
        List<UserCourse> list = userCourseMapper.selectList(
                new EntityWrapper<UserCourse>().eq("user_account",userAccount)
                                                .eq("course_id",course.getCourseId())
        );

        if (list.size() == 0){
            UserCourse userCourse = new UserCourse();
            userCourse.setUserAccount(userAccount);
            userCourse.setCourseId(course.getCourseId());
            userCourse.setUserNickname(userInfo.getUserName());
            userCourse.setUserNumber(userInfo.getUserNumber());
            UserRole userRole = new UserRole();
            userRole.setUserAccount(userAccount);
            userRole.setCourseId(course.getCourseId());
            userRole.setRoleId(3);

            int n = userCourseMapper.insert(userCourse);
            int m = userRoleMapper.insert(userRole);
            if (n != 0 && m != 0){
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.COURSE_JOIN_OK,null);
            }else {
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.COURSE_JOIN_ERROR,null);
            }
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.COURSE_JOIN,null);
        }


        return responseMessage;
    }

    @Override
    public ResponseMessage removeUser(String userAccount, int courseId) {
        ResponseMessage responseMessage = null;
        int n = userCourseMapper.delete(
                new EntityWrapper<UserCourse>().eq("user_account",userAccount)
                                               .eq("course_id",courseId)
        );
        int m = userRoleMapper.delete(
                new EntityWrapper<UserRole>().eq("user_account",userAccount)
                                                .eq("course_id",courseId)
        );

        if (n != 0 && m != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage setRole(String userAccount, int courseId) {
        ResponseMessage responseMessage = null;
        UserRole userRole = new UserRole();
        userRole.setUserAccount(userAccount);
        userRole.setCourseId(courseId);
        userRole.setRoleId(2);

        int n = userRoleMapper.insert(userRole);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteRole(String userAccount, int courseId) {
        ResponseMessage responseMessage = null;
        int n = userRoleMapper.delete(
                new EntityWrapper<UserRole>().eq("user_account",userAccount)
                                             .eq("course_id",courseId)
                                             .eq("role_id",2)
        );

        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage getActivity(int courseId) {
        ResponseMessage responseMessage = null;
        JSONArray jsonArray = new JSONArray();
        List<Activity> activityList = activityMapper.getActivity(courseId);
        if (activityList.size()!=0){
            for (int i = 0;i < activityList.size();i ++){
                List<ActivityResources> activityResources = activityResourcesMapper.selectList(
                        new EntityWrapper<ActivityResources>().eq("activity_id",activityList.get(i).getActivityId())
                );
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("resources",activityResources);
                jsonObject.put("activity",activityList.get(i));
                jsonArray.add(jsonObject);
            }
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,jsonArray);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }
        return responseMessage;

    }

    @Override
    public ResponseMessage newActivity(Activity activity) {
        ResponseMessage responseMessage = null;
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",activity.getPublishUserAccount())
        ).get(0);
        Group group = groupMapper.selectById(activity.getActivityGroup());
        userInfo.setUserCreateActivity(userInfo.getUserCreateActivity()+1);
        group.setActivityNumber(group.getActivityNumber()+1);

        int a = activityMapper.insert(activity);
        int b = userInfoMapper.updateById(userInfo);
        int c = groupMapper.updateById(group);
        if (a != 0 && b != 0 && c != 0){
            Activity newActivity = activityMapper.selectById(activityMapper.getActivityId());
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,newActivity);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateActivity(Activity activity) {
        ResponseMessage responseMessage = null;
        int n = activityMapper.updateById(activity);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateActivityStatus(Activity activity) {
        ResponseMessage responseMessage = null;
        int n = activityMapper.updateById(activity);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage deleteActivity(int activityId) {
        ResponseMessage responseMessage = null;
        Activity activity = activityMapper.selectById(activityId);
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",activity.getPublishUserAccount())
        ).get(0);
        userInfo.setUserCreateActivity(userInfo.getUserCreateActivity()-1);

        int a = activityMapper.deleteById(activityId);
        int b = userInfoMapper.updateById(userInfo);
        int c = activityResourcesMapper.delete(
                new EntityWrapper<ActivityResources>().eq("activity_id",activityId)
        );

        if (activity.getActivityType() == 1){
            List<ActivityWorkRefer> workRefers = activityWorkReferMapper.selectList(
                    new EntityWrapper<ActivityWorkRefer>().eq("activity_id",activityId)
            );
            if (workRefers.size() != 0){
                ActivityWorkRefer workRefer = workRefers.get(0);
                int workReferId = workRefer.getWorkReferId();
                activityWorkReferMapper.deleteById(workReferId);
                activityWorkReferResourcesMapper.delete(
                        new EntityWrapper<ActivityWorkReferResources>().eq("work_refer_id",workReferId)
                );
            }
        }else {
            activityBrainStormingReferMapper.delete(
                    new EntityWrapper<ActivityBrainStormingRefer>().eq("activity_id",activityId)
            );
        }

        if (a != 0 && b != 0 && c != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public int getActivityId() {
        int id = activityMapper.getActivityId();
        return id;
    }

    @Override
    public ResponseMessage newActivityResources(ActivityResources activityResources) {
        ResponseMessage responseMessage = null;
        int n = activityResourcesMapper.insert(activityResources);
        if (n != 0){
            Activity activity = activityMapper.selectById(activityResources.getActivityId());
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,activity);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getStormingRefer(int activityId) {
        ResponseMessage responseMessage = null;
        List<ActivityBrainStormingRefer> list = activityBrainStormingReferMapper.selectList(
                new EntityWrapper<ActivityBrainStormingRefer>().eq("activity_id",activityId)
        );
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getStormRefer(int activityId,String account) {
        ResponseMessage responseMessage = null;
        List<ActivityBrainStormingRefer> list = activityBrainStormingReferMapper.selectList(
                new EntityWrapper<ActivityBrainStormingRefer>().eq("activity_id",activityId)
                        .eq("refer_user_account",account)
        );
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list.get(0));
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage referStorm(ActivityBrainStormingRefer stormingRefer) {
        ResponseMessage responseMessage = null;
        int id = stormingRefer.getActivityId();
        String account = stormingRefer.getReferUserAccount();
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",account)
        ).get(0);
        UserCourse userCourse = userCourseMapper.getUserCourse(id,account);
        Activity activity = activityMapper.selectById(id);
        int experience = activity.getActivityExperience();
        userInfo.setUserJoinActivity(userInfo.getUserJoinActivity()+1);
        userInfo.setUserExperience(userInfo.getUserExperience()+experience);
        userCourse.setUserExperience(userCourse.getUserExperience()+experience);
        userCourse.setUserActivityExperience(userCourse.getUserActivityExperience()+experience);

        int a = activityBrainStormingReferMapper.insert(stormingRefer);
        int b = userInfoMapper.updateById(userInfo);
        int c = userCourseMapper.updateById(userCourse);
        if (a != 0 && b != 0 && c != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,stormingRefer);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateStorm(ActivityBrainStormingRefer stormingRefer) {
        ResponseMessage responseMessage = null;
        int n = activityBrainStormingReferMapper.updateById(stormingRefer);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getWorkRefer(int activityId) {
        ResponseMessage responseMessage = null;
        JSONArray jsonArray = new JSONArray();
        List<ActivityWorkRefer> list = activityWorkReferMapper.selectList(
                new EntityWrapper<ActivityWorkRefer>().eq("activity_id",activityId)
        );
        if (list.size() != 0){
            for (int i = 0;i < list.size(); i ++){
                List<ActivityWorkReferResources> resources = activityWorkReferResourcesMapper.selectList(
                        new EntityWrapper<ActivityWorkReferResources>().eq("work_refer_id",list.get(i).getWorkReferId())
                );
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("resources",resources);
                jsonObject.put("work_refer",list.get(i));
                jsonArray.add(jsonObject);
            }
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,jsonArray);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public int getWorkReferId() {
        int id = activityWorkReferMapper.getWorkReferId();
        return id;
    }

    @Override
    public ResponseMessage getUserWorkRefer(int activityId, String account) {
        ResponseMessage responseMessage = null;
        List<ActivityWorkRefer> list = activityWorkReferMapper.selectList(
                new EntityWrapper<ActivityWorkRefer>().eq("activity_id",activityId)
                                                      .eq("refer_user_account",account)
        );
        if (list.size() != 0){
            List<ActivityWorkReferResources> resources = activityWorkReferResourcesMapper.selectList(
                    new EntityWrapper<ActivityWorkReferResources>().eq("work_refer_id",list.get(0).getWorkReferId())
            );
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("workRefer",list.get(0));
            jsonObject.put("resources",resources);
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,jsonObject);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage referWork(ActivityWorkRefer activityWorkRefer) {
        ResponseMessage responseMessage = null;
        int id = activityWorkRefer.getActivityId();
        String account = activityWorkRefer.getReferUserAccount();
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",account)
        ).get(0);
        UserCourse userCourse = userCourseMapper.getUserCourse(id,account);
        Activity activity = activityMapper.selectById(id);
        int experience = activity.getActivityExperience();
        userInfo.setUserJoinActivity(userInfo.getUserJoinActivity()+1);
        userInfo.setUserExperience(userInfo.getUserExperience()+experience);
        userCourse.setUserExperience(userCourse.getUserExperience()+experience);
        userCourse.setUserActivityExperience(userCourse.getUserActivityExperience()+experience);

        int a = activityWorkReferMapper.insert(activityWorkRefer);
        int b = userInfoMapper.updateById(userInfo);
        int c = userCourseMapper.updateById(userCourse);
        if (a != 0 && b != 0 && c != 0){
            ActivityWorkRefer workRefer = activityWorkReferMapper.selectById(activityWorkReferMapper.getWorkReferId());
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,workRefer);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateWork(ActivityWorkRefer activityWorkRefer) {
        ResponseMessage responseMessage = null;
        int n = activityWorkReferMapper.updateById(activityWorkRefer);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage newWorkReferResource(ActivityWorkReferResources workReferResources) {
        ResponseMessage responseMessage = null;
        int n = activityWorkReferResourcesMapper.insert(workReferResources);
        if (n != 0){
            ActivityWorkRefer workRefer = activityWorkReferMapper.selectById(workReferResources.getWorkReferId());
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,workRefer);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public List<Integer> getWorkReferResourceId(int workReferId) {
        List<Integer> ids = new ArrayList<>();
        List<ActivityWorkReferResources> list = activityWorkReferResourcesMapper.selectList(
                new EntityWrapper<ActivityWorkReferResources>().eq("work_refer_id",workReferId)
        );
        for (int i = 0;i < list.size();i ++){
            ids.add(list.get(i).getWorkReferResourceId());
        }
        return ids;
    }

    @Override
    public ResponseMessage deleteWorkReferResource(int  workReferResourceId) {
        ResponseMessage responseMessage = null;
        int n = activityWorkReferResourcesMapper.deleteById(workReferResourceId);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage getGroup(int courseId) {
        ResponseMessage responseMessage = null;
        List<Group> list = groupMapper.selectList(
                new EntityWrapper<Group>().eq("course_id",courseId)
        );
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage newGroup(Group group) {
        ResponseMessage responseMessage = null;
        int n = groupMapper.insert(group);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteGroup(int groupId) {
        ResponseMessage responseMessage = null;
        int n = groupMapper.deleteById(groupId);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateGroup(Group group) {
        ResponseMessage responseMessage = null;
        int n = groupMapper.updateById(group);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage getNotice(int courseId) {
        ResponseMessage responseMessage = null;
        List<Notice> list = noticeMapper.selectList(
                new EntityWrapper<Notice>().eq("course_id",courseId)
        );
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage newNotice(Notice notice) {
        ResponseMessage responseMessage = null;
        int n = 0;
        n = noticeMapper.insert(notice);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,notice);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage deleteNotice(int noticeId) {
        ResponseMessage responseMessage = null;
        int n = 0;
        n = noticeMapper.deleteById(noticeId);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getResource(int courseId) {
        ResponseMessage responseMessage = null;
        List<Resource> resourceList =  resourceMapper.getResource(courseId);
        if (resourceList.size()!=0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,resourceList);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }
        return responseMessage;

    }

    @Override
    public ResponseMessage newResource(Resource resource) {
        ResponseMessage responseMessage = null;
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",resource.getPublishUserAccount())
        ).get(0);
        userInfo.setUserPublishResources(userInfo.getUserPublishResources()+1);
        Group group = groupMapper.selectById(resource.getResourceGroup());
        group.setResourcesNumber(group.getResourcesNumber()+1);

        int a = resourceMapper.insert(resource);
        int b = userInfoMapper.updateById(userInfo);
        int c = groupMapper.updateById(group);

        if (a != 0 && b != 0 && c != 0){
            int id = resourceMapper.getResourceId();
            List<UserCourse> list = userCourseMapper.getUserCourses(id);
            for (int i = 0;i < list.size();i ++){
                UserResourceCheck resourceCheck = new UserResourceCheck();
                resourceCheck.setResourceId(id);
                resourceCheck.setUserAccount(list.get(i).getUserAccount());
                userResourceCheckMapper.insert(resourceCheck);
            }
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.NEW_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.NEW_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage updateResource(Resource resource) {
        ResponseMessage responseMessage = null;
        int n = resourceMapper.updateById(resource);
        if (n != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.UPDATE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.UPDATE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage deleteResource(int resourceId) {
        ResponseMessage responseMessage = null;
        Resource resource = resourceMapper.selectById(resourceId);
        UserInfo userInfo = userInfoMapper.selectList(
                new EntityWrapper<UserInfo>().eq("user_account",resource.getPublishUserAccount())
        ).get(0);
        userInfo.setUserPublishResources(userInfo.getUserPublishResources()-1);
        Group group = groupMapper.selectById(resource.getResourceGroup());
        group.setResourcesNumber(group.getResourcesNumber()-1);

        int a = resourceMapper.deleteById(resourceId);
        int b = userInfoMapper.updateById(userInfo);
        int c = groupMapper.updateById(group);
        int d = userResourceCheckMapper.delete(
                new EntityWrapper<UserResourceCheck>().eq("resource_id",resourceId)
        );
        if (a != 0 && b != 0 && c != 0 && d != 0){

            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.DELETE_OK,null);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.DELETE_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage getResourceCheck(int resourceId) {
        ResponseMessage responseMessage = null;
        List<UserResourceCheck> list = userResourceCheckMapper.selectList(
                new EntityWrapper<UserResourceCheck>().eq("resource_id",resourceId)
        );
        if (list.size() != 0){
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.MSG_GET_OK,list);
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.MSG_GET_ERROR,null);
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage checkResource(String userAccount, int resourceId) {
        ResponseMessage responseMessage = null;
        UserResourceCheck resourceCheck = userResourceCheckMapper.selectList(
                new EntityWrapper<UserResourceCheck>().eq("user_account",userAccount)
                                                      .eq("resource_id",resourceId)
        ).get(0);

        if (resourceCheck.getResourceCheckStatus() == 0){
            resourceCheck.setResourceCheckStatus(1);
            int experience =resourceMapper.selectById(resourceId).getResourceExperience();
            UserInfo userInfo = userInfoMapper.selectList(
                    new EntityWrapper<UserInfo>().eq("user_account",userAccount)
            ).get(0);
            userInfo.setUserExperience(userInfo.getUserExperience()+experience);
            userInfo.setUserSeeResources(userInfo.getUserSeeResources()+1);
            UserCourse userCourse = userCourseMapper.get(resourceId,userAccount);
            userCourse.setUserResourceCheckNumber(userCourse.getUserResourceCheckNumber()+1);
            userCourse.setUserResourceExperience(userCourse.getUserResourceExperience()+experience);

            int a = userResourceCheckMapper.updateById(resourceCheck);
            int b = userInfoMapper.updateById(userInfo);
            int c = userCourseMapper.updateById(userCourse);

            if (a != 0 && b != 0 && c != 0){
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_OK,ConstConfig.RESOURCE_CHECK_OK,null);
            }else {
                responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.RESOURCE_CHECK_ERROR,null);
            }
        }else {
            responseMessage = new ResponseMessage(ConstConfig.RESPONSE_ERROR,ConstConfig.RESOURCE_CHECK,null);
        }

        return responseMessage;
    }
}
