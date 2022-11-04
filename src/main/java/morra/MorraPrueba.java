package morra;

import paresnones.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class MorraPrueba {

    public static void main(String[] args) {
        //VARIABLES
        String opcion = "";
        String eleccionUsu = "";
        String eleccionMaq = "";
        int dedosUsu;
        int dedosMaq;

        do {
            //MOSTRAR MENU
            menu();

            //LEER MENU
            opcion = leerOpc();

            switch (opcion) {
                case "contra maquina":
                    System.out.println("CONTRA LA MAQUINA");
                    break;
                    
                case "contra amigo":
                    System.out.println("CONTRA UN AMIGO");
                    break;
                    
                case "salir":
                    System.out.println("SALIDA DEL PROGRAMA\n");
                    break;

            }

        } while (!opcion.equalsIgnoreCase("salir"));
    }

    private static Scanner teclado = new Scanner(System.in);

    public static void menu() {
        String menu = """
                    *******************************
                        -> CONTRA LA MAQUINA <-
                       -> CONTRA OTRO JUGADOR <-
                            -> SALIR <-
                    *******************************
                    """;
        System.out.println(menu);
    }

    public static String leerOpc() {
        String opcion;

        do {
            System.out.println("ESCOJA (CONTRA MAQUINA) , (CONTRA AMIGO) O (SALIR)");
            opcion = teclado.nextLine();
            opcion = opcion.toLowerCase();

            if (!opcion.equalsIgnoreCase("contra maquina")
                    && !opcion.equalsIgnoreCase("contra amigo")
                    && !opcion.equalsIgnoreCase("salir")) {

                System.out.println("ESCRIBA BIEN LA OPCIÓN\n");
            }

        } while (!opcion.equalsIgnoreCase("contra maquina")
                && !opcion.equalsIgnoreCase("contra amigo")
                && !opcion.equalsIgnoreCase("salir"));

        return opcion;
    }

    public static String eleccionParNonUsu() {
        String eleccion;
        do {
            System.out.println("ESCOJA PARES O NONES");
            eleccion = teclado.nextLine();
            eleccion = eleccion.toLowerCase();

            if (eleccion.equalsIgnoreCase("pares")) {
                System.out.println("HAS ELEGIDO PARES\n");
            } else if (eleccion.equalsIgnoreCase("nones")) {
                System.out.println("HAS ELEGIDO NONES\n");
            } else {
                System.out.println("ESCRIBA BIEN PARES O NONES\n");
            }
        } while (!eleccion.equalsIgnoreCase("pares")
                && !eleccion.equalsIgnoreCase("nones"));

        return eleccion;
    }

    public static String eleccionParNonMaq(String eleccUsu) {
        String eleccionMaq;
        if (eleccUsu.equalsIgnoreCase("pares")) {
            eleccionMaq = "nones";
        } else {
            eleccionMaq = "pares";
        }

        return eleccionMaq;
    }

    public static int dedosUsu() {
        int dedosUsu = 0;
        boolean repetir = true;

        do {
            do {
                try {

                    System.out.println("INDIQUE LA CANTIDAD DE DEDOS");
                    dedosUsu = teclado.nextInt();
                    if (dedosUsu < 0 || dedosUsu > 5) {
                        System.out.println("ESCRIBE BIEN LOS DEDOS\n");
                    }
                    //0 DEDOS SON 1
                    if (dedosUsu == 0) {
                        dedosUsu = 1;
                    }
                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("ESCRIBE UN NUMERO\n");
                    teclado.nextLine();
                }

            } while (repetir);

        } while (dedosUsu < 0 || dedosUsu > 5);

        return dedosUsu;
    }

    public static int dedosMaq() {
        Random alea = new Random();
        int dedosMaq;
        dedosMaq = alea.nextInt(0, 5 + 1);

        //0 DEDOS SON 1
        if (dedosMaq == 0) {
            dedosMaq = 1;
        }
        return dedosMaq;
    }

    public static void ganador(int dedosUsu, int dedosMaq) {
        int sumaDedos;
        String resultado = """
                         *******************************
                         DEDOS JUGADOR: %d
                         DEDOS MAQUINA: %d
                         """.formatted(dedosUsu, dedosMaq);

        sumaDedos = dedosUsu + dedosMaq;

        if (sumaDedos % 2 == 0) {
            System.out.println(resultado);
            System.out.println("GANADOR: PARES");
            System.out.println("*******************************\n");
        } else {
            System.out.println(resultado);
            System.out.println("GANADOR: NONES");
            System.out.println("*******************************\n");
        }
        teclado.nextLine();

    }
}
