package net.movill.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@EnableAsync
@ComponentScan("net.movill")
@SpringBootApplication
public class MovillErpApiApplication {

    @Bean
    Scheduler jdbcScheduler() {
        return Schedulers.newElastic("jdbc.pool");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovillErpApiApplication.class, args);
    }

}
