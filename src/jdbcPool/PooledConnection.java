package jdbcPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PooledConnection {
    
    private Connection conn = null;
    
    private boolean isBusy = false;
    
    public PooledConnection(Connection conn, boolean isBusy) {
        this.conn = conn;
        this.isBusy = isBusy;
    }
    
    public ResultSet queryBySql(String sql) {
        
        Statement sm = null;
        ResultSet rs = null;
        
        try {
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int updateBySql(String sql) {
        Statement sm = null;
        int count = -1;
        try {
            sm = conn.createStatement();
            count = sm.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public boolean isBusy() {
        return isBusy;
    }
    
    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
    
    public void close() {
        isBusy = false;
    }
    
}
