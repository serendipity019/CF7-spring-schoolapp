package gr.aueb.cf.schoolapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personal_information")
public class PersonalInfoEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String amka;

    @Column(name= "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Column(name= "place_of_birth", nullable = false)
    private String placeOfBirth;

    @Column(name= "municipality_of_registration")
    private String municipalityOfRegistration;

    @OneToOne
    @JoinColumn(name = "amka_file_id")
    private AttachmentEntity amkaFile;
}
