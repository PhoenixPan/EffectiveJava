package chapter2;

/**
 * Pro:
 * 1. Easy to read and use;
 * 2. Flexible and extendable;
 * 3. Class is immutable.
 *
 * Cons:
 * 1. Additional objects (builders) may affect performance;
 * 2. Complicated, use when necessary.
 *
 */

public class _0203_BuilderPattern {
  public static void main(String[] args) {

    NutritionFacts.Builder builder =
        new NutritionFacts.Builder(10, 10).calories(50);

    NutritionFacts facts = builder.build();

    System.out.println(facts);
  }
}

/**
 * An immutable class
 */
class NutritionFacts {
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
    private int calories   = 0;
    private int fat      = 0;
    private int sodium    = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings  = servings;
    }

    // Allow chained invocations by returning "this"
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

  /**
   *  Private constructor that can only accessed by builder
   */
  private NutritionFacts(Builder builder) {
    servingSize  = builder.servingSize;
    servings   = builder.servings;
    calories   = builder.calories;
    fat     = builder.fat;
    sodium    = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  public String toString() {
    return this.servingSize
        + "," + this.servings
        + "," + this.calories
        + "," + this.carbohydrate
        + "," + this.fat
        + "," + this.sodium;
  }
}