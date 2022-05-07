package my_program;

public class Person {
    String name;
    int agency;
    int account;
    String cpf;
    double balance;

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
}
