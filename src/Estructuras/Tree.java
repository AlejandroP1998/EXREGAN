
package Estructuras;

import Estructuras.type.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Tree {

    node root;

    public Tree(String er, ArrayList<node> leaves, ArrayList<ArrayList> table) {

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
                    node nd = new node(character, Types.HOJA, numHoja.getNum(), null, null, leaves, table);
                    pila.push(nd);
                    leave hoja = new leave();
                    hoja.addLeave(nd, leaves);
                    break;
            }
        });
        this.root = (node) pila.pop();
    }

    public node getRoot() {
        return this.root;
    }

}
