package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>,
        JpaSpecificationExecutor<TeacherEntity> {
    Optional<TeacherEntity> findByUserId(Long id);
    Optional<TeacherEntity> findByUuid(String uuid);
}
