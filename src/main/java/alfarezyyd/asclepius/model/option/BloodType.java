package alfarezyyd.asclepius.model.option;

public enum BloodType {
  A, B, O, AB;

  public static BloodType fromValue(String value) {
    return BloodType.valueOf(value);
  }
}
