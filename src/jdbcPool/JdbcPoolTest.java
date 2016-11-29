package jdbcPool;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

public class JdbcPoolTest {
    
    JdbcPool pool = DBManager.getInstance();
    
    @Before
    public void before() {
        pool.init();
    }
    
    @Test
    public void select() throws Exception {
        
        PooledConnection conn = pool.getConnection();
        
        ResultSet rs = conn.queryBySql("select * from consult_contract");
        
        System.out.println("线程名：" + Thread.currentThread().getName());
        if (rs.next()) {
            System.out.print(rs.getString("PSPTID") + "\t");
            System.out.print(rs.getString("CONTRACT_CODE") + "\t");
            System.out.print(rs.getString("ACTIVETIME") + "\t\n");
        }
        
        rs.close();
        conn.close();
        
    }
    
    @Test
    public void threadTest() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        select();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
