package org.example;

import java.util.List;

public interface IDatabase {
    public void connect();

    public void close();

    public List<Document> queryDocuments();

    public User queryUserById(String userId);
}
