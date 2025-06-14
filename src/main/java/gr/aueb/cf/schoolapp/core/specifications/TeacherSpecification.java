package gr.aueb.cf.schoolapp.core.specifications;

import gr.aueb.cf.schoolapp.model.PersonalInfoEntity;
import gr.aueb.cf.schoolapp.model.TeacherEntity;
import gr.aueb.cf.schoolapp.model.UserEntity;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class TeacherSpecification {
    private TeacherSpecification() {}

    public static Specification<TeacherEntity> teacherUserAfmIs(String afm) {
        return ((root, query, criteriaBuilder) -> {
            if (afm == null || afm.isBlank()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            Join<TeacherEntity, UserEntity> user = root.join("user");
            return criteriaBuilder.equal(user.get("afm"), afm);
        });
    }

    public static Specification<TeacherEntity> teacherIsActive(Boolean isActive) {
        return ((root, query, criteriaBuilder) -> {
          if (isActive == null) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
          Join<TeacherEntity, UserEntity> user = root.join("user");
            return criteriaBuilder.equal(user.get("isActive"), isActive);
        });
    }

    public static Specification<TeacherEntity> teacherPersonalInfoAmkaIs(String amka) {
        return ((root, query, criteriaBuilder) -> {
            if (amka == null || amka.isBlank()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            Join<TeacherEntity, PersonalInfoEntity> personalInfo = root.join("personalInfo");
            return criteriaBuilder.equal(personalInfo.get("amka"), amka);
        });
    }

    public static Specification<TeacherEntity> teacherStringFieldLike(String field, String value) {
        return ((root, query, criteriaBuilder) -> {
            if (value == null || value.trim().isEmpty()) return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            return criteriaBuilder.like(criteriaBuilder.upper(root.get(field)), "%" + value.toUpperCase() + "%");
        });
    }
}


