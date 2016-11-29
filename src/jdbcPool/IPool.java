package jdbcPool;


public interface IPool {
    
    PooledConnection getConnection();
    
    void createConnections(int count);
}
