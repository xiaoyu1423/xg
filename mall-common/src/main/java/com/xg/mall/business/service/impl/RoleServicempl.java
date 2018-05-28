package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IRoleService;
import com.xg.mall.dao.XgwhAccessMapper;
import com.xg.mall.dao.XgwhRoleAccessMapper;
import com.xg.mall.dao.XgwhRoleMapper;
import com.xg.mall.dao.XgwhUserRoleMapper;
import com.xg.mall.po.XgwhAccess;
import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhRoleAccess;
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
public class RoleServicempl implements IRoleService {
    private Logger logger = Logger.getLogger(RoleServicempl.class);
    //注入角色mapper
    @Autowired
    private XgwhRoleMapper xgwhRoleMapper;

    //注入角色和用户mapper
    @Autowired
    private XgwhUserRoleMapper xgwhUserRoleMapper;

    //注入角色和权限mapper
    @Autowired
    private XgwhRoleAccessMapper xgwhRoleAccessMapper;

    //注入权限mapper
    @Autowired
    private XgwhAccessMapper xgwhAccessMapper;

    //添加角色
    @Override
    public boolean add(XgwhRole xgwhRole) {
        xgwhRole.setAddTime(Time.UnixTime());
        int res = xgwhRoleMapper.insertSelective(xgwhRole);
        logger.debug("实现层添加角色日志");
        return res > 0;
    }

    //查询所有角色
    @Override
    public List<XgwhRole> select() {
        List<XgwhRole> list = xgwhRoleMapper.select();
        logger.debug("实现层添加查询角色日志");
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }
    //查询单个
    @Override
    public XgwhRole selectByPrimaryKey(Integer id) {
        XgwhRole xgwhRole = xgwhRoleMapper.selectByPrimaryKey(id);
        logger.debug("实现层添加单个查询角色日志");
        return xgwhRole;
    }

    //更新角色
    @Override
    public boolean update(XgwhRole xgwhRole) {
        int res =xgwhRoleMapper.updateByPrimaryKeySelective(xgwhRole);
        logger.debug("实现层编辑日志");
        return res > 0;
    }

    //删除角色并删除和用户关系，权限关系
    @Override
    public boolean delete(Integer id) {
        List<XgwhRoleAccess> list = xgwhRoleAccessMapper.select(id);
        if(!list.isEmpty()){
            int result = xgwhRoleAccessMapper.deleteRoleId(id);
            if(result < 1){
                return  false;
            }
        }
        List<XgwhUserRole> arr = xgwhUserRoleMapper.selectRoleId(id);
        if(!arr.isEmpty()){
            int type = xgwhUserRoleMapper.deleteRoleId(id);
            if(type < 1){
                return false;
            }
        }
        int res = xgwhRoleMapper.deleteByPrimaryKey(id);
        logger.debug("实现层添加删除角色日志");
        return res > 0;
    }

    //编辑角色和权限
    @Override
    public boolean updateRoleAccess(List<XgwhRoleAccess> list){

        //定义一个可以变成的String数组
        LinkedList<String> arr = new LinkedList<>();
        LinkedList<String> arr2 = new LinkedList<>();
        //定义一个可以变成的int数组
        LinkedList<Integer> arr3 = new LinkedList<>();

        //获取roleId
        int roleId = list.get(0).getRoleId();

        //判断有没有传权限id如果没有就情况这个角色下的所有权限
        if(list.get(0).getAccessId() == null){

            //删除这个角色下的所有权限
            int is_res = xgwhRoleAccessMapper.deleteRoleId(roleId);
            return  is_res > 0;

        }

        //查询所有权限
        List<XgwhAccess> accesses = xgwhAccessMapper.select();

        //循环拿出来权限的id
        for (XgwhAccess AccessId: accesses){
             arr3.add(AccessId.getId());
        }

        //然后循环看提交的权限是不是在数据库中如果存在添加新数组
        for(XgwhRoleAccess xra : list){
            if(arr3.contains(xra.getAccessId())){
                 arr.add(xra.getAccessId().toString());
            }
        }

        //然后查询某个角色和权限的所有关系
        List<XgwhRoleAccess> list2 = xgwhRoleAccessMapper.select(roleId);

        //然后循环取出来权限id
        for (XgwhRoleAccess xra : list2){
             arr2.add(xra.getAccessId().toString());
        }

        //定义一个String数组
        String[] result = {};

        //调用substract方法取出差集，a是需要添加，b是需要删除，然后将LinkedList可变长的数组转换成String数组
        String[] a = Substract.substract(arr.toArray(result),arr2.toArray(result));
        String[] b = Substract.substract(arr2.toArray(result),arr.toArray(result));

        //定义两变量
        int res = 0;
        int r   = 0;

        //循环返回的b数组然后删除
        for (String x : b){
            res = xgwhRoleAccessMapper.deleteByRoleIdAccessId(roleId,Integer.parseInt(x));
        }

        //循环返回a数组返回添加
        for (String x : a){
            XgwhRoleAccess xgwhRoleAccess = new XgwhRoleAccess();
            xgwhRoleAccess.setRoleId(roleId);
            xgwhRoleAccess.setAccessId(Integer.parseInt(x));
            xgwhRoleAccess.setAddTime(Time.UnixTime());
            r = xgwhRoleAccessMapper.insertSelective(xgwhRoleAccess);
        }
        logger.debug("实现层编辑角色和权限日志");
        //判断只要一个为真
        return res > 0 || r > 0;

    }
}
