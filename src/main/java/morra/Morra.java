package morra;

import paresnones.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class Morra {

    public static void main(String[] args) {
        //PONER COMENTARIOS
        //PONER LAS RONDAS HASTA 5

        //VARIABLES
        String opcion = "";
        int dedosJug1;
        int suposJug1;
        int dedosMaq;
        int suposMaq;
        int auxCont;
        int contadorJug = 0;
        int contadorMaq = 0;

        do {
            //MOSTRAR MENU
            menu();

            //LEER MENU
            opcion = leerOpc();

            switch (opcion) {
                case "jugar":
                    
                    for (int i = 1; i < 6; i++) {
                        
                        System.out.println(" # RONDA " + i);
                        
                        dedosJug1 = dedosJug();
                        dedosMaq = dedosMaq();

                        //USUARIO INDICA LO QUE CREE QUE SALDRÁ
                        suposJug1 = supDedosTotalJug();
                        suposMaq = supDedosTotalMaq();

                        //COMPARAR LOS DEDOS QUE HAN SACADO CADA UNO PARA VER EL GANADOR
                        auxCont = ganador(dedosJug1, dedosMaq, suposJug1, suposMaq);

                        //CONTADOR
                        //SI EL AUX ES 1 SE SUMA AL JUGADOR, SI ES DOS A LA MAQUINA
                        if (auxCont == 1) {
                            contadorJug++;
                        } else if (auxCont == 2) {
                            contadorMaq++;
                        }

                        System.out.println("\nEL JUGADOR SACÓ " + dedosJug1 + " DEDOS, Y CREE QUE HAY " + suposJug1);
                        System.out.println("LA MAQUINA SACÓ " + dedosMaq + " DEDOS, Y CREE QUE HAY " + suposMaq);

                        System.out.println("\n------------PUNTUACIONES:------------");
                        System.out.println("JUGADOR: " + contadorJug);
                        System.out.println("MAQUINA: " + contadorMaq);
                        System.out.println("--------------------------------------\n");
                    }
                    teclado.nextLine();
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
                              -> JUGAR <-
                              -> SALIR <-
                    *******************************
                      (se jugarán 5 rondas, suerte)
                    """;
        System.out.println(menu);
    }

    public static String leerOpc() {
        String opcion;

        do {
            System.out.println("ESCOJA (JUGAR) O (SALIR)");
            opcion = teclado.nextLine();
            opcion = opcion.toLowerCase();

            if (!opcion.equalsIgnoreCase("jugar")
                    && !opcion.equalsIgnoreCase("salir")) {

                System.out.println("ESCRIBA BIEN LA OPCIÓN\n");
            }

        } while (!opcion.equalsIgnoreCase("jugar")
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

    public static int ganador(int dedosJug, int dedosMaq, int suposJug, int suposMaq) {
        int numGanad;
        int ganadorCont = 0;

        numGanad = dedosJug + dedosMaq;

        System.out.println("\nEN TOTAL SON " + numGanad);

        if (numGanad == suposJug) {
            System.out.println("HA GANADO EL JUGADOR\n");
            ganadorCont = 1;

        } else if (numGanad == suposMaq) {
            System.out.println("HA GANADO LA MÁQUINA\n");
            ganadorCont = 2;
        } else {
            System.out.println("NO HA ACERTADO NADIE\n");
        }

        return ganadorCont;
    }

}
