/*Pass-by-value proof: Write a Point class with int x, y. 
1. Write a method translate(Point p, int dx, int dy) that mutates p.x and p.y 
directly (Consequence A), then verify that the caller sees the change.
Write a second, intentionally buggy method reset(Point p) 
that does p = new Point(0, 0);, 
then prove that the caller's object is untouched (Consequence B).
haKiran

2. Swap drill: Try to write a method that swaps two int primitives 
passed as arguments. Prove that it does not work outside the 
method. Then write swapFields(Point p1, Point p2) that swaps 
the x and y values between two Point objects by mutating fields, 
not reassigning parameters.

3. StringBuilder drill: Write a method that takes an int[] and 
returns a comma-separated String of its elements using 
StringBuilder, not += concatenation. Handle the trailing-comma 
edge case cleanly.

4. Overload resolution — describe(int), describe(double),
describe(String). Call with 5, 5.0, and 
a char value. Predict which overload the char call 
hits before running it, write your prediction in a comment, 
then verify.*/

class Point
{
    int x = 0;
    int y = 0;
}

// Exercise using a String builder
class Convert
{
    public String convertToString(int[] nums)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
            {
                sb.append(",");
            }
            sb.append(nums[i]);          // mutates the SAME buffer, no new object each time
        }
        String result = sb.toString(); 

        return result;
    }
}
public class Exercise1Day2 {

    static void translate(Point p, int dx, int dy)
    {
        p.x += dx;
        p.y += dy;
    }

    static void reset(Point p)
    {
        p = new Point();
        p.x=0;
        p.y=0;
    }

    // Swap exercise

    static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    // Overload resolution exercise

    static int describe(int a)
    {
        return a;
    }

    static double describe(double a)
    {
        return a;
    }

    static String describe(String a)
    {
        return a;
    }

    static void swapFields(Point p1, Point p2)
    {
        Point temp1 = new Point();
        temp1.x = p1.x;
        temp1.y = p1.y;

        p1.x = p2.x;
        p1.y = p2.y;

        p2.x = temp1.x;
        p2.y = temp1.y;
    }
    public static void main(String[] args) {
        
        Point p = new Point();

        translate(p, 10, 10);

        System.out.println(p.x);
        System.out.println(p.y);

        // Will not reset because the p is now a new object which is pointing to a different heap
        reset(p);

        System.out.println(p.x);
        System.out.println(p.y);

        // Swap exercise
        int a = 10;
        int b = 20;

        swap(a, b); // should remain same

        System.out.println("after calling swapping function: " + a);
        System.out.println("after calling swapping function: " + b);
        
        // SwapField function
        Point p1 = new Point();
        Point p2 = new Point();
        p1.x = 30;
        p1.y = 40;

        p2.x = 50;
        p2.y = 60;
        swapFields(p1, p2);

        System.out.println("After Swap fields p1: " + p1.x + " " + p1.y);
        System.out.println("After Swap fields p2: " + p2.x + " " + p2.y);

        // exercise 3 using stringBuilder

        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        Convert c = new Convert();

        System.out.println("Nums after converting into string: " + c.convertToString(nums));

        // erercise 4, Overloiading resolution

        int ab = 5;
        double d = 88.9;
        char s = 'a';
        
        // System.out.println("Calling the int type describe: " + describe(ab));
        // System.out.println("Calling the double type describe: " + describe(d));
        System.out.println("Calling describe with char: "  + describe(s));
        
    }    
}
