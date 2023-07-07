package application.repositories;

import application.models.document.Author;
import io.github.thibaultmeyer.cuid.CUID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository extends BaseRepository {

    public List<Author> getAllAuthor() {
        List<Author> authorList = new ArrayList<>();
        String query = "select * from \"Author\"";
        ResultSet resultSet = this.database.execute(query);
        try {
            while (resultSet.next()) {
                CUID id = CUID.fromString(resultSet.getString("authorId"));
                String name = resultSet.getString("name");
                Author author = new Author(id, name);
                authorList.add(author);
            }
            this.database.disconnect();
            resultSet.close();

            return authorList;

        } catch (SQLException e) {
            System.out.println("Find the author error!");
        }
        return authorList;
    }
}
