package app.blog;

import app.user.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InlineUser", types = { User.class })
interface InlineUser {
    String get_id();

    String getTitle();

    String getSubTitle();

    String getSummary();

    String getCreatedTime();

    String getUpdatedTime();

    String getCreatedBy();

    String getUpdatedBy();

    String getAuthor();

    User getUser();
}
