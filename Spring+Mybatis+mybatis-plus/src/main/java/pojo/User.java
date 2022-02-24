package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
public class User {
    private int id;
    private String uname;
    private String password;
    private String name;
    private int age;
    private String email;
}
