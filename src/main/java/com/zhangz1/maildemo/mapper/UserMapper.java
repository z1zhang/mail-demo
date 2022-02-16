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
}
