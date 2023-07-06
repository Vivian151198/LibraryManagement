package application.repositories.database;

import java.sql.ResultSet;

public interface IDatabase {
    public void connect() ;

    public void disconnect() ;

    public ResultSet execute(String query);
}
