package ir.lazydeveloper.common;

import ir.lazydeveloper.common.util.FileUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ConfigListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {

//        List<String> lines = new ArrayList<>();
//        try {
//            URI path = this.getClass().getClassLoader().getResource("/sql-script").toURI();
//            List<File> listOfFiles = FileUtil.getListOfFiles(path.getPath());
//            for (File file : listOfFiles) {
//                BufferedReader bufferedReader = new BufferedReader(
//                        new InputStreamReader(new FileInputStream(file), "UTF-8"));
//                while (bufferedReader.readLine() != null) {
//                    String line = bufferedReader.readLine();
//                    lines.add(line);
//                }
//                test(lines);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void test(List<String> sql) {
        EntityManager entityManager = ORMConfig.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        for (String s : sql) {
            transaction.begin();
//            Query nativeQuery = entityManager.createNativeQuery(s);
            Query nativeQuery = entityManager.createNativeQuery(s.replace(";", ""));
            nativeQuery.executeUpdate();
            transaction.commit();
        }
        transaction.commit();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
