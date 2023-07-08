package application.models.document;

public record DocumentResponse(String id, String name, DocumentType type, String publishedAt, int quantity) {
}
