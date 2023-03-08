package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class transitionTable {

    public ArrayList<ArrayList> states;
    public int cont;

    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
        this.states = new ArrayList();

        ArrayList datos = new ArrayList();
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);

        this.states.add(datos);
        this.cont = 1;

        for (int i = 0; i < states.size(); i++) {
            ArrayList state = states.get(i);
            ArrayList<Integer> elementos = (ArrayList) state.get(1);

            // TODO  Aqui se encuentra el bug
            for (int hoja : elementos) {
                followTable sigTabla = new followTable();
                ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();

                boolean existe = false;
                String found = "";

                for (ArrayList e : states) {
                    if (e.get(1).equals(lexemeNext.get(1))) {
                        existe = true;
                        found = (String) e.get(0);
                        break;
                    }
                }

                if (!existe) {
                    leave hojas = new leave();
                    if (hojas.isAccept(hoja, leaves)) {
                        state.set(3, true);
                    }
                    if (lexemeNext.get(0) == "") {
                        continue;
                    }

                    ArrayList nuevo = new ArrayList();
                    nuevo.add("S" + cont);
                    nuevo.add(lexemeNext.get(1));
                    nuevo.add(new ArrayList());
                    nuevo.add(false);

                    transicion trans = new transicion(state.get(0) + "", lexemeNext.get(0) + "", nuevo.get(0) + "");
                    ((ArrayList) state.get(2)).add(trans);

                    cont += 1;
                    states.add(nuevo);

                } else {
                    leave hojas = new leave();
                    if (hojas.isAccept(hoja, leaves)) {
                        state.set(3, true);
                    }

                    boolean trans_exist = false;

                    for (Object trans : (ArrayList) state.get(2)) {
                        transicion t = (transicion) trans;
                        if (t.compare(state.get(0) + "", lexemeNext.get(0) + "")) {
                            trans_exist = true;
                            break;
                        }
                    }
                    if (!trans_exist) {
                        transicion trans = new transicion(state.get(0) + "", lexemeNext.get(0) + "", found + "");
                        ((ArrayList) state.get(2)).add(trans);
                    }
                }
            }

        }
    }

    public String impTable(String expName) {
        StringBuilder str = new StringBuilder();
        str.append("digraph G {").append("\n");
        str.append("graph [ dpi = 700 ];").append("\n");
        str.append("label = <Tabla de transiciones: ").append(expName).append(">\nlabelloc = t\nfontsize=30").append("\n");
        str.append("tbl [").append("\n");
        str.append("shape=plaintext").append("\n");
        str.append("label=<").append("\n");
        str.append("<table border='0' cellborder='1' cellspacing='2'>").append("\n");
        str.append("<tr><td color='blue' bgcolor='blue'>_____Estado_____</td><td colspan='2' color='blue' bgcolor='blue'>_____Transiciones_____</td></tr>").append("\n");
        for (ArrayList state : states) {
            String tran = "[";

            for (Object tr : (ArrayList) state.get(2)) {
                transicion t = (transicion) tr;
                tran += t.toString() + ", ";
            }
            tran += "]";

            tran = tran.replace(", ]", "");
            tran = tran.replace("->", "");
            tran = tran.replace("[", "");
            tran = tran.replace("]", "");
            String[] estados = tran.split(" ");
            
            str.append("<tr>"
                    + "<td>").append(state.get(0)).append("</td>"
                    + "<td>").append(estados[0]).append("</td>"
                    + "<td>").append(estados[estados.length-1]).append("</td>"
                    + "</tr>").append("\n");
            //System.out.println(state.get(0) + " " + state.get(1) + " " + tran + " " + state.get(3));
        }
        str.append("</table>").append("\n");
        str.append(">];").append("\n");
        str.append("}").append("\n");
        String chain = str.toString();
        return chain;
    }

    public void GenerarDot(String cadena,String name) {
        FileWriter fichero = null;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\TRANSICIONES_201712602\\"+name+".dot";
        try {
            fichero = new FileWriter(ruta);
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(cadena);
            pw.write(cadena);
            pw.close();
            fichero.close();
            dibujarGraphviz(ruta,name);
        } catch (IOException e) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
    }

    public void dibujarGraphviz(String ruta,String name) {
        try {

            ProcessBuilder pbuilder;
            String imagenRuta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\TRANSICIONES_201712602\\"+name+".jpg";
            pbuilder = new ProcessBuilder("dot", "-Tjpg", "-o",
                    imagenRuta,
                    ruta);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
