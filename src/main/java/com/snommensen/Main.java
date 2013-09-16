package com.snommensen;

import com.snommensen.domain.User;
import com.snommensen.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    final static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppService appService = context.getBean(AppService.class);

        User user = User.make("Sönke", "Nommensen", "soenke.nommensen@draeger.com");

        User savedUser = appService.save(user);
        LOG.info("Saved user = " + savedUser.toString());
    }
}
