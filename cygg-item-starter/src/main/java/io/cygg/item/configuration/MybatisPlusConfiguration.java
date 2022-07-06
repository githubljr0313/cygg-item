package io.cygg.item.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration(proxyBeanMethods = false)
@MapperScan(basePackages = "io.cygg.item.mapper")
public class MybatisPlusConfiguration {


    /**
     * mybatis-plus插件配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());// 乐观锁插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));// 分页插件
        return interceptor;
    }

    /**
     * mybatis-plus insert/update默认填充配置
     * @return
     */
    @Bean
    public MetaObjectHandler cyggItemMetaObjectHandler(){
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                strictFillStrategy(metaObject, "createdAt", Date::new);
                strictFillStrategy(metaObject, "updatedAt", Date::new);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                strictFillStrategy(metaObject, "updatedAt", Date::new);
            }
        };
    }

}
