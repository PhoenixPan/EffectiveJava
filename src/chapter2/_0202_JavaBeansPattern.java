package chapter2;

/**
 * *** BETTER BUT STILL NOT RECOMMENDED ***
 *
 * 1. Wordy;
 * 2. The construction of an object is split across multiple calls (not atomic);
 * 3. Class cannot be immutable;
 * 4. Thread unsafe.
 *
 */
public class _0202_JavaBeansPattern {
  public static void main(String[] args) {
    NutritionFactsBeans cocaCola = new NutritionFactsBeans();
    cocaCola.setServingSize(240);
    cocaCola.setServings(8);
    cocaCola.setCalories(100);
    cocaCola.setSodium(35);
    cocaCola.setCarbohydrate(27);
  }
}

class NutritionFactsBeans {
  // Parameters initialized to default values (if any)
  private int servingSize   = -1; // Required; no default value
  private int servings      = -1; // Required; no default value
  private int calories     = 0;
  private int fat          = 0;
  private int sodium       = 0;
  private int carbohydrate = 0;

  public NutritionFactsBeans() { }
  // Setters
  public void setServingSize(int val)  { servingSize = val; }
  public void setServings(int val)     { servings = val; }
  public void setCalories(int val)     { calories = val; }
  public void setFat(int val)          { fat = val; }
  public void setSodium(int val)       { sodium = val; }
  public void setCarbohydrate(int val)  { carbohydrate = val; }
}