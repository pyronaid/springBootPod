package it.pyronaid.customSpringBootApp.Jpa;

import it.pyronaid.customSpringBootApp.Dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserDto, Long> {
    @Query("{username:'?0'}")
    UserDto findByUsername(String username);

    @Query("{email:'?0'}")
    UserDto findByMail(String email);

    public long count();
}
