import domain.Account;
import domain.CurrentAccount;
import domain.Customer;
import domain.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Patrick");

        Account ca = new CurrentAccount(customer);
        Account sa = new SavingsAccount(customer);

        ca.deposit(100);
        ca.transfer(ca.getBalance(), sa);

        ca.printStatement();
        sa.printStatement();
    }
}
