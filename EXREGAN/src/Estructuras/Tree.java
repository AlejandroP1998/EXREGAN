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

public class Tree {

    node root;
    int counter = 0;
    public String tbl = "";
    public String fin, refFin = null;
    public String refInicio  = "node" + UUID.randomUUID().toString().replace("-", "");
    public String inicio  = refInicio + "[label=\"S" + counter + "\"]\n";
    public StringBuilder arbolGraph = new StringBuilder();
    public StringBuilder afnd = new StringBuilder();
    public boolean primero = false;

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
                        //Metodo del arbol
                        node lefto = (node) pila.pop();
                        node righto = (node) pila.pop();
                        node no = new node(character, Types.OR, 0, lefto.getNode(), righto, leaves, table);
                        pila.push(no);
                        break;

                    case ".":

                        //Metodo del arbol
                        node lefta = (node) pila.pop();
                        node righta = (node) pila.pop();
                        node na = new node(character, Types.AND, 0, lefta.getNode(), righta.getNode(), leaves, table);
                        pila.push(na);
                        break;

                    case "*":
                        //Metodo del arbol
                        node unario = (node) pila.pop();
                        node nk = new node(character, Types.KLEENE, 0, unario.getNode(), null, leaves, table);
                        pila.push(nk);
                        break;

                    case "+":

                        //Metodo del arbol
                        node unariop = (node) pila.pop();
                        node nkp = new node(character, Types.PLUS, 0, unariop.getNode(), null, leaves, table);
                        pila.push(nkp);
                        break;

                    case "?":
                        //Metodo del arbol
                        node leftitr = (node) pila.pop();
                        node rightitr = (node) pila.pop();
                        node nitr = new node(character, Types.AND, 0, leftitr.getNode(), rightitr, leaves, table);
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

