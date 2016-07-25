package org.michaelliu.demo.java.mysql;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 7/25/16.
 */
public class DataBasePoolExample {

    private static Log log = LogFactory.getLog(DataBasePoolExample.class);

    public BasicDataSource initDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxWait(5000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(3000);
        return dataSource;
    }

    private static AtomicLong numOfLineUpdated = new AtomicLong(0);
    private static AtomicLong finishedSize = new AtomicLong(0);

    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource = new DataBasePoolExample().initDataSource();
        Connection connection = dataSource.getConnection();
        int poolSize = 1000;
        int threadSize = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        for (int i = 0; i < threadSize; i++) {
            SQLThread thread = new SQLThread(connection);
            final ListenableFuture<Integer> listenableFuture = executorService.submit(thread);
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    Integer result = null;
                    try {
                        result = listenableFuture.get();
                        log.info("Thread returns result: " + result);
                        if (result > 0) {
                            numOfLineUpdated.incrementAndGet();
                        }
                    } catch (Exception e) {
                        log.error(e);
                    } finally {
                        if (listenableFuture.isDone()) {
                            finishedSize.incrementAndGet();
                        }
                    }
                }
            }, executorService);
        }
        while (finishedSize.get() != threadSize) {}
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        dataSource.close();
        log.info("Number of line updated: " + numOfLineUpdated.get());
    }

}
