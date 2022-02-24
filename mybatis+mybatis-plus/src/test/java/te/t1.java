package te;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/6 9:59
 */
public class t1 {

    @Test
    public void ol() throws IOException {
        String config="Mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //测试查询
        List<User> all = mapper.findAll();

        for(User al:all){
            System.out.println(al);
        }

    }

    @Test
    public void t2() throws IOException {
        String config="Mybatis-config.xml";

        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //测试查询,获取所有的数据
        List<User> all = mapper.selectList(null);

        for(User al:all){
            System.out.println(al);
        }
    }
}
