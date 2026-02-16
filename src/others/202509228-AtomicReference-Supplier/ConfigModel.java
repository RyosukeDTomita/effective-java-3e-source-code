/** 不変なクラス */
public final class ConfigModel {
  private final String provider;

  public ConfigModel(String provider) {
    if (provider == null || provider.isBlank()) {
      throw new IllegalArgumentException("provider must not be empty");
    }
    this.provider = provider;
  }

  public String getProvider() {
    return provider;
  }

  @Override
  public String toString() {
    return "ConfigModel(provider=" + provider + ")";
  }
}
