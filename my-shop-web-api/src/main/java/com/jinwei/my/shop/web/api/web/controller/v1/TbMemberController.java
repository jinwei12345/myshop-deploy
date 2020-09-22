package com.jinwei.my.shop.web.api.web.controller.v1;

import com.jinwei.my.shop.commons.dto.BaseResult;
import com.jinwei.my.shop.domain.TbMember;
import com.jinwei.my.shop.web.api.service.TbMemberService;
import com.jinwei.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员管理
 * <p>Title: TbUserController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/6 9:16
 */
@RestController
@RequestMapping(value = "${api.path.v1}/members")
public class TbMemberController {

    @Autowired
    private TbMemberService tbMemberService;


    /**
     * 登录
     *
     * @param tbMember
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(TbMember tbMember) {
        TbMember member = tbMemberService.login(tbMember);
        if (member == null) {

            return BaseResult.fail("账号或密码错误");
        } else {
            TbUserDTO tbUserDTO =new TbUserDTO ();
            BeanUtils.copyProperties (member,tbUserDTO);

            return BaseResult.success("成功", tbUserDTO);
        }
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseResult register(TbMember tbMember){

//       if (!tbUserService.checkUserNameAndPhone (tbUser)){
//
//          return BaseResult.fail ("用户名或手机已注册");
//
//       } else {
//
//           TbUserDTO dto =new TbUserDTO ();
//           TbUser user= tbUserService.register (tbUser);
//           BeanUtils.copyProperties (user,dto);
//           return BaseResult.success ("成功",dto);
//
//       }
        if (tbMemberService.register (tbMember) != null){
            return BaseResult.success ("注册成功");
        }

        return BaseResult.fail ("注册失败");
    }
    @RequestMapping(value = "checkphone",method = RequestMethod.GET)
    public  BaseResult checkPhone( String phone){
        int count= tbMemberService.checkPhoneRegister (phone);
        if (count != 0){
            return BaseResult.fail ("该手机号已被注册");
        }
        else {
            return  BaseResult.success ("该手机号可用于注册");

        }
    }

}
