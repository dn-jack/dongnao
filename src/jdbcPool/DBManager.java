package jdbcPool;

public class DBManager {
    
    private static class CreatePool {
        private static JdbcPool pool = new JdbcPool();
    }
    
    public static JdbcPool getInstance() {
        return CreatePool.pool;
    }
    
}
