// Here we will learn about the custom constructor

class Keyboard
{
    int keys;
    String color;

    public Keyboard()
    {
        keys = 100;
        color = "White";
    }

    public void pressed()
    {
        System.out.println("The signal sent to the Mother board: " + color);
    }

    public void throwIt()
    {
        System.out.println("got hit");
        keys = 85;
    }
}
 
public class example2
{
    public static void main(String[] args) {
        Keyboard obj = new Keyboard();
        // This means our constructor is working properly
        System.out.println("inital keys and colors: " + obj.keys + obj.color);
    }
}
