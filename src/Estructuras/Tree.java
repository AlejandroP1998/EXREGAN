package Estructuras;

import Estructuras.type.Types;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.UUID;
import java.lang.NullPointerException;

public class Tree {

    node root;
    public StringBuilder arbolGraph = new StringBuilder();

    public Tree(String er, ArrayList<node> leaves, ArrayList<ArrayList> table, String name) {
        numLeave numHoja = new numLeave(er);
        Stack pila = new Stack();
        String[] erSplit = er.split("");
        //ArrayList<String> strList = new ArrayList<String>( Arrays.asList(erSplit));
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < erSplit.length; i++) {
            if (null == erSplit[i]) {
                strList.add(erSplit[i]);
            } else {
                switch (erSplit[i]) {
                    case "{": {
                        String conj = "";
                        while (!"}".equals(erSplit[i + 1])) {
                            conj += erSplit[i + 1];
                            i++;
                        }
                        strList.add(conj);
                        break;
                    }
                    case "}":
                        break;
                    case " ":
                        break;
                    case "\"": {

                        String conj = "";
                        while (!"\"".equals(erSplit[i + 1])) {
                            conj += erSplit[i + 1];
                            i++;
                        }
                        switch (conj) {
                            case "|":
                                conj = "OR";
                                break;
                            case ".":
                                conj = "AND";
                                break;
                            case "*":
                                conj = "KLEENE";
                                break;
                            case "+":
                                conj = "PLUS";
                                break;
                            case "?":
                                conj = "ITR";
                                break;
                            default:
                                break;
                        }
                        strList.add(conj);
                        i++;
                        break;
                    }
                    default:
                        strList.add(erSplit[i]);
                        break;
                }
            }
        }
        //System.out.println(strList);
        Collections.reverse(strList);
        try {
            strList.forEach((character) -> {
                switch (character) {
                    case "|":

                        node lefto = (node) pila.pop();
                        node righto = (node) pila.pop();
                        node no = new node(character, Types.OR, 0, lefto, righto, leaves, table);

                        pila.push(no);
                        break;

                    case ".":

                        node lefta = (node) pila.pop();
                        node righta = (node) pila.pop();
                        node na = new node(character, Types.AND, 0, lefta, righta, leaves, table);

                        pila.push(na);

                        break;

                    case "*":

                        node unario = (node) pila.pop();
                        node nk = new node(character, Types.KLEENE, 0, unario, null, leaves, table);

                        pila.push(nk);
                        break;

                    case "+":

                        node unariop = (node) pila.pop();
                        node nkp = new node(character, Types.PLUS, 0, unariop, null, leaves, table);

                        pila.push(nkp);
                        break;

                    case "?":

                        node leftitr = (node) pila.pop();
                        node rightitr = (node) pila.pop();
                        node nitr = new node(character, Types.AND, 0, leftitr, rightitr, leaves, table);

                        pila.push(nitr);
                        break;
                    default:
                        switch (character) {
                            case "OR":
                                character = "|";
                                break;
                            case "AND":
                                character = ".";
                                break;
                            case "KLEENE":
                                character = "*";
                                break;
                            case "PLUS":
                                character = "+";
                                break;
                            case "ITR":
                                character = "?";
                                break;
                            default:
                                break;
                        }

                        node nd = new node(character, Types.HOJA, numHoja.getNum(), null, null, leaves, table);
                        pila.push(nd);
                        //System.out.println(nd.lexeme);
                        leave hoja = new leave();
                        hoja.addLeave(nd, leaves);
                        break;
                }
            });
            this.root = (node) pila.pop();
            arbolGraph.append("digraph G{\n graph [dpi=1000];\n label=<Arbol ").append(name).append(">"
                    + "\n labelloc = t;\n fontsize = 30; \n splines=false;\n\n");
            String rootName = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            generarArbol(this.root, rootName);
        } catch (EmptyStackException | NullPointerException e) {
            System.out.println("No se logro leer la expresion: "+name);
        }

    }

    public node getRoot() {
        return this.root;
    }

    private void generarArbol(node nodo, String nodeName) {
        arbolGraph.append(nodeName).append("[label=\"").append(nodo.lexeme).append("\"];\n");

        if (nodo.left != null) {
            String nodoleft = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            arbolGraph.append("\t").append(nodeName).append(" -> ").append(nodoleft).append(";\n");
            generarArbol((node) nodo.left, nodoleft);
        }

        if (nodo.right != null) {
            String nodoright = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            arbolGraph.append("\t").append(nodeName).append(" -> ").append(nodoright).append(";\n");
            generarArbol((node) nodo.right, nodoright);
        }

    }

    public void GenerarDot(String cadena, String name) {
        FileWriter fichero = null;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\Arboles_201712602\\" + name + ".dot";
        try {
            fichero = new FileWriter(ruta);
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(cadena);
            pw.write(cadena);
            pw.close();
            fichero.close();
            GenerarImagen(ruta, name);
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

    public void GenerarImagen(String ruta, String name) {
        try {

            ProcessBuilder pbuilder;
            String imagenRuta = "C:\\Users\\1998j\\OneDrive\\Documentos\\Semestres\\1S 2023\\Compiladores 1\\Proyecto 1\\Reportes\\Arboles_201712602\\" + name + ".jpg";
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
