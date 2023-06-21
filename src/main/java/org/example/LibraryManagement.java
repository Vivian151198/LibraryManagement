package org.example;

import java.util.List;

public class LibraryManagement {
    private IDatabase database;

    LibraryManagement() {

    }

    public void initUsersData(){
        List<User> userList = database.queryUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
    public void initDocumentsData(){
        List<Document> documentList = database.queryDocuments();
        for (Document document : documentList) {
            System.out.println(document.toString());
        }
    }
    public void start() {
        this.initDatabaseConnection();
        initDocumentsData();
        initUsersData();
    }

    private void initDatabaseConnection() {
        this.database = new PostgresDatabase(
                "jdbc:postgresql://localhost:5432/librarymanagement",
                "postgres",
                "7432"
        );
    }
}
