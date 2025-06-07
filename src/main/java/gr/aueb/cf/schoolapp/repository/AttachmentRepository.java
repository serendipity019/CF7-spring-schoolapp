package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.AttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttachmentRepository extends JpaRepository<AttachmentEntity, Long>,
        JpaSpecificationExecutor<AttachmentEntity> {

}
