package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {

    final static Logger LOG = LoggerFactory.getLogger("app");

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IAppService appService = ctx.getBean(AppService.class);
        LOG.info(appService.greet("Sönke"));
    }
}
