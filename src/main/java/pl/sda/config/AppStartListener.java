package pl.sda.config;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DbUtil.getConnection();
        System.out.println("==========>connection with db has been initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DbUtil.closeConnection();
        System.out.println("==========>connection with db has been closed");

    }
}
