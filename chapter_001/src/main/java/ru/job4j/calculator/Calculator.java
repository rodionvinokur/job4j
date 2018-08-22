package ru.job4j.calculator;

/**
* Calculator.
* @author Rodion V.
* @version 1.0
* @since 1.0
*/

public class Calculator {

   /**
   * Result of operations.
   */
    private double result;

    /**
    * Methods add.
    * @param first, second  - operands.
    */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
    * Methods substract.
    * @param first, second  - operands.
    */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
    * Methods div.
    * @param first, second  - operands.
    */
    public void div(double first, double second) {
        if (second != 0.0) {
          this.result = first / second;
        }
    }

    /**
    * Methods multiple.
    * @param first, second  - operands.
    */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
    * Methods multiple.
    * @return result as type double.
    */
    public double getResult() {
        return this.result;
    }
}
