package mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/7 8:48
 */
public interface UserMapper extends BaseMapper<User> {
    User findById(@Param("id") int id);
}
