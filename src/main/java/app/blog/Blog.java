package app.blog;

import app.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document(collection = "blog")
public class Blog {

    @Id private String _id;

    @TextIndexed
    @Size(min=2, max=100)
    @NotNull
    private String title;

    @Size(min=2, max=100)
    private String subTitle;

    @Size(min=2, max=500)
    private String summary;

    @NotNull
    private String createdTime;

    @NotNull
    private String updatedTime;

    @NotNull
    private String createdBy;

    @NotNull
    private String updatedBy;

    @Indexed
    @NotNull
    private String author;

    @NotNull
    private String content;

    @DBRef
    private User user;
}
