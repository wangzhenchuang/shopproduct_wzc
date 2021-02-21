package com.wzc.shopproduct_wzc.controller;

import com.wzc.shopproduct_wzc.entity.po.ShopUser;
import com.wzc.shopproduct_wzc.entity.po.ShopUserRole;
import com.wzc.shopproduct_wzc.entity.vo.ResultData;
import com.wzc.shopproduct_wzc.entity.vo.UserParams;
import com.wzc.shopproduct_wzc.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class ShopUserController {


    @Autowired
    private ShopUserService shopUserService;


     /*
     * 查询用户数据的接口文档
     * 路径  http://localhost:8080/api/user/list
     *
     * 请求方式  post
     *
     * 参数  start  size (必填)
     *
     * 返回值 回值    {code:"",message:"",data:map}
     * */
    @PostMapping("list")
    public ResultData  queryUserData(UserParams params){
        if (params.getSize()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        if (params.getStart()==null){
            return  ResultData.error(400,"参数不符合规则");
        }

        Map map = shopUserService.queryUserData(params);
        return  ResultData.success(map);
    }

    /*
     * 修改用户数据的接口文档
     * 路径  http://localhost:8080/api/user/update
     *
     * 请求方式  post
     *
     * 参数  id (必填)
     *
     * 返回值 回值    {code:"",message:"",data:}
     * */
    @PostMapping("update")
    public  ResultData  updateUserData(ShopUser user){
        if (user.getId()==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        shopUserService.updateUserData(user);
        return ResultData.success(null);
    }

     /*
     * 逻辑删除用户数据的接口文档
     * 路径  http://localhost:8080/api/user/delete
     *
     * 请求方式  post
     *
     * 参数  id (必填)
     *
     * 返回值 回值    {code:"",message:"",data:}
     * */
    @PostMapping("delete")
    public  ResultData  deleteUserData(Integer id){
        if (id==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        shopUserService.deleteUserData(id);
        return  ResultData.success(null);
    }



      /*
     *  //用户赋角色
     * 路径  http://localhost:8080/api/user/addUserRole
     *
     * 请求方式  post
     *
     * 参数  id (必填)
     *
     * 返回值 回值    {code:"",message:"",data:}
     * */
    @PostMapping("addUserRole")
    public  ResultData addUserRoleData(Integer uid, String  rid){
        if (uid==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        if (rid==null){
            return  ResultData.error(400,"参数不符合规则");
        }
        shopUserService.addUserRoleData(uid,rid);
        return   ResultData.success(null);
    }


      /*
     *  //查询用户所拥有的角色
     * 路径  http://localhost:8080/api/user/listUserRole
     *
     * 请求方式  post
     *
     * 参数  uid (必填)
     *
     * 返回值 回值    {code:"",message:"",data:}
     * */
      @GetMapping("listUserRole")
    public  ResultData  queryUserRoleByUid(Integer uid){
        List<ShopUserRole> shopUserRoles = shopUserService.queryUserRoleByUid(uid);
        return  ResultData.success(shopUserRoles);
    }



}
