package Estructuras;

import Analizador.Conjunto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.json.simple.JSONObject;

public class listAFD {

    private nodeAFD start, end;
    public String name;

    public listAFD(String name) {
        start = end = null;
        this.name = name;
    }

    //metodo para saber si la lista eta vacia
    public boolean isEmpty() {
        return start == null;
    }

    //metodo para buscar en la lista
    public nodeAFD search(String estado) {
        nodeAFD aux = start;
        while (aux != null) {
            if (estado.equals(aux.estado)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    //metodo para agregar nodos al final
    public void addAtEnd(String estado, String dato, boolean repetitive) {
        if (!isEmpty()) {
            nodeAFD existente = this.search(estado);
            if (existente != null) {
                existente.data.add(dato);
            } else {
                end = new nodeAFD(estado, dato, repetitive, null, end);
                end.prev.next = end;
            }

        } else {
            start = end = new nodeAFD(estado, dato);
        }
    }

    //metodo para mostrar la lista de inicio a fin
    public void showList(String name) {
        if (!isEmpty()) {
            String datos = name + "=>";
            nodeAFD aux = start;
            while (aux != null) {
                datos = datos + aux.estado + "[" + aux.data.toString() + "]" + aux.repetitive + "<=>";
                aux = aux.next;
            }
            System.out.println(datos);
        }
    }

    public boolean validar(String item, ArrayList<Conjunto> conjs, String elemento, nodeAFD aux) {
        for (int i = 0; i < conjs.size(); i++) {
            if (aux.data.contains(conjs.get(i).nombre)) {
//                System.out.println("Item: " + item);
//                System.out.println("Data del estado " + aux.estado + " -> " + aux.data);
//                System.out.println("Nombre del conjunto: " + conjs.get(i).nombre);
//                System.out.println("Item: " + item + " esta? " + conjs.get(i).items.contains(item));
                if (conjs.get(i).items.contains(item)) {
                    return true;
                }
            }else if (aux.data.contains(item)) {
//                System.out.println("Item: " + item);
//                System.out.println("Data del estado " + aux.estado + " -> " + aux.data);
//                System.out.println("Item: " + item + " esta? " + aux.data.contains(item));
                return true;
            }
            
        }
        return false;
    }

    public JSONObject validarCadena(String name, String cadena, ArrayList<Conjunto> conjs) {
        String item = null;
        JSONObject json = new JSONObject();
        String[] individuales = cadena.split("");
        Queue<String> cola = new LinkedList<>();
        cola.addAll(Arrays.asList(individuales));
        nodeAFD aux = start;
        while (aux != null) {
            if (aux.repetitive) {
                if (item == null) {
                    item = cola.poll();
                }
                boolean leido = true;
                while (leido == true) {
                    leido = validar(item, conjs, item, aux);
                    aux.leido = leido;
                    item = cola.poll();
                }
                if (aux.leido) {
                    aux = aux.next;
                } else {
                    //System.out.println("La cadena no es valida");
                    break;
                }
            } else {
                if (item == null) {
                    item = cola.poll();
                }
                aux.leido = validar(item, conjs, item, aux);
                if (aux.leido) {
                    item = cola.poll();
                    aux = aux.next;
                } else {
                    //System.out.println("La cadena no es valida");
                    break;
                }
            }

        }
        if (!cola.isEmpty()) {
            json.put("Valor", cadena);
            json.put("ExpresionRegular", name);
            json.put("Resultado", "Cadena invalida");
            System.out.println("cadena invalida");
        } else {
            json.put("Valor", cadena);
            json.put("ExpresionRegular", name);
            json.put("Resultado", "Cadena valida");
            System.out.println("cadena valida");
        }
        return json;
    }

}
