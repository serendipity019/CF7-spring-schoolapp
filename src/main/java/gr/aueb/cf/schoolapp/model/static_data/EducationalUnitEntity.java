package gr.aueb.cf.schoolapp.model.static_data;

import gr.aueb.cf.schoolapp.model.EmployeeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educational_units")
public class EducationalUnitEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    @ManyToMany(mappedBy = "eduUnits" )
    private Set<EmployeeEntity> employees = new HashSet<>();

}
