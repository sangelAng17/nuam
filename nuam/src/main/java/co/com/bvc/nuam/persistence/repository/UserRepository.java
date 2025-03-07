package co.com.bvc.nuam.persistence.repository;

import co.com.bvc.nuam.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findAllById(Long id);
}
