package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Person {
  @Id
  @Column(name = "people_id")
  private Long peopleId;
  private String identityCardNumber;
  private String identityCardNumberType;
  private String fullName;
  private String email;
  private String gender;
  private String religion;
  private String bloodType;
  private String birthPlace;
  private Date birthDate;
  private Byte age;
  private String maritalStatus;
  private String lastEducation;
  private String telephoneNumber;
  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
}
