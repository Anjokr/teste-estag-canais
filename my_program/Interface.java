package my_program;
import java.util.Scanner;
import java.util.HashMap;
public class Interface {
    private Scanner scan;//receives the file input
    //sender variables
    private int transferId = -1;
    private double transferValue = -1;
    private String transferType = "";
    private String senderName = "";
    private int senderAgency = 0;
    private int senderAccount = 0;
    private String senderCPF = "";
    //receiver variables
    private String receiverName = "";
    private int receiverAgency = -1;
    private int receiverAccount = -1;
    private String receiverCPF = "";

    public Interface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
        //assuming that values can be passed in different order depending on first line representing variables inside input file
        String [] variables = scan.nextLine().split("\\|");
        
        HashMap<Integer, String> indexes = new HashMap<>(); //store variables order passed at first line

        //save in what order variables were passed in input file
        int index = 0;
        for(String variable : variables) {
            indexes.put(index, variable);
            index++;
        }

        scan.nextLine(); //jumping empty line inside input file

        String [] values = scan.nextLine().split("\\|");
        
        receiveValues(values, indexes);

        //check if any inputed value have an issue prior to the operation, and if so, cancel the transference
        if(checkError()) return; 

        Person sender = new Person(senderName, senderAgency, senderAccount, senderCPF);
        Person receiver = new Person(receiverName, receiverAgency, receiverAccount, receiverCPF);

        //start the transfer operation
        Operation op = new Operation(sender, receiver, transferId, transferValue, transferType);
        op.start();
    }

    public void receiveValues(String [] values, HashMap<Integer, String> indexes) {
        int index = 0;
        for(String value : values) {
            
            String var = indexes.get(index);
            switch (var){ //assigning value inside correct variable
                case "id_transferencia":
                    transferId = Integer.valueOf(value);
                    break;
                case "valor_transferencia":
                    transferValue = Double.valueOf(value);
                    break;
                case "tipo_transferencia":
                    transferType = value;
                    break;
                case "nome_emissor":
                    senderName = value;
                    break;
                case "agencia_emissor":
                    senderAgency = Integer.valueOf(value);
                    break;
                case "conta_emissor":
                    senderAccount = Integer.valueOf(value);
                    break;
                case "cpf_emissor":
                    senderCPF = value;
                    break;
                case "nome_receptor":
                    receiverName = value;
                    break;
                case "agencia_receptor":
                    receiverAgency = Integer.valueOf(value);
                    break;
                case "conta_receptor":
                    receiverAccount = Integer.valueOf(value);
                    break;
                case "cpf_receptor":
                    receiverCPF = value;
                    break;
            }
            index++;
        }
    }

    //return true if found any issue in input
    public boolean checkError() {
        if(transferId < 0) {
            System.out.println("Sua transferência não foi completada pois valor de id_transferencia é negativo");
            return true;
        }
        if(transferValue < 0) {
            System.out.println("Sua transferência não foi completada pois valor de valor_transferencia é negativo");
            return true;
        }
        if(senderAgency < 0) {
            System.out.println("Sua transferência não foi completada pois valor de agencia_emissor é negativo");
            return true;
        }
        if(senderAccount < 0) {
            System.out.println("Sua transferência não foi completada pois valor de conta_emissor é negativo");
            return true;
        }
        if(receiverAgency < 0) {
            System.out.println("Sua transferência não foi completada pois valor de agencia_receptor é negativo");
            return true;
        }
        if(receiverAccount < 0) {
            System.out.println("Sua transferência não foi completada pois valor de conta_receptor é negativo");
            return true;
        }
        if(senderAccount == receiverAccount) {
            System.out.println("Sua transferência não foi completada pela tentativa não permitida de transferir para mesma conta");
            return true;
        }
        return false;
    }
}

