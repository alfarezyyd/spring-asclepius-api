package alfarezyyd.asclepius.model.option;

public enum MaritalStatus {

  MARRIED("MARRIED"), NOT_MARRIED_YET("NOT MARRIED YET");
  private final String value;

  MaritalStatus(String value) {
    this.value = value;
  }

  public static String getValue(MaritalStatus maritalStatus) {
    return maritalStatus.value;
  }

  public static MaritalStatus fromValue(String value) {
    return MaritalStatus.valueOf(value);
  }
}
