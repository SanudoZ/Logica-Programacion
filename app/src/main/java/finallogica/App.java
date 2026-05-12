
package finallogica;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {

            // Variables

            int Usuario = 0;
            int producto = 0;
            int cantidad = 0;

            Scanner sc = new Scanner(System.in);

            // Datos de entrada

            while (true) {

                System.out.println("¿Que tipo de usuario es?' 1. Cliente | 2. Administrador | 3. Salir: ");
                Usuario = sc.nextInt();
                sc.nextLine();

                if (Usuario == 3) {
                    System.out.println("Vuelva pronto");
                    break;
                }

                // Proceso

                if (Usuario == 1) {

                    while (true) {

                        System.out.println("¿Que desea comprar? 1. Camisa | 2. Pantalon | 3. Zapatos | 4. Salir: ");
                        producto = sc.nextInt();
                        sc.nextLine();

                        if (producto == 4) {
                            System.out.println("Gracias por elegirnos");

                            break;
                        }

                        else if (producto >= 1 && producto <= 3) {

                            System.out.println(" ¿Cuantas desea comprar?");
                            cantidad = sc.nextInt();
                            sc.nextLine();

                        }

                        else {
                            System.out.println("Producto no encontrado");
                        }

                    }

                }

            }

            // Datos de salida

        } catch (Exception e) {

        }

    }

    // Funciones

    public static int precios(int producto, int cantidad) {

        try {

            int precio = 0;

            switch (producto) {

                case 1:
                    precio = 1000 * cantidad;
                    break;

                case 2:
                    precio = 2000 * cantidad;
                    break;

                case 3:
                    precio = 3000 * cantidad   ;
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
