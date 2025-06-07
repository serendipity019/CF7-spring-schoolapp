package gr.aueb.cf.schoolapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "teachers")
public class TeacherEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(name =" is_active")
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL) // If something deleted from teacher must delete and from personal info
    @JoinColumn(name = "personal_info_id")
    private PersonalInfoEntity personalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
