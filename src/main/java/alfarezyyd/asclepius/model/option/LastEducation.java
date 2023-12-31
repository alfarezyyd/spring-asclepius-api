package alfarezyyd.asclepius.model.option;

public enum LastEducation {
  ELEMENTARY_SCHOOL("Elementary School"), JUNIOR_HIGH_SCHOOL("Junior High School"),

  SENIOR_OR_VOCATIONAL_SCHOOL("Senior/Vocational High School"), DIPLOMA_3("Diploma 3"), BACHELOR_DEGREE("Bachelor Degree"), ASSOCIATE_DEGREE("Associate Degree"), MASTER_DEGREE("Master Degree");

  private final String value;

  LastEducation(String value) {
    this.value = value;
  }

  public static String getValue(LastEducation lastEducation) {
    return lastEducation.value;
  }

  public static LastEducation fromValue(String value) {
    return LastEducation.valueOf(value);
  }
}
