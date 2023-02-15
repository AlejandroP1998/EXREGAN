/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

/**
 *
 * @author bulleye
 */
public class Generador {

    public static void main(String[] args) {
        generarCompilador();
    }

    private static void generarCompilador() {
        try {
            String ruta = "src/Analizador/";
            String opcFlex[] = {ruta + "Lexer.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);

            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "Parser.cup"};
            java_cup.Main.main(opcCUP);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
