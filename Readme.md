Chương trình quản lý tài liệu và sách cho một thư viện, 
ngoài ra chương trình có thể quản lý việc cho mượn sách và tai lieu (CD)
- Book(): ID, name, author, published at, quantity
    addBook(), deleteBook(), updateBook(time hh:pp:ss, dd/mm/yyyy)
- CD(): ID, name, author, published at, quantity.
    //method as the same book.

BorrowBook():
- Must have account library if user want to go the library (Name, CMND)
  - BorrowBook(): userID, name of book.
Chương trình có lưu trữ sách ở một database (Postgres)