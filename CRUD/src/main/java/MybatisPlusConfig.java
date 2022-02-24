import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/9 10:21
 */
@Configuration
@MapperScan("mapper")//设置mapper接口的扫描包
public class MybatisPlusConfig {

    @Bean//配置分页插件
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}

