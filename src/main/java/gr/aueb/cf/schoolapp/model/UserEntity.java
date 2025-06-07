package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.core.enums.GenderType;
import gr.aueb.cf.schoolapp.core.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class UserEntity extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true)
    private String vat;

    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "father_lastname")
    private String fatherLastname;
    @Column(name = "mother_lastname")
    private String motherLastname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "user")
    private TeacherEntity teacher;

    @OneToOne(mappedBy = "user")
    private EmployeeEntity employee;

    @Column(name= "is_teacher")
    public boolean isTeacher() {
        return getTeacher() != null;
    }

    @Column(name = "is_employee")
    public boolean isEmployee() {
        return getEmployee() != null;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
