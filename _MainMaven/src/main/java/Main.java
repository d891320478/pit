import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws Exception {
        String sql = "select * from t_baas_ops_log where id = 2;";
        DataSource ds = getds();
        Statement stat = ds.getConnection().createStatement();
        stat.setQueryTimeout(60);
        stat.setMaxRows(200);
        ResultSet rlt = stat.executeQuery(sql);
        ResultSetMetaData meta = rlt.getMetaData();

        List<List<String>> list = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        for (int i = 1; i <= meta.getColumnCount(); ++i) {
            columns.add(meta.getColumnName(i));
        }
        list.add(columns);

        while (rlt.next()) {
            List<String> row = new ArrayList<>();
            for (String iter : columns) {
                row.add(rlt.getString(iter));
            }
            list.add(row);
        }
        System.out.println(list);
    }

    private static DataSource getds() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("shinemo123");
        dataSource.setUrl(
                "jdbc:mysql://10.0.10.41:3306/shinemo_im?autoReconnect=true&amp;failOverReadOnly=false&amp;maxReconnects=10&amp;characterEncoding=UTF8&amp;allowMultiQueries=true");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dataSource;
    }
}