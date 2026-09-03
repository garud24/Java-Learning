public class DataStructures {
    public static void main(String[] args) {

        /*  whenever you want to store any name in string, you can store using String s = "Himanshu"
        but String is a class name in Java, so
        String s = "himanshu" --> you are getting an Object
        

        String s = new String("Himanhu"); // You are getting an object of string and passing a value in the String constructor
        To make it simple Java has made easy for you i.e. String s = "Himanshu" --> but behind the scenes it is the same.*/

        // Strings are immutable
        String s = "Himashu";

        s = s + "Garud";

        System.out.println("Hello: " + s);

        // This is illegal
        // String h = "Hello";

        // h[3] = "g";

        // We can use mutable using Stringbuffer()
        StringBuffer k = new StringBuffer("Himanshu");
        k.append("Garud");
        System.out.println(k);

    }
}
