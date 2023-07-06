CREATE TABLE "Document" (
  "id" text PRIMARY KEY NOT NULL,
  "name" text NOT NULL,
  "type" text NOT NULL,
  "publishedAt" timestamp NOT NULL,
  "quantity" int NOT NULL
);

CREATE TABLE "User" (
  "id" text PRIMARY KEY NOT NULL,
  "name" text NOT NULL,
  "idCardNumber" text NOT NULL,
  "role" text NOT NULL
);

CREATE TABLE "UserBorrowDocument" (
  "userId" text NOT NULL,
  "documentId" text NOT NULL,
  "borrowedAt" timestamp NOT NULL,
  "quantity" int NOT NULL,
  "returnedAt" timestamp
);

CREATE TABLE "Author" (
  "authorId" text PRIMARY KEY NOT NULL,
  "name" text NOT NULL
);

CREATE TABLE "AuthorDocument" (
  "documentId" text NOT NULL,
  "authorId" text NOT NULL
);

ALTER TABLE "UserBorrowDocument" ADD FOREIGN KEY ("userId") REFERENCES "User" ("id");

ALTER TABLE "UserBorrowDocument" ADD FOREIGN KEY ("documentId") REFERENCES "Document" ("id");

ALTER TABLE "AuthorDocument" ADD FOREIGN KEY ("documentId") REFERENCES "Document" ("id");

ALTER TABLE "AuthorDocument" ADD FOREIGN KEY ("authorId") REFERENCES "Author" ("authorId");
