package cn.zephyr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ClassName: CacheApplication
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/10 16:42
 */
@SpringBootApplication
@EnableCaching
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class,args);
    }
}
