package alfarezyyd.asclepius.model.option;

public enum IdentityCardType {
  IDENTITY_CARD("Identity Card"), DRIVING_LICENSE("Driving License");
  private final String value;

  IdentityCardType(String value) {
    this.value = value;
  }

  public static String getValue(IdentityCardType identityCardType){
    return identityCardType.value;
  }

  public static IdentityCardType fromValue(String value) {
    return IdentityCardType.valueOf(value);
  }
}
