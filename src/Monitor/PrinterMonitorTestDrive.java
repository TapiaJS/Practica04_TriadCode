package Monitor;

import proxy.PrinterRemote;

import java.rmi.Naming;

public class PrinterMonitorTestDrive {
    public static void main(String[] args) {
        String printerUrl = "rmi://printer.com/printer";
        //Programar lo que te va a mostrar el monitor de las impresiones
        PrinterMonitor monitor = null;
        try{
            PrinterRemote printer =
                    (PrinterRemote) Naming.lookup(printerUrl);
            monitor = new PrinterMonitor(printer);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(monitor != null)
            monitor.report();
        else
            System.out.println("Printer Monitor is null!");
    }
}
