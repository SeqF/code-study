package com.quibbler.mapper;

import com.quibbler.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> getRoleCodeByUserName(String username);
}
