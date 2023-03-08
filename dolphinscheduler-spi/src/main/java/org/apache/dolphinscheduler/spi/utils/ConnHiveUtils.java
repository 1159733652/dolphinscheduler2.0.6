package org.apache.dolphinscheduler.spi.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnHiveUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConnHiveUtils.class);

    // 连接hive库
    public static Connection hiveConnection(String url, String user, String password){
        try {
            Class.forName(Constants.ORG_APACHE_HIVE_JDBC_HIVE_DRIVER);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e1){
            logger.error("ClassNotFoundException:"+e1);
        } catch (SQLException e2){
            logger.error("SQLException"+e2);
        }
        return null;
    }
}
