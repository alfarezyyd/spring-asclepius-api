package alfarezyyd.asclepius.helper;

import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.model.entity.Polyclinic;

import java.util.List;

public class Model {
  private Model() {

  }

  public static AddressResponse convertIntoAddressResponse(PersonResponse personResponse, Address addressEntity) {
    AddressResponse addressResponse = new AddressResponse();
    addressResponse.setUrbanVillageName(addressEntity.getUrbanVillageName());
    addressResponse.setSubDistrictName(addressEntity.getSubDistrictName());
    addressResponse.setDistrictName(addressEntity.getDistrictName());
    addressResponse.setProvinceName(addressEntity.getProvinceName());
    addressResponse.setNeighbourhoodNumber(addressEntity.getNeighbourhoodNumber());
    addressResponse.setHamletNumber(addressEntity.getHamletNumber());
    addressResponse.setPostalCode(addressEntity.getPostalCode());
    addressResponse.setPerson(personResponse);
    return addressResponse;
  }

  public static PolyclinicResponse convertIntoPolyclinicResponse(List<DoctorResponse> doctorsResponses, Polyclinic polyclinicEntity) {
    PolyclinicResponse polyclinicResponse = new PolyclinicResponse();
    polyclinicResponse.setCode(polyclinicEntity.getCode());
    polyclinicResponse.setName(polyclinicEntity.getName());
    polyclinicResponse.setLocation(polyclinicEntity.getLocation());
    polyclinicResponse.setDoctors(doctorsResponses);
    return polyclinicResponse;
  }
}
