package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;

public class runnable {

    public static void main(String[] args) {

        String er = ".|{minuscula} {mayuscula} . + | | | {simbolos} {minuscula} {mayuscula} {numero} . \"@\" . + | {minuscula}{mayuscula} . \".\". \"c\" . \"o\" \"m\"";
        String entrada = "josue1998@gmail.com";
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();

        er = "." + er + "#";

        try {
            Tree arbol = new Tree(er, leaves, table, "arbol de prueba");
            arbol.arbolGraph.append("}");
            String chain = arbol.arbolGraph.toString();
            arbol.GenerarDot(chain, "arbol de prueba");
            node raiz = arbol.getRoot();
            raiz.getNode();
            raiz.follow();
            followTable ft = new followTable();
            String str = ft.printTable(table, "expresion de prueba");
            ft.GenerarDot(str, "prueba");
            transitionTable tran = new transitionTable(raiz, table, leaves);
            String str2 = tran.impTable("expresion de prueba");
            tran.GenerarDot(str2, "prueba");
            listAFD li = tran.lista;
            JSONArray arr = new JSONArray();
            FileWriter fichero;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\SALIDAS_201712602\\prueba.json";
        try {
            fichero = new FileWriter(ruta);
            PrintWriter pw;
            pw = new PrintWriter(fichero);
            pw.write(arr.toJSONString());
            pw.close();
            fichero.close();
        } catch (IOException e) {

        }
            arbol.afnd.append("}");
            String chain2 = arbol.afnd.toString();
            arbol.GenerarDotThompson(chain2, "afnd de prueba");
        } catch (NullPointerException e) {
        }

    }

}
