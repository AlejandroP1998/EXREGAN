package Estructuras;

import java.util.ArrayList;

public class runnable {

    public static void main(String[] args) {

        String er = ".|{minuscula} {mayuscula} . + | | | {simbolos} {minuscula} {mayuscula} {numero} . \"@\" . + | {minuscula}{mayuscula} . \".\". \"c\" . \"o\" \"m\"";

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
            arbol.afnd.append("}");
            String chain2 = arbol.afnd.toString();
            arbol.GenerarDotThompson(chain2, "afnd de prueba");
        } catch (NullPointerException e) {
        }

    }

}
