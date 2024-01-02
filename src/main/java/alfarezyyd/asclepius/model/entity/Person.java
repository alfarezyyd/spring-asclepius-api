package alfarezyyd.asclepius.model.entity;

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
  @Column(name = "people_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long personId;
  @Column(name = "identity_card_number", unique = true)
  private String identityCardNumber;
  @Column(name = "identity_card_type")
  private String identityCardType;
  @Column(name = "full_name")
  private String fullName;
  @Column(unique = true)
  private String email;
  private String gender;
  private String religion;
  @Column(name = "blood_type")
  private String bloodType;
  @Column(name = "birth_place")
  private String birthPlace;
  @Column(name = "birth_date")
  private Date birthDate;
  @Column(name = "age")
  private Byte age;
  @Column(name = "marital_status")
  private String maritalStatus;
  @Column(name = "last_education")
  private String lastEducation;
  @Column(name = "telephone_number")
  private String telephoneNumber;
  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
}
