package relearn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresDatabase implements IDatabase {

    Connection connection;
    String jdbcUrl;
    String username;
    String password;

    public PostgresDatabase() {
    }

    public PostgresDatabase(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
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
        try {
            this.connection = DriverManager.getConnection(this.getJdbcUrl(), this.getUsername(), this.getPassword());
            System.out.println("Connected Successful!");
        } catch (SQLException e) {
            System.out.println("Connection error:" + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Document> queryDocument() {
        this.connect();
        List<Document> listDocument = new ArrayList<>();
        String query = "select * from \"Document\"";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Document document = new Document();
                document.setId(resultSet.getInt("id"));
                document.setName(resultSet.getString("name"));
                document.setAuthor(resultSet.getString("author"));
                document.setPublishedAt(resultSet.getString("publishedAt"));
                document.setQuantity(resultSet.getInt("quantity"));
                document.setType(resultSet.getString("type"));
                listDocument.add(document);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDocument;
    }

    @Override
    public void writeDocumentIntoDatabase(Document document) {
        this.connect();
        String query = "INSERT INTO public.\"Document\" (\"name\", \"type\", \"author\", \"publishedAt\", \"quantity\") VALUES('"+document.getName()+"','"+document.getType()+"','"+document.getAuthor()+"','"+document.getPublishedAt()+"','"+document.getQuantity()+"')";
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> queryUsers() {
       List<User> userList = new ArrayList<>();
        this.connect();
        String query = "SELECT * FROM \"User\"";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setIdCardNumber(resultSet.getString("idCardNumber"));
                userList.add(user);
            }

            resultSet.close();
            statement.close();
            this.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void writeUserBorrowBookIntoDatabase(User user, Document document) {
        this.connect();
        String query = "INSERT INTO public.\"UserBorrowDocument\" (\"userId\", \"documentId\", \"borrowedAt\", \"quantity\") VALUES('"+user.getId()+"','"+document.getId()+"','"+"2017-06-22 19:10:25.000"+"','"+document.getQuantity()+"')";
        System.out.println(query);
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
