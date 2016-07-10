package org.mliuframework.demo.thread;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by root on 16-6-11.
 */
public class RunSQLApp {

    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setInitialSize(100);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(200);
        dataSource.setMaxWaitMillis(5000);
        dataSource.setMaxTotal(400);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 2000; i++) {
            executorService.execute(new SQLThread(dataSource));
        }
        executorService.shutdown();
        dataSource.close();
    }


}
