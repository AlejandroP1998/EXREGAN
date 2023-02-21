/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author bulleye
 */
public class Conjunto {

    LinkedList<Conjunto> li = new LinkedList<>();
    public String[] items;
    public String nombre;

    public Conjunto() {
    }

    public Conjunto(String nombre, String elementos) {
        this.nombre = nombre;
        if(elementos.contains(",")){
            this.items = elementos.split(",");
        }
        if(elementos.contains("~")){
            this.items = elementos.split("~");
        }

    }

    public LinkedList<Conjunto> getLi() {
        return li;
    }

    public void setLi(LinkedList<Conjunto> li) {
        this.li = li;
    }

    public void addtoList(String nombre, String conjunto) {
        li.add(new Conjunto(nombre, conjunto));
        setLi(li);
    }

    public void printList() {
        System.out.println("\nLista de conjuntos\n");
        for (Conjunto item : li) {
            System.out.println("Nombre del conjunto: " + item.nombre + " \nelementos: " + Arrays.toString(item.items));
        }
    }
    
    public LinkedList<Conjunto> sendList(){
        return li;
    }
    
}
