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
    public ArrayList<String> errors = new ArrayList<>();

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
            String ruta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\SALIDAS_201712602\\salida.json";
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

    public void Errores(String error) {
        String p1 = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "  <meta charset=\"UTF-8\">\n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
                + "    integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\n"
                + "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                + "  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                + "  <link href=\"https://fonts.googleapis.com/css2?family=Bungee+Spice&display=swap\" rel=\"stylesheet\">\n"
                + "  <style>\n"
                + "    h1{\n"
                + "      font-family: 'Bungee Spice', cursive;\n"
                + "      font-size: 4rem;\n"
                + "      text-align: center;\n"
                + "    }\n"
                + "    ul li{\n"
                + "      font-size: 2rem;\n"
                + "    }\n"
                + "  </style>\n"
                + "</head>\n"
                + "<title>Errores</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "  <div class=\"container d-flex flex-column justify-content-center align-items-center my-5\">\n"
                + "    <h1 class=\"p-4\">Listado de errores encontrados en la compilación</h1>\n"
                + "    <ul>";

        String p2 = "</ul>\n"
                + "  </div>\n"
                + "\n"
                + "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"\n"
                + "    integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\"\n"
                + "    crossorigin=\"anonymous\"></script>\n"
                + "</body>\n"
                + "</body>\n"
                + "\n"
                + "</html>";

        this.errors.add(error);
        FileWriter fichero;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\ERRORES_201712602\\errores.html";
        try {
            fichero = new FileWriter(ruta);
            PrintWriter pw;
            pw = new PrintWriter(fichero);
            pw.write(p1);
            for (int i = 0; i < this.errors.size(); i++) {
                pw.write("\t\t<li>" + this.errors.get(i) + "</li>\n");
            }
            pw.write(p2);
            pw.close();
            fichero.close();
        } catch (IOException e) {
        }

    }

}
