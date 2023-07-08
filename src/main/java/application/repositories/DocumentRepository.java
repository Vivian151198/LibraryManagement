package application.repositories;

import application.models.base.CUID;
import application.models.document.Book;
import application.models.document.CD;
import application.models.document.Document;
import application.models.document.DocumentType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepository extends BaseRepository {

    public Document findOneDocumentByName(String name) {

        String query = String.format("SELECT id, \"name\", \"type\", \"publishedAt\", quantity FROM \"Document\" WHERE name='%s'", name);
        ResultSet resultSet = this.database.execute(query);
        try {
            if (!resultSet.next()) {
                return null;
            }

            CUID id = CUID.fromString(resultSet.getString("id"));
            DocumentType type = DocumentType.valueOf(resultSet.getString("type"));
            String _name = resultSet.getString("name");
            String publishedAt = resultSet.getString("publishedAt");
            int quantity = resultSet.getInt("quantity");

            this.database.disconnect();
            resultSet.close();
            if (type == DocumentType.BOOK) {
                return new Book(id, _name, publishedAt, quantity);
            }
            if (type == DocumentType.CD) {
                return new CD(id, _name, publishedAt, quantity);
            }
        } catch (SQLException e) {
            System.out.println("Find document error!");
        }
        return null;
    }

    public List<Document> findListDocumentByKeyword(String keyword) {
        List<Document> documentList = new ArrayList<>();
        String query =
                "SELECT id, \"name\", \"type\", \"publishedAt\", quantity FROM \"Document\""
                +"WHERE name like " + "'%" + keyword + "%'";
        ResultSet resultSet = this.database.execute(query);
        try {
            while (resultSet.next()) {
                CUID id = CUID.fromString(resultSet.getString("id"));
                DocumentType type = DocumentType.valueOf(resultSet.getString("type"));
                String _name = resultSet.getString("name");
                String publishedAt = resultSet.getString("publishedAt");
                int quantity = resultSet.getInt("quantity");

                if (type == DocumentType.BOOK) {
                    Document book = new Book(id, _name, publishedAt, quantity);
                    documentList.add(book);
                }
                if (type == DocumentType.CD) {
                    Document cd = new CD(id, _name, publishedAt, quantity);
                    documentList.add(cd);
                }
            }
            this.database.disconnect();;
            resultSet.close();
            return documentList;
        } catch (SQLException e) {
            System.out.println("Find the list document error!");
        }
        return documentList;
    }

    public List<Book> getAllBook(){
        List<Book> bookList = new ArrayList<>();
        String query = "select * from \"Document\"";
        ResultSet resultSet = this.database.execute(query);
        try {
            while (resultSet.next()) {
                CUID id = CUID.fromString(resultSet.getString("id"));
                DocumentType type = DocumentType.valueOf(resultSet.getString("type"));
                String _name = resultSet.getString("name");
                String publishedAt = resultSet.getString("publishedAt");
                int quantity = resultSet.getInt("quantity");

                if (type == DocumentType.BOOK) {
                    Document book = new Book(id, _name, publishedAt, quantity);
                    bookList.add((Book) book);
                }
            }
            this.database.disconnect();;
            resultSet.close();
            return bookList;
        } catch (SQLException e) {
            System.out.println("Find the list book error!");
        }
        return bookList;
    }

    public List<CD> getAllCD(){
        List<CD> cdList = new ArrayList<>();
        String query = "select * from \"Document\"";
        ResultSet resultSet = this.database.execute(query);
        try {
            while (resultSet.next()) {
                CUID id = CUID.fromString(resultSet.getString("id"));
                DocumentType type = DocumentType.valueOf(resultSet.getString("type"));
                String _name = resultSet.getString("name");
                String publishedAt = resultSet.getString("publishedAt");
                int quantity = resultSet.getInt("quantity");

                if (type == DocumentType.CD) {
                    Document cd = new CD(id, _name, publishedAt, quantity);
                    cdList.add((CD) cd);
                }
            }
            this.database.disconnect();;
            resultSet.close();  // Have "BOM" so using try catch
            return cdList;
        } catch (SQLException e) {
            System.out.println("Find the list cd error!");
        }
        return cdList;
    }

    public Document addDocument(Document document){
        String query = "INSERT INTO public.\"Document\" (\"id\", \"name\", \"type\",\"publishedAt\", \"quantity\") VALUES('"+document.getId()+"','"+document.getName()+"','"+document.getType()+"','"+document.getPublishedAt()+"','"+document.getQuantity()+"')";
        try{
            Statement statement = this.database.update(query);
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return document;
    }
}
