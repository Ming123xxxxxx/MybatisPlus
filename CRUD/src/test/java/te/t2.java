package te;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.User;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/14 10:14
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class t2 {

    @Test
    public void testselectbyid(){
        User user = new User();
        user.setId(4);
        User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    public void testinsert(){
        User user = new User(6,"guanyu","12342121","关羽",40,"99999@qq.com");
        //调用AR的insert()进行插入操作
        if(user.insert()){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }

    @Test
    public void testupdate(){
        User user = new User();
        //查询条件
        user.setId(3);
        //更新数据
        user.setAge(80);
        if(user.updateById()){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void testdelete(){
        User user = new User();
        user.setId(6);
        if(user.deleteById()){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void testselect(){
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age",23);
        List<User> list = user.selectList(wrapper);
        for(User us:list){
            System.out.println(us);
        }
    }

}
