package calculator;

public class Sum {
  double num1, num2;

  public double sumValues(double firstNumber, double secondNumber) {
    this.num1 = firstNumber;
    this.num2 = secondNumber;
    return this.num1 + this.num2;
  }
}
