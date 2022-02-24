package mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/6 9:54
 */
public interface UserMapper extends BaseMapper<User> {
    List <User> findAll();
}
