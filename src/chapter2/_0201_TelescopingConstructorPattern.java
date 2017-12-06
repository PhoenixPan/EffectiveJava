package chapter2;

/**
 * *** NOT RECOMMENDED ***
 *
 * 1. Not flexible;
 * 2. Need to remember the param sequence;
 * 3. Need to fill unwanted elements (with 0 in this case).
 */
public class _0201_TelescopingConstructorPattern {

  public static void main(String[] args) {
    NutritionFactsTele facts = new NutritionFactsTele(1,2);
  }
}

class NutritionFactsTele {
  private final int servingSize;      // (mL)      required
  private final int servings;        // (per container) required
  private final int calories;       // (per serving)  optional
  private final int fat;           // (g/serving)   optional
  private final int sodium;       // (mg/serving)   optional
  private final int carbohydrate;// (g/serving)    optional

  public NutritionFactsTele(int servingSize, int servings) {
    this(servingSize, servings, 0);
  }

  public NutritionFactsTele(int servingSize, int servings,
                            int calories) {
    this(servingSize, servings, calories, 0);
  }

  public NutritionFactsTele(int servingSize, int servings,
                            int calories, int fat) {
    this(servingSize, servings, calories, fat, 0);
  }

  public NutritionFactsTele(int servingSize, int servings,
                            int calories, int fat, int sodium) {
    this(servingSize, servings, calories, fat, sodium, 0);
  }

  public NutritionFactsTele(int servingSize, int servings,
                            int calories, int fat, int sodium, int carbohydrate) {
    this.servingSize = servingSize;
    this.servings   = servings;
    this.calories   = calories;
    this.fat     = fat;
    this.sodium    = sodium;
    this.carbohydrate = carbohydrate;
  }
}