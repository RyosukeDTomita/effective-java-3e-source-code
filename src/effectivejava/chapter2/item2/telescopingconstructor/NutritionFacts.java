package effectivejava.chapter2.item2.telescopingconstructor;

/**
 * テレスコーピングコンストラクタパターンのサンプル
 */
public class NutritionFacts {
    private static final String FORMAT = "NutritionFacts{servingSize=%d, servings=%d, calories=%d, fat=%d, sodium=%d, carbohydrate=%d}";
    
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required
    private final int calories;     // (per serving)   optional
    private final int fat;          // (g/serving)     optional
    private final int sodium;       // (mg/serving)    optional
    private final int carbohydrate; // (g/serving)     optional

    /**
     * 必須パラメータのみを受け取るコンストラクタ
     * @param servingSize
     * @param servings
     */
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    /**
     * 必須パラメータを受け取るコンストラクタからのオーバーロード
     * @param servingSize
     * @param servings
     * @param calories
     */
    public NutritionFacts(int servingSize, int servings,
                          int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, servingSize, servings, calories, fat, sodium, carbohydrate);
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola =
                new NutritionFacts(240, 8, 100, 0, 35, 27);
        System.out.println(cocaCola);
    }
    
}