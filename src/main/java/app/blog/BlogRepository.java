package app.blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(collectionResourceRel = "blog", path = "blog", excerptProjection = InlineUser.class)
public interface BlogRepository extends MongoRepository<Blog, String> {
    @Override
    @RestResource(exported = false)
    void delete(Blog blog);

    @Override
    @RestResource(exported = false)
    Blog save(Blog blog);

    @CountQuery(value = "{}")
    long countAll();

    Page<Blog> findByTitleLikeIgnoreCase(@Param("title") String title, Pageable pageable);

    Page<Blog> findByCreatedBy(@Param("createdBy") String createdBy, Pageable pageable);

    Page<Blog> findByAuthorIgnoreCase(@Param("author") String author, Pageable pageable);

}
