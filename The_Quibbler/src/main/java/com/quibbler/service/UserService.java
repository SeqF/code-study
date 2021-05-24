package com.quibbler.service;

import com.quibbler.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Service
public interface UserService extends IService<User> {

    /**
     * 通过username获取user
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 通过username获取roleCode
     * @param username
     * @return
     */
    List<String> getRoleCodeByUserId(String username);

}
