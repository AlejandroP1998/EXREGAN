package Analizador;
import java_cup.runtime.Symbol;

%%

%{
    /* Codigo de usuario */
%}

%class scanner
%cup
%public
%line
%char
%unicode
%ignorecase


/* Simbolos */
PUNTO = "."
DISY = "|"
MULT = "*"
PLUS = "+"
ITR = "?"
TILDE = "~"
COMA = ","
COM_SIMPLE = "\'"
COM_DOBLE = "\""
DOS_PUNTOS = ":"
PUNTO_COMA = ";"
LLAV_ABIERTA = "{"
LLAV_CERRADA = "}"

/* Palabras reservadas */
CONJUNTO = "CONJ"

/* Expresiones */
ENTERO = [0-9]+
DECIMAL = [0-9]+("."[ |0-9]+)?
LETRA = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
IDENTIFICADOR = ({LETRA}|{ENTERO}) ({LETRA}|{ENTERO})*
SPACE   = [ ,\t,\r]+
ENTER   = [\ \n]
LINEA = "\n"
COMENTARIO_SIMPLE = "//"({SPACE}|{LETRA}|{ENTERO}) ({SPACE}|{LETRA}|{ENTERO})*
COMENTARIO_EXTENSO = "<!"({ENTER}|{SPACE}|{LETRA}|{ENTERO}) ({ENTER}|{SPACE}|{LETRA}|{ENTERO})* "!>"

/* Operador de asignación */
OPERADOR = "->"

%%

<YYINITIAL> {CONJUNTO} { return new Symbol(sym.CONJUNTO, yyline, yycolumn, yytext());}

<YYINITIAL> {PUNTO} { return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());}

<YYINITIAL> {DISY} { return new Symbol(sym.DISY, yyline, yycolumn, yytext());}

<YYINITIAL> {MULT} { return new Symbol(sym.MULT, yyline, yycolumn, yytext());}

<YYINITIAL> {PLUS} { return new Symbol(sym.PLUS, yyline, yycolumn, yytext());}

<YYINITIAL> {ITR} { return new Symbol(sym.ITR, yyline, yycolumn, yytext());}

<YYINITIAL> {TILDE} { return new Symbol(sym.TILDE, yyline, yycolumn, yytext());}

<YYINITIAL> {COMA} { return new Symbol(sym.COMA, yyline, yycolumn, yytext());}

<YYINITIAL> {COM_SIMPLE} { return new Symbol(sym.COM_SIMPLE, yyline, yycolumn, yytext());}

<YYINITIAL> {COM_DOBLE} { return new Symbol(sym.COM_DOBLE, yyline, yycolumn, yytext());}

<YYINITIAL> {DOS_PUNTOS} { return new Symbol(sym.DOS_PUNTOS, yyline, yycolumn, yytext());}

<YYINITIAL> {PUNTO_COMA} { return new Symbol(sym.PUNTO_COMA, yyline, yycolumn, yytext());}

<YYINITIAL> {LLAV_ABIERTA} { return new Symbol(sym.LLAV_ABIERTA, yyline, yycolumn, yytext());}

<YYINITIAL> {LLAV_CERRADA} { return new Symbol(sym.LLAV_CERRADA, yyline, yycolumn, yytext());}

<YYINITIAL> {ENTERO} { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}

<YYINITIAL> {DECIMAL} { return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}

<YYINITIAL> {LETRA} { return new Symbol(sym.LETRA, yyline, yycolumn, yytext());}

<YYINITIAL> {IDENTIFICADOR} { return new Symbol(sym.IDENTIFICADOR, yyline, yycolumn, yytext());}

<YYINITIAL> {OPERADOR} { return new Symbol(sym.OPERADOR, yyline, yycolumn, yytext());}

<YYINITIAL> {SPACE}     { /* Ignorar */ }

<YYINITIAL> {ENTER}     { /* Ignorar */}

<YYINITIAL> {LINEA}     {/* Ignorar */}

<YYINITIAL> {COMENTARIO_SIMPLE} {/* Ignorar */}

<YYINITIAL> {COMENTARIO_EXTENSO} {/* Ignorar */}

<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}