package my_program;
import java.util.Scanner;
import java.util.HashMap;
public class Interface {
    Scanner scan;//receives the file input
    //sender variables
    int transferId = -1;
    double transferValue = -1;
    String transferType = "";
    String senderName = "";
    int senderAgency = 0;
    int senderAccount = 0;
    String senderCPF = "";
    //receiver variables
    String receiverName = "";
    int receiverAgency = -1;
    int receiverAccount = -1;
    String receiverCPF = "";

    public Interface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
        //assuming that values can be passed in different order depending on first line representing variables
        String [] variables = scan.nextLine().split("|");
        
        HashMap<Integer, String> indexes = new HashMap<>(); //store variables order passed at first line

        //save in what order variables were passed in input file
        for(String variable : variables) {
            int index = 0;
            indexes.put(index, variable);
            index++;
        }

        scan.nextLine(); //jumping empty line inside input file

        String [] values = scan.nextLine().split("|");
        for(String value : values) {
            int index = 0;
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
        //check if any inputed value have an issue prior, and if so, cancel the transference
        if(checkError()) return; 
        Person sender = new Person(senderName, senderAgency, senderAccount, senderCPF);
        Person receiver = new Person(receiverName, receiverAgency, receiverAccount, receiverCPF);

        Operation op = new Operation(sender, receiver, transferId, transferValue, transferType);
    }

    //return true if found any issue in input
    public boolean checkError() {
        if(transferId < 0) {
            System.out.println("Sua transferência não foi completada pois valor de id_transferencia foi negativo");
            return true;
        }
        if(transferValue < 0) {
            System.out.println("Sua transferência não foi completada pois valor de valor_transferencia foi negativo");
            return true;
        }
        if(transferType.isEmpty()) {
            System.out.println("Sua transferência não foi completada pois valor de tipo_transferencia foi vazio");
            return true;
        }
        if(senderName.isEmpty()) {
            System.out.println("Sua transferência não foi completada pois valor de nome_emissor foi vazio");
            return true;
        }
        if(senderAgency < 0) {
            System.out.println("Sua transferência não foi completada pois valor de agencia_emissor foi negativo");
            return true;
        }
        if(senderAccount < 0) {
            System.out.println("Sua transferência não foi completada pois valor de conta_emissor foi negativo");
            return true;
        }
        if(senderCPF.isEmpty()) {
            System.out.println("Sua transferência não foi completada pois valor de cpf_emissor foi vazio");
            return true;
        }
        if(receiverName.isEmpty()) {
            System.out.println("Sua transferência não foi completada pois valor de nome_receptor foi vazio");
            return true;
        }
        if(receiverAgency < 0) {
            System.out.println("Sua transferência não foi completada pois valor de agencia_receptor foi negativo");
            return true;
        }
        if(receiverAccount < 0) {
            System.out.println("Sua transferência não foi completada pois valor de conta_receptor foi negativo");
            return true;
        }
        if(receiverCPF.isEmpty()) {
            System.out.println("Sua transferência não foi completada pois valor de cpf_receptor foi vazio");
            return true;
        }
        return false;
    }
}

