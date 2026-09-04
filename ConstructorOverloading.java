class Vehicle
{
    String model;
    String color;
    // Static vs instance variables
    // static variables belongs to class, no matter how man objects you create it belongs to that class itslef
    static int totalVehiclesCreated = 0;

    Vehicle(String model, String color)
    {
        this.model = model;
        this.color = color;
        this.totalVehiclesCreated  ++;
    }

    Vehicle(String model)
    {
        this(model, "white");
    }

    Vehicle() {
        this("Unkonwn");
    }

    
}

class Point
{
    int x;
    int y;


    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    Point()
    {
        this(0,0);
    }

    Point shift(int dx)
    {
        this.x += dx;
        return this;
    }

    void compare(Point other)
    {
        if (this == other)
        {
            System.out.println("Same object");
        }
    }
}

// Demo for Static block and instance block
// Static Blocks vs. Instance Initializer Blocks
/*
static block --> runs only once when a new object has been created
instance block --> runs when any new object apart from the orignal object has been created
constructor --> always runs after the instance block (if there are same object created before this) and static block (if first object of that class type)
 */
class Objects
{
    static int numberOfObjects;
    String type;

    static {
        // Runs exactly once, when the class is first loaded by the JVM.
        numberOfObjects = 0;
        System.out.println("Object class loaded");
    }

    {
        // Runs every time an object is created, before the constructor body.
        System.out.println("New Object object being built");
    }

    Objects(String type)
    {
        this.type = type;
        System.out.println("Objects constructor running");
    }

}
public class ConstructorOverloading {
    public static void main(String[] args)
    {
        Vehicle v = new Vehicle();

        System.out.println(v.color + v.model);

        // Point
        Point p = new Point(10,30);

        System.out.println(p.x); // 15
        System.out.println(p.y); // 30
        p.shift(5).shift(10);

        System.out.println("After Shift" + p.x + p.y);

        p.compare(p);
        // Testing the static variable inside the class Vehicle
        Vehicle v2 = new Vehicle("Honda", "black");
        Vehicle v3 = new Vehicle("Suzuki", "Gray");
        Vehicle v4 = new Vehicle("Chevy", "Orange");

        System.out.println("The total number of vehicles created: " + v4.totalVehiclesCreated);

        // Now calling the class Objects it will first the static block and then all the instance block then when the object is created it will run the construtor

        // running the program without the objects class

        Objects square = new Objects("Square");

        Objects bike = new Objects("bike");
    }
    
}
