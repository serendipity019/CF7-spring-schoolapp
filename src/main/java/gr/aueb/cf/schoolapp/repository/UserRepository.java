package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByVat(String vat);
    Optional<UserEntity> findByUsername(String username);
}
