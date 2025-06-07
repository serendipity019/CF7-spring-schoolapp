package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.PersonalInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfoEntity, Long>,
        JpaSpecificationExecutor<PersonalInfoEntity> {

    Optional<PersonalInfoEntity> findByAmka(String amka);
}
