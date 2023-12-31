package alfarezyyd.asclepius.model.option;

public enum Religion {
  MUSLIM("Muslim"), CHRISTIAN("Christian"), HINDU("Hindu"), BUDDHIST("Buddhist"), KONG_HU_CHU("Kong Hu Chu");
  private final String value;

  Religion(String value) {
    this.value = value;
  }

  public static String getValue(Religion religion) {
    return religion.value;
  }

  public static Religion fromValue(String value) {
    return Religion.valueOf(value);
  }
}
