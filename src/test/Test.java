package test;

public class Test implements ITestA, ITestB {

  public static void main(String[] args) {
    Test t = new Test();
    t.print();
  }

//  public void print() {
//    System.out.println("Print common");
//  }
}


interface ITestA {
  public static String[] getAllItemsName(){
    return null;
  }

  public default void print(String[] input) {

  }
}

interface ITestB {
  static String[] getAllItemsName(){
    return null;
  }

  public default void print() {
    System.out.println("print B");
  }
}


class Item {
  private String name;

  public String getName() {
    return this.name;
  }
}
