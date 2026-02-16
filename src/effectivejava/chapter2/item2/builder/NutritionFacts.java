package effectivejava.chapter2.item2.builder;

/** Builderパターンのサンプル */
public class NutritionFacts {
  private static final String FORMAT =
      "NutritionFacts{servingSize=%d, servings=%d, calories=%d, fat=%d, sodium=%d,"
          + " carbohydrate=%d}";

  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public static class Builder {
    // Required parameters
    private final int servingSize;
    private final int servings;

    // Optional parameters - initialized to default values
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    /**
     * 必須パラメータを受け取るコンストラクタ
     *
     * @param servingSize
     * @param servings
     */
    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }

  private NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  @Override
  public String toString() {
    return String.format(FORMAT, servingSize, servings, calories, fat, sodium, carbohydrate);
  }

  public static void main(String[] args) {
    NutritionFacts cocaCola =
        new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    System.out.println(cocaCola);
  }
}
