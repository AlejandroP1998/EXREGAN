package Estructuras;
import java.util.Stack;

public class Pila {
    /*
    FILO: First In Last Out -> Primero que entra es el ultimo que sale
    push -> ingresar un elemento a la pila.
    pop -> quitar el ultimo dato que se introdujo en la pila.
    peek -> ver cual es el ultimo dato que se introdujo en la pila.
    empty -> nos dice si esta vacia o no.
    */
    public static void main(String[] args) {
        Stack pila = new Stack();
        pila.push(50); // indice 0
        pila.push("numero"); // indice 1
        //solo se puede obtener el ultimo valor
        Object item = pila.pop();
        System.out.println(item.toString());
    }
}
