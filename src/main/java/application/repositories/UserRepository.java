package application.repositories;

import application.models.user.Admin;
import application.models.user.Reader;
import application.models.user.Role;
import application.models.user.User;
import io.github.thibaultmeyer.cuid.CUID;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends BaseRepository {
    public User findOneById(String userId) {
        String query = String.format("SELECT id, \"name\", \"idCardNumber\", \"role\" FROM public.\"User\" WHERE id='%s';", userId);
        ResultSet resultSet = this.database.execute(query);
        try {
            resultSet.next();
            CUID id = CUID.fromString(resultSet.getString("id"));
            String userName = resultSet.getString("name");
            Role role = Role.valueOf(resultSet.getString("role"));
            resultSet.close();
            this.database.disconnect();
            if (role == Role.ADMIN) {
                return new Admin(id, userName);
            }
            if (role == Role.READER) {
                return new Reader(id, userName);
            }
        } catch (SQLException e) {
            System.out.println("Find user error");
        }
        return null;
    }
}
