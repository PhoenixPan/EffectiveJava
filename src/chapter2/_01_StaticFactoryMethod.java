package chapter2;

import java.math.BigInteger;
import java.util.Random;

/**
 * Used to replace or complement constructors.
 * Pros:
 * 1. Constructors share the same name which is confusing, factory methods have names that indicate their functions;
 * 2. Return the same object from repeated invocations, not creating new objects;
 * 3. Can return an object of any subtype of their return type. Return objects without making their classes public;
 * 4. Can return different objects based on given parameters (Regular/JumboEnumSet);
 * 5. The class of the returned object need not exist when the class containing the method is written.
 *
 * Cons:
 * 1. A class provides only static factory methods without public or protected constructors cannot be subclassed;
 * 2. Difficult to find the methods, as they are not in API documents
 */
public class _01_StaticFactoryMethod {

  public static void main(String[] args) {
    BigInteger integer = BigInteger.probablePrime(2, new Random(100));
    System.out.println(integer);


  }
}
