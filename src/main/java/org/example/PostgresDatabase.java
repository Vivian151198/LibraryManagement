package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresDatabase implements IDatabase {

        private String jdbcUrl;
        private String username;
        private String password;

        private Connection connection;

    public PostgresDatabase(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void connect() {
        try{
            this.connection = DriverManager.getConnection(this.getJdbcUrl(), this.getUsername(), this.getPassword());
            System.out.println("Connection Successfully!");
        }catch (SQLException e){
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            this.connection.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Document> queryDocuments() {

        this.connect();
        List<Document> documentList = new ArrayList<>();
        String query = "SELECT * FROM \"Document\"";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Document document = new Document();
                document.setId(resultSet.getInt("id"));
                document.setQuantity(resultSet.getInt("quantity"));
                document.setName(resultSet.getString("name"));
                document.setType(resultSet.getString("type"));
                document.setAuthor(resultSet.getString("author"));
                document.setPublishedAt(resultSet.getString("publishedAt"));
                documentList.add(document);
            }
            resultSet.close();
            statement.close();
            this.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return documentList;
    }

    @Override
    public User queryUserById(String userId) {
        return null;
    }

}
