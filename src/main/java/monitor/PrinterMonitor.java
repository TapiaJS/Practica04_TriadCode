package monitor;

import proxy.PrinterRemote;

import java.rmi.RemoteException;

public class PrinterMonitor {
    PrinterRemote printer;

    public PrinterMonitor(PrinterRemote printer){
        this.printer = printer;
    }

    public void report(){
        try {
            System.out.println("Estado de la impresora:");
            printer.getState().waitingPrint();
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
