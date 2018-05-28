package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IUserService;
import com.xg.mall.dao.XgwhRoleMapper;
import com.xg.mall.dao.XgwhUserMapper;
import com.xg.mall.dao.XgwhUserRoleMapper;
import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhUser;
import com.xg.mall.po.XgwhUserRole;
import com.xg.utils.Substract;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    //注入用户mapper
    @Autowired
    private XgwhUserMapper xgwhUserMapper;
    //注入用户角色关系mapper
    @Autowired
    private XgwhUserRoleMapper xgwhUserRoleMapper;
    //注入角色mapper
    @Autowired
    private XgwhRoleMapper xgwhRoleMapper;

    //用户添加
    @Override
    public boolean add(XgwhUser xgwhUser) {
        xgwhUser.setAddTime(Time.UnixTime());
        int res = xgwhUserMapper.insertSelective(xgwhUser);
        logger.debug("实现层添加管理员日志");
        return res > 0;
    }

    //查询所有用户
    @Override
    public List<XgwhUser> select() {
        List<XgwhUser> list = xgwhUserMapper.select();
        for (XgwhUser time : list) {
            Integer add_time = time.getAddTime();
            String sd = Time.StrTime(add_time);
            time.setStrTime(sd);
        }
        logger.debug("实现层查询管理员日志");
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public XgwhUser selectByPrimaryKey(Integer id) {
        XgwhUser xgwhUser = xgwhUserMapper.selectByPrimaryKey(id);
        logger.debug("实现层查询单个管理员日志");
        return xgwhUser;
    }

    //更新用户
    @Override
    public boolean update(XgwhUser xgwhUser) {
        int res = xgwhUserMapper.updateByPrimaryKeySelective(xgwhUser);
        logger.debug("实现层更新管理员日志");
        return res > 0;
    }

    //删除用户并且删除用户的角色关系
    @Override
    public boolean delete(Integer id) {
        List<XgwhUserRole> list =  xgwhUserRoleMapper.selectUserId(id);
        System.out.println(list);
        if(!list.isEmpty()){
            int result = xgwhUserRoleMapper.deleteUserRole(id);
            if(result < 1){
                return false;
            }
        }
        int res = xgwhUserMapper.deleteByPrimaryKey(id);
        logger.debug("实现层删除管理员日志");
        return res > 0;
    }

    //编辑用户角色
    @Override
    public boolean updateUserRole(List<XgwhUserRole> list) {

        //定义三个数组两个字符串，一个整型
        LinkedList<String> arr = new LinkedList<>();
        LinkedList<String> arr2 = new LinkedList<>();
        LinkedList<Integer> arr3 = new LinkedList<>();

        //获取用户id
        int userId = list.get(0).getUserId();

        //判断如果没有传roleid就是清空用户所有角色
        if(list.get(0).getRoleId() == null){
            int is_res = xgwhUserRoleMapper.deleteUserRole(userId);
            return  is_res > 0 ;
        }

        //查询所有角色
        List<XgwhRole> roles  = xgwhRoleMapper.select();

        //循环拿出来角色id放入新数组
        for (XgwhRole roleId : roles){
             arr3.add(roleId.getId());
        }

        //循环判断传来的角色id是不是在数据库里如果有加入新数组
        for(XgwhUserRole xur : list) {
            if(arr3.contains(xur.getRoleId())) {
                arr.add(xur.getRoleId().toString());
            }

        }

        //查询某个用户和角色所有关系
        List<XgwhUserRole> list2 = xgwhUserRoleMapper.selectUserId(userId);

        //循环拿出roleid放入新数组
        for(XgwhUserRole xur : list2) {
            arr2.add(xur.getRoleId().toString());
        }

        //定义一个String空数组
        String[] result = {};

        //调用substract方法取出差集，a是需要添加，b是需要删除，然后将LinkedList可变长的数组转换成String数组
        String[] a = Substract.substract(arr.toArray(result),arr2.toArray(result));
        String[] b = Substract.substract(arr2.toArray(result),arr.toArray(result));

        //定义两变量
        int res = 0;
        int r   = 0;

        //循环返回的b数组然后删除
        for(String x : b) {
            res = xgwhUserRoleMapper.deleteByUserIdRoleId(userId, Integer.parseInt(x));
        }

        //循环返回a数组返回添加
        for(String x : a) {
            XgwhUserRole xgwhUserRole = new XgwhUserRole();
            xgwhUserRole.setUserId(userId);
            xgwhUserRole.setRoleId(Integer.parseInt(x));
            xgwhUserRole.setAddTime(Time.UnixTime());
            r = xgwhUserRoleMapper.insertSelective(xgwhUserRole);
        }
        logger.debug("实现层编辑管理员角色日志");
        //判断一个为真就返回真
        return res > 0 || r > 0;

    }

}
