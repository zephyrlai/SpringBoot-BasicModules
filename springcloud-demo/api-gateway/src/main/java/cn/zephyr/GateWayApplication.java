package cn.zephyr;


import cn.zephyr.filter.AccessFilter;
import cn.zephyr.filter.MyOriginFilter;
import cn.zephyr.filter.MyPostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    /*@Bean
    public MyPostFilter myPostFilter(){
        return new MyPostFilter();
    }

    @Bean
    public MyOriginFilter myOriginFilter(){
        return new MyOriginFilter();
    }*/
}
