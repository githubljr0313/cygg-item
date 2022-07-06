package io.cygg.item.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import(value = {MybatisPlusConfiguration.class})
public class CyggItemConfiguration {


}
