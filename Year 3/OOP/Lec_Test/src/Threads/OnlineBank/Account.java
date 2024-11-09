package Threads.OnlineBank;

public class Account {
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Can’t deposit.");
        }
        else{ this.balance += amount;
            System.out.println("Deposit " + amount + " in thread " + Thread.currentThread().getId() + ", balance is " + this.balance);
        }
    }

    public synchronized void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Pleae enter a valid amount");
        } else if (this.balance - amount < 0) {
            System.out.println("Your account balance is not sufficient");
        }
        else{
            this.balance -= amount;
            System.out.println("Successfully withdrawn " + amount + " in thread " + Thread.currentThread().getId() + ", balance is " + this.balance);
        }
    }
}
