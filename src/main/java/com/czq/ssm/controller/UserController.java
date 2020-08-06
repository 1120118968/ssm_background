package com.czq.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czq.ssm.mapper.TUserManager;
import com.czq.ssm.model.TUserDo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//声明控制器类
@Controller
/*
 * 相当于 http://你的ip:tomcat定义的端口（默认8080）/user/
 * 例: http://192.168.17.52:8080/user/
 * ip可以通过 win+R调出运行 输入cmd 在输入ipconfig 然后取IPv4地址
 */
@RequestMapping(value = "user")
//lombok注解 自动生成log类
@Log4j
public class UserController {
    @Autowired
    TUserManager tUserManager;

    /*
     * 请求参数uName，uAge，uSex
     */
    // @ResponseBody:controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
    @ResponseBody
    //相当于请求地址为http://192.168.17.52:8080/user/insert  请求方法为POST
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(HttpServletRequest request) {
        log.info("执行增加");
        //定义请求数
        String uName = request.getParameter("uName");
        int uAge = Integer.parseInt(request.getParameter("uAge"));
        String uSex = request.getParameter("uSex");
        log.info(uName + ":" + uAge + ":" + uSex);
        TUserDo tUserDo = new TUserDo();
        tUserDo.setUName(uName);
        tUserDo.setUAge(uAge);
        tUserDo.setUSex(uSex);
        int i = tUserManager.insertSelective(tUserDo);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /*
     *请求参数：uid
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request) {
        log.info("执行删除");
        int id = Integer.parseInt(request.getParameter("uid"));
        log.info(id);
        TUserDo tUserDo = new TUserDo();
        tUserDo.setUid(id);
        int i = tUserManager.deleteByPrimaryKey(tUserDo);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    /*
     *请求参数：uid
     */
    @ResponseBody
    @RequestMapping(value = "select", method = RequestMethod.POST)
    public String select(HttpServletRequest request) {
        log.info("执行查找");
        int id = Integer.parseInt(request.getParameter("uid"));
        log.info(id);
        TUserDo tUserDo = tUserManager.selectByPrimaryKey((long) id);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(tUserDo);
        return jsonObject.toJSONString();
    }

    /*
     * 请求参数uName，uAge，uSex,id
     */
    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request) {
        log.info("执行修改");
        int id = Integer.parseInt(request.getParameter("uid"));
        String uName = request.getParameter("uName");
        int uAge = Integer.parseInt(request.getParameter("uAge"));
        String uSex = request.getParameter("uSex");
        log.info(id + ":" + uName + ":" + uAge + ":" + uSex);
        TUserDo tUserDo = new TUserDo();
        tUserDo.setUid(id);
        tUserDo.setUName(uName);
        tUserDo.setUAge(uAge);
        tUserDo.setUSex(uSex);
        int i = tUserManager.updateByPrimaryKeySelective(tUserDo);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }
}
