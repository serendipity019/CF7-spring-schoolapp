package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.model.static_data.EducationalUnitEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany
    @JoinTable(name = "employees_edu_units")
    private Set<EducationalUnitEntity> eduUnits = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public void addEducationalUnit(EducationalUnitEntity educationalUnit) {
        if (eduUnits == null) eduUnits = new HashSet<>();
        eduUnits.add(educationalUnit);
        educationalUnit.getEmployees().add(this);
    }

    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
