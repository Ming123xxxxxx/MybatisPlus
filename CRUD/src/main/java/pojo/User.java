package pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/7 8:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")
public class User extends Model<User> {
    //设置ID自增长
//    @TableId(type = IdType.AUTO)
    private int id;
    private String uname;
    @TableField(select = false)
    private String password;
    private String name;
    private int age;
    private String email;

}
