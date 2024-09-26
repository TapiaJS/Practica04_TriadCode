package proxy;

import java.io.Serializable;

public interface State extends Serializable {
    // agregar los posibles estados
    void waitingPrint();
    void printing();
    void printed();
}
