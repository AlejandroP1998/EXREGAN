package App;

import Analizador.Conjunto;
import Estructuras.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;

public class Brain {

    Conjunto conj = new Conjunto();
    public ArrayList<listAFD> lista = new ArrayList<>();
    public JSONArray arr = new JSONArray();

    public Brain() {
    }

    public void addConj(String conjunto, String elemento) {
        conj.addtoList(conjunto, elemento);
    }

    public void analizarER(String er, String expName) {
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();
        er = "." + er + "#";
        try {
            Tree arbol = new Tree(er, leaves, table, expName); // CREA EL ARBOL
            arbol.arbolGraph.append("}");
            if (!arbol.primero) {
                System.out.println("No se logro leer la expresion " + expName);
            }
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
            listAFD li = tran.lista;
            //System.out.println(li.name);
            lista.add(li);
        } catch (Exception e) {
            //System.out.println("No se logro leer la expresion: "+expName);
        }

    }

    public void AnalizarEntrada(String name, String cadena) {
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).name.equals(name)) {
                arr.add(lista.get(i).validarCadena(name, cadena, conj.getLi()));
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            FileWriter fichero;
            String ruta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\SALIDAS_201712602\\salida.json";
            try {
                fichero = new FileWriter(ruta);
                PrintWriter pw;
                pw = new PrintWriter(fichero);
                pw.write(arr.toJSONString());
                pw.close();
                fichero.close();
            } catch (IOException e) {
            }
        } else {
            System.out.println("No se encontro la expresion " + name);
        }

    }

}
