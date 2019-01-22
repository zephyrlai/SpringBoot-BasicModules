import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/22 20:12
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "cn.zephyr")
@MapperScan(basePackages="cn.zephyr.mapper")
public class PoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiApplication.class,args);
    }
}
