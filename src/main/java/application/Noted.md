
#
- User have 2 roles: admin and reader
- All user need to log in by id that is CUID
  - Admin(): addBook(), removeBook(), addUserIntoBorrowBookList(), addUser(), removeUser(), updatedReturnBook(). \
// Replace Book -> Document
  - User: borrowDocument(), searchDocument(document.name, author.name)
  - Document(): Book() && CD()
    - id
    - name
    - author()
      - id
      - name
    - publishedAt
    - quantity
  