                        pila.push(nd.getNode());
                        //System.out.println(nd.lexeme);
                        leave hoja = new leave();
                        hoja.addLeave(nd, leaves);
                        break;
                }
            });
            this.root = (node) pila.pop();
            arbolGraph.append("digraph G{\n graph [dpi=1000];\n label=<Arbol ").append(name).append(">"
                    + "\n labelloc = t;\n fontsize = 30; \n splines=false;\n\n");
            tbl += "digraph G{"
                    + "tbl [\n"
                    + "shape=plaintext\n"
                    + "label=<\n"
                    + "<table border='0' cellborder='1' cellspacing='2'>\n"
                    + "<tr><td color='blue' bgcolor='blue'>nodo n</td><td color='blue' bgcolor='blue'>anulable</td><td color='blue' bgcolor='blue'>primerapos(n)</td><td color='blue' bgcolor='blue'>ultimapos(n)</td></tr>";
            afnd.append("digraph G{\n graph [dpi=1000];\n label=<AFND ").append(name).append(">"
                    + "\n labelloc = t;\n fontsize = 30; rankdir=LR;\n\n");
            String rootName = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            generarArbol(this.root, rootName);
        } catch (EmptyStackException | NullPointerException e) {
        }

    }

    public node getRoot() {
        return this.root;
    }

    private void generarArbol(node nodo, String nodeName) {
        //ε simbolo para hacer transiciones con epsilon
        arbolGraph.append(nodeName).append("[label=\"").append(nodo.lexeme).append("\"];\n");
        tbl += "<tr><td>" + nodo.lexeme + "</td><td>" + nodo.anullable + "</td><td>" + nodo.first.toString() + "</td><td>" + nodo.last.toString() + "</td></tr>\n";

        if (nodo.left != null) {
            String nodoleft = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            arbolGraph.append("\t").append(nodeName).append(" -> ").append(nodoleft).append(";\n");
            if ("#".equals(nodo.lexeme) && primero == true) {
            } else {
                switch (nodo.lexeme) {
                    case "|":
                        if (nodo.type.equals(Types.OR)) {
                            String epsilon1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon1 = epsilon1 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon2 = epsilon2 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon3 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon3 = epsilon3 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon4 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon4 = epsilon4 + "[label=\"ε\" shape=\"none\"]\n";
                            String estado1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado1 = estado1 + "[label=\"S"+(counter++)+"\"]\n";
                            String estado2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado2 = estado2 + "[label=\"S"+(counter++)+"\"]\n";
                            String estado3 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado3 = estado3 + "[label=\"S"+(counter++)+"\"]\n";
                            String estado4 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado4 = estado4 + "[label=\"S"+(counter++)+"\"]\n";
                            node iz = (node) nodo.left;
                            node dr = (node) nodo.right;
                            String nodoI = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoI = nodoI + "[label=\"" + iz.lexeme + "\" shape=\"none\"]\n";
                            String nodoD = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoD = nodoD + "[label=\"" + dr.lexeme + "\" shape=\"none\"]\n";
                            refFin = "node" + UUID.randomUUID().toString().replace("-", "");
                            fin = refFin + "[label=\"S" + (counter++) + "\"]\n";

                            afnd.append(inicio).append("\n");
                            afnd.append(fin).append("\n");
                            afnd.append(nodoEpsilon1).append("\n");
                            afnd.append(nodoEpsilon2).append("\n");
                            afnd.append(nodoEpsilon3).append("\n");
                            afnd.append(nodoEpsilon4).append("\n");
                            afnd.append(refNodoI).append("\n");
                            afnd.append(refNodoD).append("\n");
                            afnd.append(nodoEstado1).append("\n");
                            afnd.append(nodoEstado2).append("\n");
                            afnd.append(nodoEstado3).append("\n");
                            afnd.append(nodoEstado4).append("\n");
                            
                            
                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon1)
                                    .append(" -> ").append(estado1)
                                    .append(" -> ").append(nodoI)
                                    .append(" -> ").append(estado2)
                                    .append(" -> ").append(epsilon2)
                                    .append(" -> ").append(refFin).append(";\n");
                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon3)
                                    .append(" -> ").append(estado3)
                                    .append(" -> ").append(nodoD)
                                    .append(" -> ").append(estado4)
                                    .append(" -> ").append(epsilon4)
                                    .append(" -> ").append(refFin).append(";\n");
                            inicio = fin;
                            refInicio = refFin;
                        }
                        break;

                    case ".":
                        if (nodo.type.equals(Types.AND)) {
                            
                            node iz = (node) nodo.left;
                            node dr = (node) nodo.right;
                            String nodoI = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoI = nodoI + "[label=\"" + iz.lexeme + "\" shape=\"none\"]\n";
                            String nodoD = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoD = nodoD + "[label=\"" + dr.lexeme + "\" shape=\"none\"]\n";
                            String estado1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado1 = estado1 + "[label=\"S"+(counter++)+"\"]\n";
                            refFin = "node" + UUID.randomUUID().toString().replace("-", "");
                            fin = refFin + "[label=\"S" + (counter++) + "\"]\n";

                            afnd.append(inicio).append("\n");
                            afnd.append(fin).append("\n");
                            afnd.append(refNodoI).append("\n");
                            afnd.append(refNodoD).append("\n");
                            afnd.append(nodoEstado1).append("\n");

                            afnd.append(refInicio)
                                    .append(" -> ").append(nodoI)
                                    .append(" -> ").append(estado1)
                                    .append(" -> ").append(nodoD)
                                    .append(" -> ").append(refFin);
                            inicio = fin;
                            refInicio = refFin;
                        }
                        break;
                    case "*":
                        if (nodo.type.equals(Types.KLEENE)) {
                            String epsilon1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon1 = epsilon1 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon2 = epsilon2 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon3 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon3 = epsilon3 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon4 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon4 = epsilon4 + "[label=\"ε\" shape=\"none\"]\n";
                            node iz = (node) nodo.left;
                            String nodoI = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoI = nodoI + "[label=\"" + iz.lexeme + "\" shape=\"none\"]\n";
                            String estado1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado1 = estado1 + "[label=\"S"+(counter++)+"\"]\n";
                            String estado2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado2 = estado2 + "[label=\"S"+(counter++)+"\"]\n";
                            refFin = "node" + UUID.randomUUID().toString().replace("-", "");
                            fin = refFin + "[label=\"S" + (counter++) + "\"]\n";

                            afnd.append(inicio).append("\n");
                            afnd.append(fin).append("\n");
                            afnd.append(nodoEpsilon1).append("\n");
                            afnd.append(nodoEpsilon2).append("\n");
                            afnd.append(nodoEpsilon3).append("\n");
                            afnd.append(nodoEpsilon4).append("\n");
                            afnd.append(refNodoI).append("\n");
                            afnd.append(nodoEstado1).append("\n");
                            afnd.append(nodoEstado2).append("\n");

                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon1)
                                    .append(" -> ").append(estado1)
                                    .append(" -> ").append(nodoI)
                                    .append(" -> ").append(estado2)
                                    .append(" -> ").append(epsilon2)
                                    .append(" -> ").append(estado1)
                                    .append(";\n");
                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon3)
                                    .append(" -> ").append(refFin).append(";\n");
                            afnd.append("S").append(counter)
                                    .append(" -> ").append(epsilon4)
                                    .append(" -> ").append(refFin).append(";\n");
                            inicio = fin;
                            refInicio = refFin;
                        }
                        break;
                    case "+":
                        if (nodo.type.equals(Types.PLUS)) {
                            String epsilon1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon1 = epsilon1 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon2 = epsilon2 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon3 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon3 = epsilon3 + "[label=\"ε\" shape=\"none\"]\n";
                            String epsilon4 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEpsilon4 = epsilon4 + "[label=\"ε\" shape=\"none\"]\n";
                            node iz = (node) nodo.left;
                            String nodoI = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoI = nodoI + "[label=\"" + iz.lexeme + "\" shape=\"none\"]\n";
                            String estado1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado1 = estado1 + "[label=\"S"+(counter++)+"\"]\n";
                            String estado2 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado2 = estado2 + "[label=\"S"+(counter++)+"\"]\n";
                            refFin = "node" + UUID.randomUUID().toString().replace("-", "");
                            fin = refFin + "[label=\"S" + (counter++) + "\"]\n";

                            afnd.append(inicio).append("\n");
                            afnd.append(fin).append("\n");
                            afnd.append(nodoEpsilon1).append("\n");
                            afnd.append(nodoEpsilon2).append("\n");
                            afnd.append(nodoEpsilon3).append("\n");
                            afnd.append(nodoEpsilon4).append("\n");
                            afnd.append(refNodoI).append("\n");
                            afnd.append(nodoEstado1).append("\n");
                            afnd.append(nodoEstado2).append("\n");

                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon1)
                                    .append(" -> ").append(estado1)
                                    .append(" -> ").append(nodoI)
                                    .append(" -> ").append(estado2)
                                    .append(" -> ").append(epsilon2)
                                    .append(" -> ").append(estado1)
                                    .append(";\n");
                            afnd.append(refInicio)
                                    .append(" -> ").append(epsilon3)
                                    .append(" -> ").append(refFin).append(";\n");
                            afnd.append("S").append(counter)
                                    .append(" -> ").append(epsilon4)
                                    .append(" -> ").append(refFin).append(";\n");
                            inicio = fin;
                            refInicio = refFin;
                        }
                        break;
                    case "?":
                        if (nodo.type.equals(Types.ITR)) {
                            node iz = (node) nodo.left;
                            node dr = (node) nodo.right;
                            String nodoI = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoI = nodoI + "[label=\"" + iz.lexeme + "\" shape=\"none\"]\n";
                            String nodoD = "node" + UUID.randomUUID().toString().replace("-", "");
                            String refNodoD = nodoD + "[label=\"" + dr.lexeme + "\" shape=\"none\"]\n";
                            String estado1 = "node" + UUID.randomUUID().toString().replace("-", "");
                            String nodoEstado1 = estado1 + "[label=\"S"+(counter++)+"\"]\n";
                            refFin = "node" + UUID.randomUUID().toString().replace("-", "");
                            fin = refFin + "[label=\"S" + (counter++) + "\"]\n";

                            afnd.append(inicio).append("\n");
                            afnd.append(fin).append("\n");
                            afnd.append(refNodoI).append("\n");
                            afnd.append(refNodoD).append("\n");
                            afnd.append(nodoEstado1).append("\n");

                            afnd.append(refInicio)
                                    .append(" -> ").append(nodoI)
                                    .append(" -> ").append(estado1)
                                    .append(" -> ").append(nodoD)
                                    .append(" -> ").append(refFin);
                            inicio = fin;
                            refInicio = refFin;
                        }
                        break;
                    default:
                        break;
                }
            }
            primero = true;
            generarArbol((node) nodo.left, nodoleft);
        }

        if (nodo.right != null) {
            String nodoright = "node" + UUID.randomUUID().toString().replaceAll("-", "");
            arbolGraph.append("\t").append(nodeName).append(" -> ").append(nodoright).append(";\n");
            primero = true;
            generarArbol((node) nodo.right, nodoright);
        }

    }

    public void GenerarDot(String cadena, String name) {
        FileWriter fichero = null;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\Arboles_201712602\\" + name + ".dot";
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
            String imagenRuta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\Arboles_201712602\\" + name + ".jpg";
            pbuilder = new ProcessBuilder("dot", "-Tjpg", "-o",
                    imagenRuta,
                    ruta);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (IOException e) {
            //System.out.println(e);
        }
    }

    public void GenerarDotThompson(String cadena, String name) {
        FileWriter fichero = null;
        String ruta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\AFND_201712602\\" + name + ".dot";
        try {
            fichero = new FileWriter(ruta);
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            //System.out.println(cadena);
            pw.write(cadena);
            pw.close();
            fichero.close();
            GenerarImagenThompson(ruta, name);
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

    public void GenerarImagenThompson(String ruta, String name) {
        try {

            ProcessBuilder pbuilder;
            String imagenRuta = "C:\\Users\\1998j\\OneDrive\\Desktop\\Proyecto 1\\Reportes\\AFND_201712602\\" + name + ".jpg";
            pbuilder = new ProcessBuilder("dot", "-Tjpg", "-o",
                    imagenRuta,
                    ruta);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (IOException e) {
            //System.out.println(e);
        }
    }

}
