package yjy.spring.boot.samples.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjy.spring.boot.samples.autoconfigure.formatter.Formatter;
import yjy.spring.boot.samples.autoconfigure.formatter.impl.DefaultFormatter;

@Configuration
public class FormatterAutoConfiguration {

    @Bean
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }
}
