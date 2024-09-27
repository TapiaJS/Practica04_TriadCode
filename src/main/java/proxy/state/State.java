package proxy.state;

import java.io.*;

public interface State extends Serializable {
    void waitingPrint();
    void printing();
    void printed();
}
