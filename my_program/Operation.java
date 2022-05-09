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

    public void start() {
        //check if the value match the transfer type
        if(checkTypeValue()) return;
        sender.subtractBalance(transferValue);
        receiver.addBalance(transferValue);

        System.out.println("Sua transferência foi realizada com sucesso!");
        System.out.println("Saldo do emissor: R$ " + String.format("%.2f", sender.getBalance()));
        System.out.println("Saldo do receptor: R$ " + String.format("%.2f", receiver.getBalance()));
    }

    public boolean checkTypeValue() {
        if(transferType.equals("PIX")) {
            if(transferValue > 5000) {
                //error message
                System.out.println("Sua transferência de valor: "+ transferValue+" não foi completada por ser valor não permitida através do PIX. Valor deve ser abaixo de R$ 5 mil");
                return true;
            }
        }
        if(transferType.equals("TED")) {
            if(transferValue < 5000 || transferValue > 10000) {
                //error message
                System.out.println("Sua transferência de valor: "+ transferValue+" não foi completada por ser valor não permitida através do TED. Valor deve ser entre R$ 5 mil e R$ 10 mil");
                return true;
            }
        }
        if(transferType.equals("DOC")) {
            if(transferValue < 10000) {
                //error message
                System.out.println("Sua transferência de valor: "+ transferValue+" não foi completada por ser valor não permitida através do DOC. Valor deve ser acima de R$ 10 mil");
                return true;
            }
        }

        return false;
    }

}
