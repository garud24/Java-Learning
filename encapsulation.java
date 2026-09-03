class Keyboard
{
    private int keys;
    private String color;

    public Keyboard()
    {
        keys = 100;
        color = "White";
    }

    public int getKeys()
    {
        return keys;
    }

    public void setKeys(int keys)
    {
        this.keys = keys;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color; 
    }

    
}
public class encapsulation {

    public static void main(String args[])
    {
        Keyboard obj  = new Keyboard();

        System.out.println(obj.getKeys());
        obj.setKeys(85);
        System.out.println(obj.getKeys());
    }
    
}
