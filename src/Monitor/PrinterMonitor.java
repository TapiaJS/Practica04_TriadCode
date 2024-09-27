package Monitor;

import proxy.PrinterRemote;

import java.rmi.*;

public class PrinterMonitor {
    private PrinterRemote printer;

    public PrinterMonitor(PrinterRemote printer) {
        this.printer = printer;
    }
    public void report(){
        try{
            System.out.println("Impression:");
            System.out.println("Current State:" + printer.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
