abstract class Keyboard
{
    int keys;
    String color;
    static String brand; // A static field belongs to the class and can be accessed as Keyboard.brand.

    public abstract void pressed();

}
class AdvKeyboard extends Keyboard
{
    @Override
    public void pressed()
    {
        System.out.println("The key is hit hard");
    }
}
/* Each method invocation creates a stack frame. Objects are generally created in heap memory,
   while local variables and object references belong to the method's stack frame. */
public class Abstraction {
    public static void main(String[] args) {

        Keyboard.brand = "Example";
        System.out.println(Keyboard.brand);
        Keyboard obj = new AdvKeyboard(); // The object is created in heap memory; obj stores its reference.
        obj.pressed();
    }
}
