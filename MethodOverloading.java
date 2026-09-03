class Calculator
{
    int add(int a, int b )
    {
        return a + b;
    }

    double add(double a, double b, double c)
    {
        return a + b + c;
    }

    int add(int a, int b, int c)
    {
        return a + b + c;
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(10, 8));
        System.out.println(c.add(99.99, 88.88, 77.77));
        System.out.println(c.add(5,6,7));
    }
}
