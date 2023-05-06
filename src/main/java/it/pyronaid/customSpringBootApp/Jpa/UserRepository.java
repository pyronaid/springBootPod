package it.pyronaid.customSpringBootApp.Jpa;

import it.pyronaid.customSpringBootApp.Dto.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDto, Long> {
    UserDto findByUsername(String username);
}
