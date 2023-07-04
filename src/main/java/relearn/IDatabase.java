package relearn;

import javax.print.Doc;
import java.util.List;

public interface IDatabase {
    public void connect ();
    public void close ();

    public List<Document> queryDocument();
    public void writeDocumentIntoDatabase(Document document);

    public List<User> queryUsers();

    public void writeUserBorrowBookIntoDatabase(User user, Document document);

}
