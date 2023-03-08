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
    
    public void analizarER(String er, String expName){
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();
        
        er = "." + er + "#";
        
        Tree arbol = new Tree(er, leaves, table); // CREA EL ARBOL
        node raiz = arbol.getRoot();
        
        raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
        raiz.follow();
        followTable ft = new followTable();
        String str = ft.printTable(table,expName);
        ft.GenerarDot(str,expName);
        transitionTable tran = new transitionTable(raiz, table, leaves); // bug
        String str2 = tran.impTable(expName);
        tran.GenerarDot(str2,expName);
    }

}
