package com.zhangz1.maildemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangz1.maildemo.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangz1 on 2022/2/16 20:44
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 添加
     *
     * @param user user
     * @return Boolean
     */
    boolean save(User user);

    /**
     * 判断是否存在邮箱
     *
     * @param email 查询的邮箱
     * @return 不存在返回0，存在返回1
     */
    Integer queryByEmail(String email);
}
