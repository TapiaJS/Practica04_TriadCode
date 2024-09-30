import proxy.PrinterRemote;
import singleton.Printer;

import java.rmi.Naming;
//cd src/main/java
//java PrinterTestDrive dos.com
public class PrinterTestDrive {
    public static void main(String[] args) {
        PrinterRemote printer = null;

        if (args.length < 1){
            System.out.println("Uso correcto: PrinterTestDrive <nombre_del_servidor>");
            System.exit(1);
        }

        try {
            printer = Printer.getInstance();
            Naming.rebind("//" + args[0] + "/printer", printer);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
