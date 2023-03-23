package Estructuras;

import java.util.ArrayList;

public class nodeAFD {

    public String estado;
    public ArrayList<String> data = new ArrayList<>();
    public boolean repetitive;
    nodeAFD next, prev;
    public boolean leido = false;

    //Constructor para cuando no hay nodos
    public nodeAFD(String estado, String dato) {
        this(estado, (dato), false, null, null);
    }

    public nodeAFD(String estado, String dato, boolean repetitive, nodeAFD next, nodeAFD prev) {
        this.estado = estado;
        this.data.add(dato);
        if (this.repetitive == true) {
            this.repetitive = true;
        } else {
            this.repetitive = repetitive;
        }
        this.next = next;
        this.prev = prev;
        if(this.leido == true){
        }else{
            this.leido = false;
        }
        
    }

}
