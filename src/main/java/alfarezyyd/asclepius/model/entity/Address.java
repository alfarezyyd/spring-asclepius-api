package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@EqualsAndHashCode
public class Address {
  @Id
  private Long id;
  @Column(name = "urban_village_name")
  private String urbanVillageName;
  @Column(name = "sub_district_name")
  private String subDistrictName;
  @Column(name = "district_name")
  private String districtName;
  @Column(name = "province_name")
  private String provinceName;
  @Column(name = "neighbourhood_number")
  private String neighbourhoodNumber;
  @Column(name = "hamlet_number")
  private String hamletNumber;
  @Column(name = "postal_code")
  private String postalCode;
  @OneToOne(mappedBy = "address")
  private Person person;
}
