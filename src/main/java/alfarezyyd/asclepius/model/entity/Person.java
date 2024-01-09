package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.option.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Person {
  @Id
  @Column(name = "person_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long personId;
  @Column(name = "identity_card_number")
  private String identityCardNumber;
  @Column(name = "identity_card_type")
  @Enumerated(EnumType.STRING)
  private IdentityCardType identityCardType;
  @Column(name = "full_name")
  private String fullName;
  private String email;
  @Enumerated(EnumType.STRING)
  private Gender gender;
  @Enumerated(EnumType.STRING)
  private Religion religion;
  @Column(name = "blood_type")
  @Enumerated(EnumType.STRING)
  private BloodType bloodType;
  @Column(name = "birth_place")
  private String birthPlace;
  @Column(name = "birth_date")
  private Date birthDate;
  @Column(name = "age")
  private Byte age;
  @Column(name = "marital_status")
  @Enumerated(EnumType.STRING)
  private MaritalStatus maritalStatus;
  @Column(name = "last_education")
  @Enumerated(EnumType.STRING)
  private LastEducation lastEducation;
  @Column(name = "telephone_number")
  private String telephoneNumber;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
}
