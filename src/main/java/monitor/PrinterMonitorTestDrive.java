package monitor;

import proxy.PrinterRemote;

import java.rmi.Naming;

public class PrinterMonitorTestDrive {
    public static void main(String[] args) {
        String printerUrl = "rmi://dos.com/printer";
        PrinterMonitor monitor = null;

        try{
            PrinterRemote printer = (PrinterRemote) Naming.lookup(printerUrl);
            monitor = new PrinterMonitor(printer);
            System.out.println("Prueba" + monitor);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(monitor != null)
            monitor.report();
        else
            System.out.println("Printer Monitor is null!");
    }
}
