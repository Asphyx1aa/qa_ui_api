package models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddBookToProfileRequest {
    String userId, isbn;
}
