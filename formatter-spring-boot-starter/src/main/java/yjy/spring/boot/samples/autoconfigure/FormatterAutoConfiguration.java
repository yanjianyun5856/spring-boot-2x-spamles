package yjy.spring.boot.samples.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjy.spring.boot.samples.autoconfigure.formatter.Formatter;
import yjy.spring.boot.samples.autoconfigure.formatter.impl.DefaultFormatter;
import yjy.spring.boot.samples.autoconfigure.formatter.impl.JsonFormatter;

@Configuration
@ConditionalOnProperty(prefix = "formatter" ,name = "enabled", havingValue = "true",
        matchIfMissing=true)//当属性配置不存在时，同样视作匹配
public class FormatterAutoConfiguration {

    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jsonFormatter(){
        return new JsonFormatter();
    }

    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter onjectMapperFormatter(ObjectMapper objectMapper){
        return new JsonFormatter(objectMapper);
    }

}
