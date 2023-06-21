package org.example;

import java.util.List;

public class LibraryManagement {
    private IDatabase database;

    LibraryManagement() {

    }

    public void initBookData(){
        List<Document> documentList = database.queryDocuments();
        for (Document document : documentList) {
            System.out.println(document.toString());
        }
    }
    public void start() {
        this.initDatabaseConnection();
        initBookData();
    }

    private void initDatabaseConnection() {
        this.database = new PostgresDatabase(
                "jdbc:postgresql://localhost:5432/librarymanagement",
                "postgres",
                "7432"
        );
    }
}
