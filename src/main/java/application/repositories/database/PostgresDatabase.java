package application.repositories.database;

import java.sql.*;

public class PostgresDatabase implements IDatabase {

    private final String jdbcUrl;
    private final String username;
    private final String password;
    private Connection connection;

    public PostgresDatabase(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public void connect() {
        try {
            this.connection = DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
        }
    }

    @Override
    public void disconnect() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("Couldn't close database connection");
            }
        }
    }

    @Override
    public ResultSet execute(String query) {
        try {
            this.connect();
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            return null;
        }
    }
}
