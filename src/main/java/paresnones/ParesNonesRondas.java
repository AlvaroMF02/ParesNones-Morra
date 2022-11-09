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
        //SE LE PUEDE METER UN DO WHILE PARA QUE TE PIDA SALIR DEL JUEGO
        //Y NO SEA SOLO PEDIR LAS RONDAS :)

        //VARIABLES
        String eleccionUsu = "";
        String eleccionMaq = "";
        int dedosUsu;
        int dedosMaq;
        int rondas;
        int contadorJug = 0;
        int contadorMaq = 0;
        int auxCont;

        //MOSTRAR EL MENU DE LAS RONDAS
        menu();
        rondas = teclado.nextInt();
        teclado.nextLine();

        //BUCLE RONDAS
        for (int i = 1; i < rondas + 1; i++) {

            System.out.println(" # RONDA: " + i);

            //ELECCION DE PARES O NONES
            eleccionUsu = eleccionParNonUsu();
            eleccionMaq = eleccionParNonMaq(eleccionUsu);

            //ELEGIR Nº DE DEDOS
            dedosUsu = dedosUsu();
            dedosMaq = dedosMaq();

            //MOSTRAR GANADOR
            auxCont = ganador(dedosUsu, dedosMaq, eleccionUsu, eleccionMaq);

            //CONTADOR DE CADA RONDA 
            if (eleccionUsu.equalsIgnoreCase("pares") && (auxCont == 1)
                    || (eleccionUsu.equalsIgnoreCase("nones") && (auxCont == 2))) {
                System.out.println(" ## GANA EL JUGADOR ##\n");
                contadorJug++;
            } else {
                System.out.println(" ## GANA LA MAQUINA ##\n");
                contadorMaq++;
            }

            //PUNTOS:
            System.out.println("\n------------PUNTUACIONES:------------");
            System.out.println("JUGADOR: " + contadorJug);
            System.out.println("MAQUINA: " + contadorMaq);
            System.out.println("--------------------------------------\n");

        }

        //RESULTADO FINAL
        if (contadorJug > contadorMaq) {
            System.out.println("\nHA GANADO EL JUGADOR\n");
        } else if (contadorJug < contadorMaq) {
            System.out.println("\nHA GANADO LA MAQUINA\n");
        } else {
            System.out.println("\nEMPATE\n");
        }

    }

    private static Scanner teclado = new Scanner(System.in);

    //METODO CON EL MENU
    public static void menu() {
        String menu = """
                    *******************************
                        -> INDICA LAS RONDAS <-
                    *******************************
                    """;
        System.out.println(menu);
    }

    //METODO PARA QUE EL JUGADOR DECIDA PARES O NONES
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

    //METODO CON LA SELECCION DE LA MAQUINA
    public static String eleccionParNonMaq(String eleccUsu) {
        String eleccionMaq;
        if (eleccUsu.equalsIgnoreCase("pares")) {
            eleccionMaq = "nones";
        } else {
            eleccionMaq = "pares";
        }

        return eleccionMaq;
    }

    //METODO PARA LOS DEDOS DEL JUGADOR FILTRADO
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

    //METODO CON UN ALEA PARA LOS DEDOS DE LA MAQUINA
    public static int dedosMaq() {
        Random alea = new Random();
        int dedosMaq;
        dedosMaq = alea.nextInt(0, 10 + 1);

        return dedosMaq;
    }

    //METODO CON LA SUMA Y EL IF PARA VER EL GANADOR DE LA RONDA
    public static int ganador(int dedosJug, int dedosMaq, String eleUsu, String eleMaq) {
        int sumaDedos;
        int contaGana = 0;

        sumaDedos = dedosJug + dedosMaq;

        System.out.println("JUGADOR: " + dedosJug);
        System.out.println("MAQUINA: " + dedosMaq);
        System.out.println("TOTAL: " + sumaDedos + "\n");

        if (sumaDedos % 2 == 0) {
            contaGana = 1;
        } else {
            contaGana = 2;
        }

        teclado.nextLine();

        return contaGana;
    }
}
