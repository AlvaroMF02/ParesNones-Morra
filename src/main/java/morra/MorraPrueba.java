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
        //PONER COMENTARIOS

        //VARIABLES
        String opcion = "";
        int dedosJug1;
        int suposJug1;
        int dedosMaq;
        int suposMaq;
        boolean contadorTRue;   //SIRVE PARA CALCULAR AYUDAR AL CONTADOR DE GANADORES
        int contadorJug1 = 0;
        int contadorJug2 = 0;
        int contadorMaq = 0;

        do {
            //MOSTRAR MENU
            menu();

            //LEER MENU
            opcion = leerOpc();

            switch (opcion) {
                case "maquina":
                    dedosJug1 = dedosJug();
                    dedosMaq = dedosMaq();

                    //USUARIO INDICA LO QUE CREE QUE SALDRÁ
                    suposJug1 = supDedosTotalJug();
                    suposMaq = supDedosTotalMaq();

                    //COMPARAR LOS DEDOS QUE HAN SACADO CADA UNO PARA VER EL GANADOR
                    contadorTRue = ganador(dedosJug1, dedosMaq, suposJug1, suposMaq);

                    //CONTADOR
                    if (contadorTRue) {
                        contadorJug1++;
                    } else {
                        contadorMaq++;
                    }

                    System.out.println("EL JUGADOR SACÓ " + dedosJug1 + " DEDOS, Y CREE QUE HAY " + suposJug1);
                    System.out.println("LA MAQUINA SACÓ " + dedosMaq + " DEDOS, Y CREE QUE HAY " + suposMaq);

                    System.out.println("------------PUNTUACIONES:------------");
                    System.out.println("JUGADOR: " + contadorJug1);
                    System.out.println("MAQUINA: " + contadorMaq);
                    System.out.println("--------------------------------------");

                    teclado.nextLine();
                    break;

                case "amigo":
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
            System.out.println("ESCOJA (MAQUINA) , (AMIGO) O (SALIR)");
            opcion = teclado.nextLine();
            opcion = opcion.toLowerCase();

            if (!opcion.equalsIgnoreCase("maquina")
                    && !opcion.equalsIgnoreCase("amigo")
                    && !opcion.equalsIgnoreCase("salir")) {

                System.out.println("ESCRIBA BIEN LA OPCIÓN\n");
            }

        } while (!opcion.equalsIgnoreCase("maquina")
                && !opcion.equalsIgnoreCase("amigo")
                && !opcion.equalsIgnoreCase("salir"));

        return opcion;
    }

    public static int dedosJug() {
        int dedosUsu = 0;
        boolean repetir = true;

        do {
            do {
                try {

                    System.out.println("INDIQUE LA CANTIDAD DE DEDOS");
                    dedosUsu = teclado.nextInt();
                    if (dedosUsu < 0 || dedosUsu > 5) {
                        System.out.println("SOLO PUEDES SACAR 5 DEDOS COMO MUCHO\n");
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

    public static int supDedosTotalJug() {
        int supDedosJug = 2;
        boolean repetir = true;

        do {
            do {
                try {

                    System.out.println("¿CUÁNTOS DEDOS CREES QUE HABRÁ EN TOTAL?");
                    supDedosJug = teclado.nextInt();
                    if (supDedosJug < 2 || supDedosJug > 10) {
                        System.out.println("COMO MIN SON 2 Y COMO MAX 10\n");
                    }

                    repetir = false;

                } catch (InputMismatchException ime) {
                    System.out.println("NO ESCRIBAS LETRAS\n");
                    teclado.nextLine();
                }

            } while (repetir);

        } while (supDedosJug < 2 || supDedosJug > 10);

        return supDedosJug;
    }

    public static int supDedosTotalMaq() {
        Random alea = new Random();
        int suposicionMaq;
        suposicionMaq = alea.nextInt(2, 10 + 1);

        return suposicionMaq;
    }

    public static boolean ganador(int dedosJug, int dedosMaq, int suposJug, int suposMaq) {
        int numGanad;
        boolean ganadorJug = false;
        //DEVOLER VD Y FALSO SI GANA UNO U OTRO

        numGanad = dedosJug + dedosMaq;

        System.out.println("\nEN TOTAL SON " + numGanad);

        if (numGanad == suposJug) {
            System.out.println("HA GANADO EL JUGADOR\n");
            ganadorJug = true;

        } else if (numGanad == suposMaq) {
            System.out.println("HA GANADO LA MÁQUINA\n");

        } else {
            System.out.println("NO HA ACERTADO NADIE\n");
        }

        return ganadorJug;
    }

}
