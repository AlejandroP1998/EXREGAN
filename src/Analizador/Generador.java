package Analizador;

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
