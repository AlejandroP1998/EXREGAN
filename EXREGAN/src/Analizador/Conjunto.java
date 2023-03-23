package Analizador;

import java.util.ArrayList;
import java.util.Arrays;

public class Conjunto {

    ArrayList<Conjunto> li = new ArrayList<>();
    public ArrayList<String> items = new ArrayList<>();
    public String nombre;

    public Conjunto() {
    }

    public Conjunto(String nombre, String elementos) {
        this.nombre = nombre;
        if (elementos.contains(",")) {
            String[] sep = elementos.split(",");
            this.items.addAll(Arrays.asList(sep));
        }
        if (elementos.contains("~")) {
            String[] sep = elementos.split("~");
            boolean entero = false;
            boolean ascii = false;
            try {
                if (Integer.parseInt(sep[0]) > 0) {
                    entero = true;
                }
            } catch (Exception e) {
            }

            if (entero) {
                int i = Integer.parseInt(sep[0]);
                int f = Integer.parseInt(sep[1]);
                for (int c = i; c <= f; ++c) {
                    this.items.add(String.valueOf(c));
                }

            }
            if (!entero) {
                char i = sep[0].charAt(0);
                char f = sep[1].charAt(0);
                if (i >= '!' && i <= '/') {
                    ascii = true;
                }
                if (i >= ':' && i <= '@') {
                    ascii = true;
                }
                if (i >= '[' && i <= '`') {
                    ascii = true;
                }
                if (i >= '{' && i <= '}') {
                    ascii = true;
                }
            }

            if (ascii) {
                char i = sep[0].charAt(0);
                char f = sep[1].charAt(0);
                for (char c = i; c <= f; ++c) {
                    if (c >= '!' && c <= '/') {
                        this.items.add(String.valueOf(c));
                    } else if (c >= ':' && c <= '@') {
                        this.items.add(String.valueOf(c));
                    } else if (c >= '[' && c <= '`') {
                        this.items.add(String.valueOf(c));
                    } else if (c >= '{' && c <= '}') {
                        this.items.add(String.valueOf(c));
                    } else {
                    }
                }
            }

            if (!entero && !ascii) {
                char i = sep[0].charAt(0);
                char f = sep[1].charAt(0);
                for (char c = i; c <= f; ++c) {
                    this.items.add(String.valueOf(c));
                }
            }

        }

    }

    public ArrayList<Conjunto> getLi() {
        return li;
    }

    public void setLi(ArrayList<Conjunto> li) {
        this.li = li;
    }

    public void addtoList(String nombre, String conjunto) {
        li.add(new Conjunto(nombre, conjunto));
        setLi(li);
    }

    public void printList() {
        System.out.println("\nLista de conjuntos\n");
        for (Conjunto item : li) {
            System.out.println("Nombre del conjunto: " + item.nombre + " \nelementos: " + (item.items));
        }
    }

    public ArrayList<Conjunto> sendList() {
        return li;
    }

}
