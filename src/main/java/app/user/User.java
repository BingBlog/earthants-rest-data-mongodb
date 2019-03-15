package app.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document(collection = "user")
public class User {
    @Id private String _id;

    @NotNull
    @Size(min=2, max=30)
    private String nickname;

    @Size(min=2, max=30)
    private String lastName;

    @Size(min=2, max=30)
    private String firstName;

    private String avatar;

    @NotNull
    private String phone;

    private int countryId;

    @NotNull
    private String createdTime;

    @NotNull
    private String updatedTime;

    @NotNull
    private String email;

}
