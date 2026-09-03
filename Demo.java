class Demo {
    public static void main(String args[]){
        // These are the primitive data types available in Java
        // int num = 25;
        // double d = 9.6;
        // float f = 8.5f;
        // long l = 77777;
        // short s = 9;
        // char c = 'a';
        // System.out.println("Hello World !!");
        // System.out.println(num + d);

        // show();

        // int num1 = 6;
        // int num2 = 8;

        // if (num1 > num2)
        // {
        //     System.out.println("Hi");

        // }
        // else if(num2 > num1)
        // {
        //     System.out.println("Hello");
        // }
        // else
        // {
        //     System.out.println("What is this?");
        // }

        int i = 0;

        while(i < 5)
        {
            System.out.println("i="+i);
            i ++;
        }
        for (int j = 0; j < 5; j++) {
            System.out.println("j = " + j);
        }
    }

    public static void show()
    {
        System.out.println("in Show");
    }
}
