package te;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import javax.management.Query;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void InsertTest(){
        int insert = userMapper.insert(new User(5, "liubei", "2421211", "刘备", 50, "55556@qq.com"));
        if(insert==1){
            System.out.println("添加成功");
        }else
        System.out.println("添加失败");
    }

    @Test
    public void SelectOne(){
        User user = userMapper.selectById(1);
        System.out.println(user.toString());
    }

    @Test
    public void updatebyid(){
        User user = new User();
        user.setId(1);
        user.setName("李逵");
        user.setAge(99);
        int i = userMapper.updateById(user);
        if(i==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void updatebywhere(){
        User user = new User();
        user.setAge(44);
        user.setEmail("9111@qq.com");

        QueryWrapper<User> queryWrapper = new QueryWrapper();
        //给uname=lisi的修改数据
        queryWrapper.eq("uname","lisi");
        int update = userMapper.update(user, queryWrapper);
        if(update==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void updatewhere(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age",991).set("password","999111")//更新的字段
        .eq("uname","wangwu");//更新的条件
        int update = userMapper.update(null, wrapper);
        if(update==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void deletebyid(){
        int i = userMapper.deleteById(5);
        if(i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void deletebymap(){
        Map map = new HashMap();
        //多条件删除,当uname和password都与数据库数据相等时才能删除成功
        map.put("uname","zhangsan");
        map.put("password","1231211");
        int i = userMapper.deleteByMap(map);
        if(i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void delete1() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("uname","zhangsan").eq("password","123456");
        int delete = userMapper.delete(wrapper);
        if(delete==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void delete2() {
        User user = new User();
        user.setUname("wangwu");
        user.setPassword("999111");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        //根据包装条件做删除
        int delete = userMapper.delete(wrapper);
        if(delete==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void deletebatchids(){
        //根据ID做批量删除
        int i = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        if(i>1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void selectbyid(){
        User user = userMapper.selectById(3);
        System.out.println(user.toString());
    }

    @Test
    public void selectbatchids() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(3, 4));

        for(User us:users){
            System.out.println(us);
        }
    }

    @Test
    public void selectone(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("uname","zhaoliu");
        //查询的数据超过一条时,会抛出异常
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void selectcount(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //根据条件查询数据条数
        wrapper.gt("age",40);//条件:年龄>40的用户
        Integer integer = userMapper.selectCount(wrapper);
        System.out.println("count="+integer);
    }

    @Test
    public void selectlist(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email","qq");//查询每个用户中email包含qq的数据
        List<User> list = userMapper.selectList(wrapper);
        for (User us:list){
            System.out.println(us);
        }
    }

    //测试分页查询
    @Test
    public void seletcpage(){
        Page<User> page = new Page<>(1,1);//查询第一页，一条数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email","qq");//查询每个用户中email包含qq的数据
        IPage<User> userIPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数="+userIPage.getTotal());
        System.out.println("数据总页数="+userIPage.getPages());
        System.out.println("当前页数="+userIPage.getCurrent());
        List<User> list = userIPage.getRecords();
        for(User li:list){
            System.out.println(li);
        }
    }

    //自定义的查找语句
    @Test
    public void testFindById(){
        User byId = userMapper.findById(4);
        System.out.println(byId);
    }

    @Test
    public void alleq(){

        Map<String,Object> map= new HashMap<>();
        map.put("name","赵六");
        map.put("age",23);
        map.put("password",null);

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE password IS NULL AND name = ? AND age = ?
//        wrapper.allEq(map);

        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE name = ? AND age = ?
        wrapper.allEq(map,false);

        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE name = ? AND age = ? AND name = ? AND age = ?
        wrapper.allEq((k,v) -> (k.equals("age") || k.equals("id") || k.equals("name")),map);

        List<User> list = userMapper.selectList(wrapper);

        for(User li:list){
            System.out.println(li);
        }

    }

    @Test
    public void testeq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE password = ? AND age >= ? AND name IN (?,?,?)
        queryWrapper.eq("password","3413412").ge("age",20).in("name","王五","赵六");
        List<User> list = userMapper.selectList(queryWrapper);
        for(User li:list){
            System.out.println(li);
        }
    }

    @Test
    public void testlike() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE name LIKE ?
        queryWrapper.likeLeft("name","五");

        List<User> list = userMapper.selectList(queryWrapper);
        for(User li:list){
            System.out.println(li);
        }
    }

    @Test
    public void testorder() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //按照年龄倒序排序
        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user ORDER BY age DESC
        queryWrapper.orderByDesc("age");

        List<User> list = userMapper.selectList(queryWrapper);
        for(User li:list){
            System.out.println(li);
        }
    }

    @Test
    public void testor(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //按照年龄倒序排序
        //此方法查询语句结果:SELECT id,uname,name,age,email FROM tb_user WHERE name = ? OR age = ?
        queryWrapper.eq("name","王五").or().eq("age",23);
        List<User> list = userMapper.selectList(queryWrapper);
        for(User li:list){
            System.out.println(li);
        }
    }

    @Test
    public void testselect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //select:指定查询的字段
        //此方法查询语句结果:SELECT id,name,age FROM tb_user WHERE name = ? OR age = ?
        queryWrapper.eq("name","王五").or().eq("age",23).select("id","name","age");
        List<User> list = userMapper.selectList(queryWrapper);
        for(User li:list){
            System.out.println(li);
        }
    }

}
