package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class followTable {

    public void append(int numNode, String lexeme, ArrayList flwList, ArrayList<ArrayList> table) {
        for (ArrayList item : table) {
            if ((int) item.get(0) == numNode && item.get(1) == lexeme) {
                for (Object flwItem : flwList) {
                    if (!((ArrayList) item.get(2)).contains((int) flwItem)) {
                        ((ArrayList) item.get(2)).add(flwItem);
                    }
                }
                return;
            }
        }
        ArrayList dato = new ArrayList();
        dato.add(numNode);
        dato.add(lexeme);
        dato.add(flwList);

        table.add(dato);
    }

    public ArrayList next(int numNode, ArrayList<ArrayList> table) {
        ArrayList result = new ArrayList();
        for (ArrayList item : table) {
            if ((int) item.get(0) == numNode) {
                result.add(item.get(1));
                result.add(((ArrayList) item.get(2)).clone());
                return result;
            }
        }
        result.add("");
        result.add(new ArrayList());
        return result;
    }

    public String printTable(ArrayList<ArrayList> table, String erName) {
        StringBuilder str = new StringBuilder();
        str.append("digraph G {").append("\n");
        str.append("graph [ dpi = 700 ];").append("\n");
        str.append("label = <Tabla de siguientes: ").append(erName).append(">\nlabelloc = t\nfontsize=30").append("\n");
        str.append("tbl [").append("\n");
        str.append("shape=plaintext").append("\n");
        str.append("label=<").append("\n");
        str.append("<table border='0' cellborder='1' cellspacing='2'>").append("\n");
        str.append("<tr><td colspan='2' color='blue' "
                + "bgcolor='blue'>_____Hoja_____</td><td color='blue' "
                + "bgcolor='blue'>_____Siguientes_____</td></tr>").append("\n");
        for (ArrayList item : table) {
            str.append("<tr>"
                    + "<td>").append(item.get(1)).append("</td>"
                    + "<td>").append(item.get(0)).append("</td>"
                    + "<td>").append(item.get(2)).append("</td>"
                    + "</tr>").append("\n");
            //System.out.println(item.get(0) + " - " + item.get(1) + " - " + item.get(2));
        }
        str.append("</table>").append("\n");
        str.append(">];").append("\n");
        str.append("}").append("\n");
        String chain = str.toString();
        return chain;
    }

    public void GenerarDot(String cadena,String name) {
        FileWriter fichero = null;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\SIGUIENTES_201712602\\"+name+".dot";
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
            String imagenRuta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\SIGUIENTES_201712602\\"+name+".jpg";
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
