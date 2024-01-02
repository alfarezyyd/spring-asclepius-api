package alfarezyyd.asclepius.mapper;

import org.mapstruct.Named;

import java.sql.Date;


public interface PersonMapper {
  @Named("stringIntoDateBirthDate")
  static Date stringIntoDateBirthDate(String birthDate) {
    return Date.valueOf(birthDate);
  }
}
