package application.repositories.database;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IDatabase {
    public void connect() ;

    public void disconnect() ;

    public ResultSet execute(String query);
    public Statement update(String query);
}
