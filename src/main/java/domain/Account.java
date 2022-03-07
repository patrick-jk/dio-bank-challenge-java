package domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public abstract class Account {
    private static final int DEFAULT_AGENCY = 1;
    private static int sequential = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Customer customer;


    public Account(Customer customer) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = sequential++;
        this.customer = customer;
    }

    public abstract void printStatement();

    public void withdraw(double value) {
        this.balance -= value;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void transfer(double value, Account targetAccount) {
        this.withdraw(value);
        targetAccount.deposit(value);
    }

    protected void printAccountInfo() {
        System.out.printf("Customer: %s%n", this.customer.getName());
        System.out.printf("Agency: %d%n", agency);
        System.out.printf("Number: %d%n", number);
        System.out.printf("Balance: %.2f%n", balance);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss", Locale.US);
        System.out.printf("Printing Time: %s%n", LocalDateTime.now().format(dtf));
    }
}
