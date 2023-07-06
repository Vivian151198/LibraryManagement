package application.repositories;

import application.models.document.Book;
import application.models.document.CD;
import application.models.document.Document;
import application.models.document.DocumentType;
import io.github.thibaultmeyer.cuid.CUID;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
