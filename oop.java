class Keyboard
{
    int keys = 100;
    String color = "White";

    public void pressed()
    {
        System.out.println("Signal Sent: " + color);
    }
    public void throwIt()
    {
        System.out.println("got hit");
        keys = 85;
    }
}
// inheritence 
class AdvKeyboard extends Keyboard
{
    public void hitNum()
    {
        System.out.println("Sent number");
    }
}
class Demo
{
    public static void main(String args[])
    {
        int num;
        num = 8;

        // Keyboard obj;
        // obj = new Keyboard();

        // obj.pressed();
        // obj.throwIt();

        // System.out.println("keys=" + obj.keys);

        AdvKeyboard obj;
        obj = new AdvKeyboard();

        obj.pressed();
        obj.throwIt();
        obj.hitNum();

        System.out.println("keys=" + obj.keys);

    }
}