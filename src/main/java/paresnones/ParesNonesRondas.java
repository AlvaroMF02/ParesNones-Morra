package paresnones;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class ParesNonesRondas {

    public static void main(String[] args) {
        //FALTA INDICAR EL GANADOR CON DOS METODOS QUE SUMEN YO Q SE

        //VARIABLES
        String eleccionUsu = "";
        String eleccionMaq = "";
        int dedosUsu;
        int dedosMaq;
        int rondas;

        int contador;
        boolean auxCont;

        //MOSTRAR EL MENU DE LAS RONDAS
        menu();
        rondas = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < rondas; i++) {

            //ELECCION DE PARES O NONES
            eleccionUsu = eleccionParNonUsu();
            eleccionMaq = eleccionParNonMaq(eleccionUsu);

            //ELEGIR Nº DE DEDOS
            dedosUsu = dedosUsu();
            dedosMaq = dedosMaq();

            //MOSTRAR GANADOR
            auxCont = ganador(dedosUsu, dedosMaq, eleccionUsu, eleccionMaq);

            if (auxCont) {

                System.out.println("PARES");
            } else {
                System.out.println("NONES");
            }

        }
    }

    private static Scanner teclado = new Scanner(System.in);

    public static void menu() {
        String menu = """
                    *******************************
                        -> INDICA LAS RONDAS <-
                    *******************************
                    """;
        System.out.println(menu);
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
                    if (dedosUsu < 0 || dedosUsu > 10) {
                        System.out.println("ESCRIBE BIEN LOS DEDOS\n");
                    }
                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("ESCRIBE UN NUMERO\n");
                    teclado.nextLine();
                }

            } while (repetir);

        } while (dedosUsu < 0 || dedosUsu > 10);

        return dedosUsu;
    }

    public static int dedosMaq() {
        Random alea = new Random();
        int dedosMaq;
        dedosMaq = alea.nextInt(0, 10 + 1);

        return dedosMaq;
    }

    public static boolean ganador(int dedosUsu, int dedosMaq, String eleUsu, String eleMaq) {
        int sumaDedos;
        boolean ganador = false;

        sumaDedos = dedosUsu + dedosMaq;

        //PARES
        if (eleUsu.equalsIgnoreCase("pares") && (sumaDedos % 2 == 0)) {

        }

        ganador = true;

        teclado.nextLine();

        return ganador;
    }
}
