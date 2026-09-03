class Keyboard {
    int keys = 100;
    String color = "White";

    public void pressed() {
        System.out.println("The keys are pressed: " + keys);
        keys = 85;
    }

    public String throwIt() {
        System.out.println("The hit is hard: " + color);
        return color;
    }
    public String throwIt(String c)
    {
        System.out.println("The hit hardest" + c);
        return c + "Himanshu";
    }
}

class AdvKeyboard extends Keyboard {
    @Override
    public void pressed() {
        System.out.println("The keys are pressed through advance keyboard: " + keys);
        keys = 88;
    }

    @Override
    public String throwIt() {
        System.out.println("The hit is hard through advance keyboard: " + color);
        return color;
    }
}

public class Polymorphism {
    // This is method overriding
    public static void main(String[] args) {
        Keyboard obj = new AdvKeyboard(); // which method it is called is depend on the which object you created
        Keyboard obj1 = new Keyboard();

        obj1.pressed();
        obj1.throwIt("computer mod");
        obj.pressed();
        obj.throwIt();
    }
}