package my_program;

public class Operation {
    Person sender;
    Person receiver;
    int transferId;
    double transferValue;
    String transferType;

    public Operation(Person sender, Person receiver, int id, double value, String type) {
        this.sender = sender;
        this.receiver = receiver;
        transferId = id;
        transferValue = value;
        transferType = type;
    }
}
