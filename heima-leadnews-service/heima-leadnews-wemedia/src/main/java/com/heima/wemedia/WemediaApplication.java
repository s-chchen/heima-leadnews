package com.heima.wemedia;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.heima.wemedia.mapper")
@EnableFeignClients(basePackages = "com.heima.apis")
@EnableAsync  //开启异步调用
public class WemediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WemediaApplication.class,args);
    }


    /**
     * 这段代码是在Spring项目中注册Mybatis-Plus拦截器的一个示例。
     *
     * Mybatis-Plus是一个优秀的Mybatis增强工具，其内置了许多常用的功能，例如分页、性能分析、逻辑删除等。
     *
     * MybatisPlusInterceptor是Mybatis-Plus提供的拦截器，它允许在Mybatis执行SQL时拦截和修改执行过程
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        /**
         * 这段代码注册了一个内部拦截器PaginationInnerInterceptor，它主要用于实现分页功能，
         *
         * DbType.MYSQL表示使用MySQL数据库。
         *
         * 创建MybatisPlusInterceptor对象之后，将PaginationInnerInterceptor添加到它内部的拦截器列表中，并返回MybatisPlusInterceptor对象。
         */
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }


}
