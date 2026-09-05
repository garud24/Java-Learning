import java.util.ArrayList;
import java.util.List;

/*
1. BankAccount with real invariant enforcement: Create a private 
balance field. Reject negative initial balances, and make 
deposit(amount) reject negative or zero amounts. Make 
withdraw(amount) reject amounts that exceed the balance or are 
negative or zero. Do not create a public setter for balance; 
change it only through deposit and withdraw.

2. Immutable Money class: Create a final class with private 
final int amountInCents and String currency fields, getters, 
and an add(Money other) method that returns a new Money object. 
Throw an exception if the currencies do not match.

3. Defensive copying bug, then fix: Write a Roster class that 
takes a List<String> in its constructor and stores it without copying. 
Prove the bug by mutating the original list from outside and showing 
that the Roster's internal state changes. Then fix Roster with 
defensive copies in the constructor and getter, and prove the bug is 
gone.

4. Getter/setter judgment call: Design a Temperature class that stores 
Celsius internally but exposes getCelsius() and a computed getFahrenheit(). 
Do not add a setter; set values only at construction. Compute Fahrenheit 
on demand instead of storing a second field, because duplicated state can 
go out of sync.
 */

class BankAccount
{
    private double balance;

    public BankAccount(double balance) {
        if (balance < 0)
        {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    void withdraw(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > balance)
        {
            throw new IllegalArgumentException("Amount cannot be greater than balance");
        }

        balance -= amount;
    }


    void deposite(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Deposite amount cannot be negative or zero");
        }

        balance += amount;
    }
    
    double getBalance()
    {
        return balance;
    }
}

// Implementing class Money, which is final class money
final class Money
{
    final private int amountInCents;
    final private String currency;

    Money(int amountInCents, String currency)
    {
        this.amountInCents = amountInCents;
        this.currency = currency;
    }

    public int getAmountInCents() {
        return amountInCents;
    }

    public String getCurrency() {
        return currency;
    }

    Money add(Money other)
    {
        if(!this.currency.equals(other.currency))
        {
            throw new IllegalArgumentException("Both currencies should be same");
        }

        return new Money(this.amountInCents + other.amountInCents, this.currency);
    }

    public double getAmountInDollars() {
    return amountInCents / 100.0;
    }
}
// Implementing BuggyRoster class
class BuggyRoster
{
    private final List<String> names;

    BuggyRoster(List<String> names)
    {
        this.names = names;
    }

    List<String> getNames()
    {
        return names;
    }
}

class Roster
{
    private final List<String> names;

    Roster(List<String> names)
    {
        this.names = new ArrayList<>(names);
    }

    List<String> getNames()
    {
        return new ArrayList<>(names);
    }
}

// Implementing Celcius class
class Temperature
{

    private final double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }
    
    public double getFahrenheit()
    {
        return celsius * 9.0 / 5.0 + 32;
    } 
}
public class ExerciseDay4 {

    public static void main(String[] args)
    {
        BankAccount b = new BankAccount(1000);

        b.deposite(500);
        b.withdraw(600);

        System.out.println("The current balance is: " + b.getBalance());

        try {
                BankAccount bad = new BankAccount(-100);
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected negative initial balance: " + e.getMessage());
            }

            try {
                b.deposite(-50);
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected bad deposit: " + e.getMessage());
            }

            try {
                b.withdraw(0);
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected zero withdrawal: " + e.getMessage());
            }

            try {
                b.withdraw(999999);
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected over-withdrawal: " + e.getMessage());
            }

        // Implementing exercise2
        Money price1 = new Money(500, "USD");   // $5.00
        Money price2 = new Money(300, "USD");   // $3.00
        Money total = price1.add(price2);
        
        System.out.println("The total price is: " + total.getAmountInCents());

        System.out.println("price1 unchanged: " + price1.getAmountInCents());  // should still be 500
        System.out.println("price2 unchanged: " + price2.getAmountInCents());  // should still be 300
        System.out.println("The total value in dollars: " + total.getAmountInDollars());
        try{
            Money euro = new Money(600, "EUR");
            Money mismatch = price1.add(euro);
        }catch(IllegalArgumentException e){
            System.out.println("Correctly rejected currency mismatch: " + e.getMessage());
        }

        // Implementing exercise 3
        List<String> originalNames = new ArrayList<>();
        originalNames.add("Alice");

        BuggyRoster buggyRoster = new BuggyRoster(originalNames);
        originalNames.add("Bob");

        System.out.println("Buggy roster after external mutation: " + buggyRoster.getNames());

        Roster roster = new Roster(originalNames);
        originalNames.add("Charlie");

        System.out.println("Safe roster after external mutation: " + roster.getNames());

        List<String> namesFromGetter = roster.getNames();
        namesFromGetter.add("Diana");

        System.out.println("Safe roster after getter mutation: " + roster.getNames());

        // Implementing exercise 4
        Temperature t = new Temperature(50);

        System.out.println("The current temperature is: " + t.getCelsius());

        System.out.println("Celcius to Fahrenheit: " + t.getFahrenheit());

        Temperature freezing = new Temperature(0);
        Temperature boiling = new Temperature(100);
        System.out.println("0C in F (expect 32.0): " + freezing.getFahrenheit());
        System.out.println("100C in F (expect 212.0): " + boiling.getFahrenheit());
    }   
    
}
