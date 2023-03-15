package App;

import Analizador.Conjunto;
import Estructuras.Tree;
import Estructuras.followTable;
import Estructuras.node;
import Estructuras.transitionTable;
import java.util.ArrayList;

public class Brain {

    Conjunto conj = new Conjunto();

    public Brain() {
    }

    public void addConj(String conjunto, String elemento) {
        conj.addtoList(conjunto, elemento);
    }

    public void printListConj() {
        conj.printList();
    }

    public void analizarER(String er, String expName) {
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();
        er = "." + er + "#";
        try {
            Tree arbol = new Tree(er, leaves, table, expName); // CREA EL ARBOL
            arbol.arbolGraph.append("}");
            String chain = arbol.arbolGraph.toString();
            arbol.GenerarDot(chain, expName);
            node raiz = arbol.getRoot();
            arbol.afnd.append("}");
            String chain2 = arbol.afnd.toString();
            arbol.GenerarDotThompson(chain2, expName);

            raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
            raiz.follow();
            followTable ft = new followTable();
            String str = ft.printTable(table, expName);
            ft.GenerarDot(str, expName);
            transitionTable tran = new transitionTable(raiz, table, leaves); // bug
            String str2 = tran.impTable(expName);
            tran.GenerarDot(str2, expName);
        } catch (NullPointerException e) {
            System.out.println("No se logro leer la expresion: "+expName);
        }

    }

}
