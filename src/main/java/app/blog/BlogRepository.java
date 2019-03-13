package app.blog;

import app.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "blog", path = "blog")
public interface BlogRepository extends MongoRepository<Blog, String> {

    List<User> findByTitle(@Param("title") String title);

}
