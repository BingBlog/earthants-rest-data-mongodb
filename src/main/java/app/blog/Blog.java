package app.blog;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Blog {

    @Id private ObjectId id;

    @NotNull
    @Size(min=2, max=100)
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
    private int userId;

}
