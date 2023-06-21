package org.example;

import java.util.List;

public interface IDatabase {
    public void connect();

    public void close();

    public List<Document> queryDocuments();

    public List<User> queryUsers();

    public void writeDocumentIntoDB(Document document);
}
