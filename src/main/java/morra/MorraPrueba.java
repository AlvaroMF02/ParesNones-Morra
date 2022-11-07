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
        int dedosJug1;
        int suposJug1;
        int dedosMaq;
        int suposMaq;

        do {
            //MOSTRAR MENU
            menu();

            //LEER MENU
            opcion = leerOpc();

            switch (opcion) {
                case "contra maquina":
                    System.out.println("CONTRA LA MAQUINA");
                    dedosJug1 = dedosJug();
                    dedosMaq = dedosMaq();

                    System.out.println("JUGADOR: " + dedosJug1);
                    System.out.println("JUGADOR: " + dedosMaq);
                    
                    //USUARIO INDICA LO QUE CREE QUE SALDRÁ
                    suposJug1=supDedosTotalJug();
                    System.out.println("EL JUGADOR CREE QUE EL TOTAL ES: "+suposJug1);
                    suposMaq=supDedosTotalMaq();
                    System.out.println("LA MAQUINA CREE QUE EL TOTAL ES: "+suposMaq);
                    
                    //COMPARAR LOS DEDOS QUE HAN SACADO CADA UNO PARA VER EL GANADOR
                    
                    
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

    public static int dedosJug() {
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
    
    public static boolean ganador(int suposJug, int suposMaq){
        int numGanad;
        //DEVOLER VD Y FALSO SI GANA UNO U OTRO
        
        numGanad = suposJug + suposMaq;
        
        if (numGanad == suposJug) {
            System.out.println("HA GANADO EL JUGADOR");

        } else if(numGanad == suposMaq){
            System.out.println("HA GANADO LA MÁQUINA");

        }else{
            System.out.println("NO HA ACERTADO NADIE");
        }
        
        return 
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

}
