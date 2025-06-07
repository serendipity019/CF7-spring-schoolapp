package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.*;
import gr.aueb.cf.schoolapp.model.PersonalInfoEntity;
import gr.aueb.cf.schoolapp.model.TeacherEntity;
import gr.aueb.cf.schoolapp.model.UserEntity;
import gr.aueb.cf.schoolapp.model.TeacherEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final PasswordEncoder passwordEncoder;

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(TeacherEntity teacher) {
        // Map User to UserReadOnlyDTO
        UserReadOnlyDTO userDTO = new UserReadOnlyDTO(teacher.getUser().getFirstname(),
                teacher.getUser().getLastname(), teacher.getUser().getVat());
//        userDTO.firstname(teacher.user().firstname());
//        userDTO.lastname(teacher.getUser().getLastname());
//        userDTO.vat(teacher.getUser().getVat());
//        dto.setUser(userDTO);

        // Map PersonalInfo to PersonalInfoReadOnlyDTO
        PersonalInfoReadOnlyDTO personalInfoDTO = new PersonalInfoReadOnlyDTO(teacher.getPersonalInfo().getAmka(),
                teacher.getPersonalInfo().getIdentityNumber());
//        personalInfoDTO.setAmka(teacher.getPersonalInfo().getAmka());
//        personalInfoDTO.setIdentityNumber(teacher.getPersonalInfo().getIdentityNumber());
//        dto.setPersonalInfo(personalInfoDTO);

        TeacherReadOnlyDTO teacherReadOnlyDTO = new TeacherReadOnlyDTO(teacher.getId(), teacher.getUuid(),
                teacher.getIsActive(), userDTO, personalInfoDTO);

//        dto.Id(teacher.getId());
//        dto.setUuid(teacher.getUuid());
//        dto.setIsActive(teacher.getIsActive());

        return teacherReadOnlyDTO;
    }


    public TeacherEntity mapToTeacherEntity(TeacherInsertDTO dto) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setIsActive(dto.isActive());

        // Map fields from UserDTO
        UserInsertDTO userDTO = dto.user(); // Extract user dto
        UserEntity user = new UserEntity();
        user.setFirstname(userDTO.firstname());
        user.setLastname(userDTO.lastname());
        user.setUsername(userDTO.username());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setVat(userDTO.vat());
        user.setFatherName(userDTO.fatherName());
        user.setFatherLastname(userDTO.fatherLastname());
        user.setMotherName(userDTO.motherName());
        user.setMotherLastname(userDTO.motherLastname());
        user.setDateOfBirth(userDTO.dateOfBirth());
        user.setGender(userDTO.gender());
        user.setRole(userDTO.role());
        user.setIsActive(dto.isActive());
        teacher.setUser(user);  // Set User entity to Teacher

        // Map fields from PersonalInfoDTO
        PersonalInfoInsertDTO personalInfoDTO = dto.personalInfo(); // Extract personal info dto
        PersonalInfoEntity personalInfo = new PersonalInfoEntity();
        personalInfo.setAmka(personalInfoDTO.amka());
        personalInfo.setIdentityNumber(personalInfoDTO.identityNumber());
        personalInfo.setPlaceOfBirth(personalInfoDTO.placeOfBirth());
        personalInfo.setMunicipalityOfRegistration(personalInfoDTO
                .municipalityOfRegistration());
        teacher.setPersonalInfo(personalInfo);  // Set PersonalInfo entity to Teacher

        return teacher;
    }
}
