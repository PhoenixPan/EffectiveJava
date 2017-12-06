package chapter2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class _0204_AbstractBuilder {
  public static void main(String[] args) {

    NyPizza.Builder nyBuilder = new NyPizza.Builder(NyPizza.Size.LARGE)
        .addTopping(Pizza.Topping.HAM)
        .addTopping(Pizza.Topping.MUSHROOM);

    Calzone.Builder calBuilder = new Calzone.Builder().sauceInside()
        .addTopping(Pizza.Topping.SAUSAGE);
  }
}

abstract class Pizza {
  public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping, "Please add a non-null value!"));
      return self();
    }
    abstract Pizza build();
    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  public Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }
}

class NyPizza extends Pizza {
  public enum Size { SMALL, MEDIUM, LARGE }
  private final Size size;

  public static class Builder extends Pizza.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }
    @Override public NyPizza build() {
      return new NyPizza(this);
    }
    @Override protected Builder self() {
      return this;
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }
}

class Calzone extends Pizza {
  private final boolean sauceInside;

  public static class Builder extends Pizza.Builder<Builder> {
    private boolean sauceInside = false; // Default

    // public Builder(){} // default constructor

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override public Calzone build() {
      return new Calzone(this);
    }

    @Override protected Builder self() {
      return this;
    }
  }
  private Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }
}