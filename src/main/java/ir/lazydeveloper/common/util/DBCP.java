//package ir.lazydeveloper.common.util;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class DBCP {
//    private static final BasicDataSource basicDataSource = new BasicDataSource();
//    private static final PropertyUtil propertyUtil = new PropertyUtil("app.properties");
//    static {
////        basicDataSource.setUrl(propertyUtil.getValue("datasource.url"));
//        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
//        basicDataSource.setUsername(propertyUtil.getValue("datasource.username"));
//        basicDataSource.setPassword(propertyUtil.getValue("datasource.password"));
//        basicDataSource.setMinIdle(Integer.parseInt(propertyUtil.getValue("datasource.minIdle")));
//        basicDataSource.setMaxIdle(Integer.parseInt(propertyUtil.getValue("datasource.maxIdle")));
//        basicDataSource.setMaxOpenPreparedStatements(100);
////        basicDataSource.setDefaultAutoCommit(false);
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return basicDataSource.getConnection();
//    }
//}
