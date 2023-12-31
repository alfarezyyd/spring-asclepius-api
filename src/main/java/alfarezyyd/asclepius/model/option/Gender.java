package alfarezyyd.asclepius.model.option;

public enum Gender {
  MAN("Man"), WOMAN("Woman");
  private final String value;

  Gender(String value) {
    this.value = value;
  }

  public static String getValue(Gender gender) {
    return gender.value;
  }

  public static Gender fromValue(String value) {
    return Gender.valueOf(value);
  }
}
