package Estructuras;

public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int d, String nom) {
        this.dato = d;
        this.nombre = nom;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    @Override
    public String toString(){
        return nombre + " su dato es: "+dato;
    }
    
}
