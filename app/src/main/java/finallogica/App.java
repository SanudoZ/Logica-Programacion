
package finallogica;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {

            // Variables

            int Usuario = 0;
            int producto = 0;

            Scanner sc = new Scanner(System.in);

            // Datos de entrada

            System.out.println("¿Que tipo de usuario es?' 1. Cliente | 2. Administrador: ");
            Usuario = sc.nextInt();
            sc.nextLine();

            // Proceso

            if (Usuario == 1) {

                while (true) {

                    System.out.println("¿Que desea comprar? 1. Camisa | 2. Pantalon | 3. Zapatos | 4. Salir: ");
                    producto = sc.nextInt();
                    sc.nextLine();

                }

            }

            // Datos de salida

        } catch (Exception e) {

        }

    }

    // Funciones

    public static int precios(int producto) {

        try {
            int precio = 0;

            switch (producto) {

                case 1:
                    precio = 1000;
                    break;

                case 2:
                    precio = 2000;
                    break;

                case 3:
                    precio = 3000;
                    break;

                default:
                    System.out.println("Producto no encontrado");
                    break;

            }

            return precio;

        } catch (Exception e) {

            return -1;

        }

    }
}
