package proxy;

import singleton.Printer;

public class PrinterState implements State{
    private static final long serialVersionUID = 2L;
    transient Printer printer;
    public void waitingPrint(){
        System.out.println("Waiting for printer");
    }
    public void printing(){
        System.out.println("Printing...");
    }
    public void printed(){
        System.out.println("Printed :)");
    }
}
