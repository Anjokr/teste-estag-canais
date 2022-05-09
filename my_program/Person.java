package my_program;

public class Person {
    private String name;
    private int agency;
    private int account;
    private String cpf;
    private double balance;

    public Person(String name, int agency, int account, String cpf) {
        this.name = name;
        this.agency = agency;
        this.account = account;
        this.cpf = cpf;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getAgency() {
        return agency;
    }

    public int getAccount() {
        return account;
    }

    public String getCPF() {
        return cpf;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double value) {
        balance += value;
    }

    public void subtractBalance(double value) {
        balance -= value;
    }
}
