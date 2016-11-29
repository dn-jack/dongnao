package jdbcPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class JdbcPool implements IPool {
    
    private static String jdbcDriver = "";
    
    private static String dbUrl = "";
    
    private static String dbUsername = "";
    
    private static String dbPassword = "";
    
    private static int initConnCount;
    
    private static int maxConnnects;
    
    private static int incrementalcount;
    
    private static Vector<PooledConnection> vector = new Vector<PooledConnection>();
    
    public void init() {
        InputStream in = JdbcPool.class.getClassLoader()
                .getResourceAsStream("jdbcPool/jdbc.properties");
        
        Properties pt = new Properties();
        
        try {
            pt.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        jdbcDriver = pt.getProperty("jdbcDriver");
        dbUrl = pt.getProperty("dbUrl");
        dbUsername = pt.getProperty("dbUsername");
        dbPassword = pt.getProperty("dbPassword");
        initConnCount = Integer.valueOf(pt.getProperty("initConnCount"));
        maxConnnects = Integer.valueOf(pt.getProperty("maxConnnects"));
        incrementalcount = Integer.valueOf(pt.getProperty("incrementalcount"));
        
        try {
            Driver driver = (Driver)(Class.forName(jdbcDriver).newInstance());
            DriverManager.registerDriver(driver);
            
            //我们要创建数据库的连接，然后把连接放到vector里面
            createConnections(initConnCount);
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public synchronized PooledConnection getConnection() {
        
        if (vector.size() <= 0) {
            System.out.println("连接池中还没有连接！");
            throw new RuntimeException("连接池中还没有连接！");
        }
        
        PooledConnection conn = getActiveConnection();
        
        //等于null的情况就是连接池中的连接全部为忙碌的情况
        if (conn == null) {
            
            //  这时候就需要对连接池进行增长
            createConnections(incrementalcount);
            
            conn = getActiveConnection();
            
            while (conn == null) {
                try {
                    Thread.sleep(300);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                conn = getActiveConnection();
            }
            
        }
        
        return conn;
    }
    
    //我们从池中拿连接
    private PooledConnection getActiveConnection() {
        
        for (PooledConnection conn : vector) {
            if (!conn.isBusy()) {
                Connection trueconn = conn.getConn();
                
                try {
                    if (!trueconn.isValid(0)) {
                        
                        Connection newconn = DriverManager.getConnection(dbUrl,
                                dbUsername,
                                dbPassword);
                        
                        conn.setConn(newconn);
                    }
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                
                conn.setBusy(true);
                return conn;
            }
        }
        
        return null;
    }
    
    public void createConnections(int count) {
        for (int i = 0; i < count; i++) {
            //我们创建连接的时候，必须要判断这个池中的连接要小于我们的最大连接
            if (maxConnnects > 0 && vector.size() >= maxConnnects) {
                System.out.println("连接池中的连接数量已经达到了最大值！");
                throw new RuntimeException("连接池中的连接数量已经达到了最大值！");
            }
            
            try {
                Connection conn = DriverManager.getConnection(dbUrl,
                        dbUsername,
                        dbPassword);
                
                vector.add(new PooledConnection(conn, false));
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }
    
}
