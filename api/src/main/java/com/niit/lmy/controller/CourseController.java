package com.niit.lmy.controller;

import com.alibaba.fastjson.JSONObject;
import com.niit.lmy.entity.*;
import com.niit.lmy.service.CourseService;
import com.niit.lmy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "course/")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "{account}", method = RequestMethod.GET)
    public ResponseMessage getCourses(@PathVariable String account){
        ResponseMessage responseMessage = courseService.getCourses(account);
        return responseMessage;
    }

    @RequestMapping(value = "new",method = RequestMethod.POST)
    public ResponseMessage newCourse(@RequestBody Course course){
        ResponseMessage responseMessage = courseService.newCourse(course);
        return responseMessage;
    }

    @RequestMapping(value = "info",method = RequestMethod.PUT)
    public ResponseMessage updateCourse(@RequestBody Course course){
        ResponseMessage responseMessage = courseService.updateCourse(course);
        return responseMessage;
    }

    @RequestMapping(value = "logo",method = RequestMethod.PUT)
    public ResponseMessage updateCourseLogo(@RequestBody Course course){
        ResponseMessage responseMessage = courseService.updateCourse(course);
        return responseMessage;
    }

    @RequestMapping(value = "finish/{courseId}",method = RequestMethod.PUT)
    public ResponseMessage newCourse(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.finishCourse(courseId);
        return responseMessage;
    }

    @RequestMapping(value = "delete/{courseId}",method = RequestMethod.DELETE)
    public ResponseMessage deleteCourse(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.deleteCourse(courseId);
        return responseMessage;
    }

    @RequestMapping(value = "permission/{roleId}",method = RequestMethod.GET)
    public ResponseMessage getPermission(@PathVariable Integer roleId){
        ResponseMessage responseMessage = courseService.getPermission(roleId);
        return responseMessage;
    }

    @RequestMapping(value = "group/{courseId}",method = RequestMethod.GET)
    public ResponseMessage getGroup(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.getGroup(courseId);
        return responseMessage;
    }

    @RequestMapping(value = "group", method = RequestMethod.POST)
    public ResponseMessage newGroup(@RequestBody Group group){
        ResponseMessage responseMessage = courseService.newGroup(group);
        return responseMessage;
    }

    @RequestMapping(value = "group", method = RequestMethod.PUT)
    public ResponseMessage updateGroup(@RequestBody Group group){
        ResponseMessage responseMessage = courseService.updateGroup(group);
        return responseMessage;
    }

    @RequestMapping(value = "group/{groupId}", method = RequestMethod.DELETE)
    public ResponseMessage deleteGroup(@PathVariable Integer groupId){
        ResponseMessage responseMessage = courseService.deleteGroup(groupId);
        return responseMessage;
    }

    @RequestMapping(value = "notice/{courseId}",method = RequestMethod.GET)
    public ResponseMessage getNotice(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.getNotice(courseId);
        return responseMessage;
    }

    @RequestMapping(value = "notice", method = RequestMethod.POST)
    public ResponseMessage newNotice(@RequestBody Notice notice){
        ResponseMessage responseMessage = courseService.newNotice(notice);
        return responseMessage;
    }

    @RequestMapping(value = "notice/{noticeId}", method = RequestMethod.DELETE)
    public ResponseMessage deleteNotice(@PathVariable Integer noticeId){
        ResponseMessage responseMessage = courseService.deleteNotice(noticeId);
        return responseMessage;
    }

    @RequestMapping(value = "activity/{courseId}",method = RequestMethod.GET)
    public ResponseMessage getActivity(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.getActivity(courseId);
        return responseMessage ;
    }

    @RequestMapping(value = "activity", method = RequestMethod.POST)
    public ResponseMessage newActivity(@RequestBody JSONObject jsonObject){
        ResponseMessage responseMessage = null;
        Date date = new Date();
        String publishUserAccount = jsonObject.getString("publishUserAccount");
        Integer activityType = jsonObject.getInteger("activityType");
        String activityTitle = jsonObject.getString("activityTitle");
        Integer activityGroup = jsonObject.getInteger("activityGroup");
        Integer activityExperience = jsonObject.getInteger("activityExperience");
        String activityInfo = jsonObject.getString("activityInfo");
        Integer activityStatus = jsonObject.getInteger("activityStatus");
        List<String> resources = (List<String>) jsonObject.get("activityResourceUrl");

        Activity activity = new Activity();
        activity.setPublishUserAccount(publishUserAccount);
        activity.setActivityType(activityType);
        activity.setActivityTitle(activityTitle);
        activity.setActivityGroup(activityGroup);
        activity.setActivityExperience(activityExperience);
        activity.setActivityInfo(activityInfo);
        activity.setActivityStatus(activityStatus);
        activity.setActivityStartTime(date);

        responseMessage = courseService.newActivity(activity);
        if (responseMessage.getMsg().equals("新建成功") && resources != null && !resources.equals("")){
            int id = courseService.getActivityId();
            for (int i = 0;i < resources.size();i ++){
                ActivityResources activityResources = new ActivityResources();
                activityResources.setActivityId(id);
                activityResources.setActivityResourceUrl(resources.get(i));
                responseMessage = courseService.newActivityResources(activityResources);
            }
        }
        return responseMessage;
    }

    @RequestMapping(value = "activity",method = RequestMethod.PUT)
    public ResponseMessage updateActivity(@RequestBody Activity activity){
        ResponseMessage responseMessage = courseService.updateActivity(activity);
        return responseMessage;
    }

    @RequestMapping(value = "activity/status",method = RequestMethod.PUT)
    public ResponseMessage updateActivityStatus(@RequestBody Activity activity){
        ResponseMessage responseMessage = courseService.updateActivity(activity);
        return responseMessage;
    }

    @RequestMapping(value = "activity/{activityId}",method = RequestMethod.DELETE)
    public ResponseMessage deleteActivity(@PathVariable Integer activityId){
        ResponseMessage responseMessage = courseService.deleteActivity(activityId);
        return responseMessage;
    }

    @RequestMapping(value = "activity/storming/{activityId}", method = RequestMethod.GET)
    public ResponseMessage getStormingRefer(@PathVariable Integer activityId){
        ResponseMessage responseMessage = courseService.getStormingRefer(activityId);
        return responseMessage;
    }

    @RequestMapping(value = "activity/storming/user", method = RequestMethod.POST)
    public ResponseMessage getStormRefer(@RequestBody JSONObject jsonObject){
        Integer activityId = (Integer) jsonObject.get("activityId");
        String account = jsonObject.getString("userAccount");
        ResponseMessage responseMessage = courseService.getStormRefer(activityId,account);
        return responseMessage;
    }

    @RequestMapping(value = "activity/storming",method = RequestMethod.POST)
    public ResponseMessage referStorm(@RequestBody ActivityBrainStormingRefer stormingRefer){
        ResponseMessage responseMessage = courseService.referStorm(stormingRefer);
        return responseMessage;
    }

    @RequestMapping(value = "activity/storming",method = RequestMethod.PUT)
    public ResponseMessage updateStormRefer(@RequestBody ActivityBrainStormingRefer stormRefer){
        ResponseMessage responseMessage = courseService.updateStorm(stormRefer);
        return responseMessage;
    }

    @RequestMapping(value = "activity/work/{activityId}", method = RequestMethod.GET)
    public ResponseMessage getWorkRefer(@PathVariable Integer activityId){
        ResponseMessage responseMessage = courseService.getWorkRefer(activityId);
        return responseMessage;
    }

    @RequestMapping(value = "activity/work/user", method = RequestMethod.POST)
    public ResponseMessage getUserWorkRefer(@RequestBody JSONObject jsonObject){
        JSONObject js = new JSONObject();
        Integer activityId = (Integer) jsonObject.get("activityId");
        String account = jsonObject.getString("userAccount");
        ResponseMessage responseMessage = courseService.getUserWorkRefer(activityId,account);
        return responseMessage;
    }

    @RequestMapping(value = "activity/work",method = RequestMethod.POST)
    public ResponseMessage referWork(@RequestBody JSONObject jsonObject){
        ResponseMessage responseMessage = null;
        Integer activityId = (Integer) jsonObject.get( "activityId");
        String referUserAccount = jsonObject.getString("referUserAccount");
        String workReferInfo = jsonObject.getString("workReferInfo");
        List<String> resources = (List<String>) jsonObject.get("workReferResource");
        Date date = new Date();

        ActivityWorkRefer workRefer = new ActivityWorkRefer();
        workRefer.setActivityId(activityId);
        workRefer.setReferUserAccount(referUserAccount);
        workRefer.setWorkReferInfo(workReferInfo);
        workRefer.setWorkReferTime(date);

        responseMessage = courseService.referWork(workRefer);
        if (responseMessage.getMsg().equals("新建成功") && resources !=  null && !resources.equals("")){
            int id = courseService.getWorkReferId();
            for (int i = 0;i < resources.size();i ++){
                ActivityWorkReferResources resource = new ActivityWorkReferResources();
                resource.setWorkReferId(id);
                resource.setWorkReferResource(resources.get(i));
                responseMessage = courseService.newWorkReferResource(resource);
            }
        }

        return responseMessage;
    }

    @RequestMapping(value = "activity/work",method = RequestMethod.PUT)
    public ResponseMessage updateWorkRefer(@RequestBody JSONObject jsonObject){
        ResponseMessage responseMessage = null;
        Integer workReferId = jsonObject.getInteger("workReferId");
        Integer activityId = (Integer) jsonObject.get( "activityId");
        String referUserAccount = jsonObject.getString("referUserAccount");
        String workReferInfo = jsonObject.getString("workReferInfo");
        List<String> list = (List<String>) jsonObject.get("workReferResource");
        Date date = new Date();

        ActivityWorkRefer workRefer = new ActivityWorkRefer();
        workRefer.setWorkReferId(workReferId);
        workRefer.setActivityId(activityId);
        workRefer.setReferUserAccount(referUserAccount);
        workRefer.setWorkReferInfo(workReferInfo);
        workRefer.setWorkReferTime(date);

        responseMessage = courseService.updateWork(workRefer);
        if (responseMessage.getMsg().equals("修改成功")){
            List<Integer> ids = courseService.getWorkReferResourceId(workReferId);
            for (int i = 0;i < ids.size();i ++){
                responseMessage = courseService.deleteWorkReferResource(ids.get(i));
            }
            if (responseMessage.getMsg().equals("删除成功") && list !=  null && !list.equals("")){
                int j = 0;
                while (j < list.size()){
                    ActivityWorkReferResources resource = new ActivityWorkReferResources();
                    resource.setWorkReferId(workReferId);
                    resource.setWorkReferResource(list.get(j));
                    responseMessage = courseService.newWorkReferResource(resource);
                    j ++;
                }
            }
        }
        return responseMessage;
    }

    @RequestMapping(value = "user/{courseId}",method = RequestMethod.GET)
    public ResponseMessage getUser(@PathVariable Integer courseId){
        ResponseMessage responseMessage = courseService.getUsers(courseId);
        return responseMessage;
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public ResponseMessage addUser(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("userAccount");
        String inviteId = jsonObject.getString("courseInviteId");

        ResponseMessage responseMessage = courseService.addUser(account,inviteId);
        return responseMessage;
    }

    @RequestMapping(value = "user",method = RequestMethod.DELETE)
    public ResponseMessage removeUser(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("userAccount");
        Integer courseId = jsonObject.getInteger("courseId");

        ResponseMessage responseMessage = courseService.removeUser(account,courseId);
        return responseMessage;
    }

    @RequestMapping(value = "role",method = RequestMethod.POST)
    public ResponseMessage setRole(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("userAccount");
        Integer id = jsonObject.getInteger("courseId");

        ResponseMessage responseMessage = courseService.setRole(account,id);
        return responseMessage;
    }

    @RequestMapping(value = "role",method = RequestMethod.DELETE)
    public ResponseMessage deleteRole(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("userAccount");
        Integer id = jsonObject.getInteger("courseId");

        ResponseMessage responseMessage = courseService.deleteRole(account,id);
        return responseMessage;
    }

    @RequestMapping(value = "resource/{courseId}",method = RequestMethod.GET)
    public  ResponseMessage getResource(@PathVariable Integer courseId){
        ResponseMessage responseMessage =  courseService.getResource(courseId);
        return responseMessage ;
    }

    @RequestMapping(value = "resource",method = RequestMethod.POST)
    public ResponseMessage newResource(@RequestBody Resource resource){
        ResponseMessage responseMessage = courseService.newResource(resource);
        return responseMessage;
    }

    @RequestMapping(value = "resource",method = RequestMethod.PUT)
    public ResponseMessage updateResource(@RequestBody Resource resource){
        ResponseMessage responseMessage = courseService.updateResource(resource);
        return responseMessage;
    }

    @RequestMapping(value = "resource/{resourceId}",method = RequestMethod.DELETE)
    public ResponseMessage deleteResource(@PathVariable Integer resourceId){
        ResponseMessage responseMessage = courseService.deleteResource(resourceId);
        return responseMessage;
    }

    @RequestMapping(value = "resource/check/{resourceId}",method = RequestMethod.GET)
    public ResponseMessage resourceCheck(@PathVariable Integer resourceId){
        ResponseMessage responseMessage = courseService.getResourceCheck(resourceId);
        return responseMessage;
    }

    @RequestMapping(value = "resource/check",method = RequestMethod.PUT)
    public ResponseMessage checkResource(@RequestBody JSONObject jsonObject){
        String account = jsonObject.getString("userAccount");
        Integer id = jsonObject.getInteger("resourceId");

        ResponseMessage responseMessage = courseService.checkResource(account,id);
        return responseMessage;
    }
}
