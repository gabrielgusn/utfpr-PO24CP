public class BankAccount {
    private String nameHolder;
    private double balance;
    public BankAccount(String n, double b){
        nameHolder = n;
        balance = b;
    }

    public double getBalance(){ return balance; }
    public String getName(){ return nameHolder; }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount){
        if(amount <= balance) balance = balance - amount;
    }
    public String toString(){
        return "Name: " +nameHolder+". Balance: "+balance;
    }
}