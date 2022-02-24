package te;

import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/7 8:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class t1 {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void te1(){
        List<User> users = this.userMapper.selectList(null);
        for(User us:users){
            System.out.println(us);
        }

    }
}
