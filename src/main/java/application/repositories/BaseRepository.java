package application.repositories;

import application.repositories.database.IDatabase;
import application.repositories.database.PostgresDatabase;

public abstract class BaseRepository {
    protected IDatabase database;

    BaseRepository() {
        database = new PostgresDatabase("jdbc:postgresql://localhost:5432/library",
                "postgres",
                "7432");
    }
}
