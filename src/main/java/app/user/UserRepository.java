package app.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * same as:
     *
     * @Query(value = "{}", count = true)
     * long countAll();
     *
     */
    @CountQuery(value = "{}")
    long countAll();

    /**
     * same as:
     *
     * @Query(value = "{countryId: ?0}", count = true)
     * long countUserByCountryId(@Param("countryId") int countryId);
     *
     */
    long countByCountryId(@Param("countryId") int countryId);

    /**
     * same as
     *
     * @Query(value = "{'countryId' : ?0 }", exists = true)
     * boolean findExistsUserByCountryId(@Param("countryId") int countryId);
     *
     */
    @ExistsQuery(value = "{'countryId' : ?0 }")
    boolean findExistsUserByCountryId(@Param("countryId") int countryId);

    Page<User> findByNickname(@Param("nickname") String nickname, Pageable pageable);

    Page<User> findByCountryId(@Param("countryId") int countryId, Pageable pageable);

    Page<User> findByLastName(@Param("lastName") String lastName, Pageable pageable);

    @Query(value = "{'firstName': ?0, 'lastName' : ?1}")
    Page<User> findByFullNames(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable
    );

    Page<User> findByFirstNameAndLastName(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable
    );

    Page<User> findByFirstNameOrLastName(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable
    );

    @Query(value = "{$or: [{'firstName' : ?0 } , {'lastName' : ?1 }]}")
    Page<User> findByNames(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable
    );

    Page<User> findByNicknameLike(@Param("nickname") String nickname, Pageable pageable);

    @RestResource(path = "firstNameLike", rel = "firstNameLike")
    Page<User> findByFirstNameLike(@Param("firstName") String firstName, Pageable pageable);
}
