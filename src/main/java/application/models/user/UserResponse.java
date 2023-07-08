package application.models.user;

public record UserResponse(String status, String error, UserData data) {

}
