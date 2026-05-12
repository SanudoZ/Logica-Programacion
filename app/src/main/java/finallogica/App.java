
package finallogica;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Arreglos y global
        String[] productos = new String[100];
        String[] carritoProductos = new String[100];

        double[] precios = new double[100];

        int[] CarritoCantidad = new int[100];

        productos[0] = "Camisa";
        productos[1] = "Pantalon";
        productos[2] = "Zapatos";

        precios[0] = 1000;
        precios[1] = 2000;
        precios[2] = 3000;

        int cantidadProductos = 3;

        double carrito = 0;
        double CantidadCarro = 0;

        try {

            // Variables

            // Clientes
            int Usuario = 0;
            int producto = 0;
            int cantidad = 0;
            int respuesta = 0;

            // Administrador
            int opcionAdmin = 0;
            int edicion = 0;
            int eliminar = 0;

            double nuevoPrecio = 0;

            String nuevoProducto = " ";

            Scanner sc = new Scanner(System.in);

            // Datos de entrada

            System.out.println("¿Que tipo de usuario es?' 1. Cliente | 2. Administrador | 3. Salir: ");
            Usuario = sc.nextInt();
            sc.nextLine();

            if (Usuario == 3) {

                System.out.println("Vuelva pronto");
            }

            // Proceso

            else if (Usuario == 1) {

                while (true) {

                    System.out.println("¿Que desea comprar? 1. Camisa | 2. Pantalon | 3. Zapatos | 4. Salir: ");
                    producto = sc.nextInt();
                    sc.nextLine();

                    if (producto >= 1 && producto <= 3) {

                        System.out.println(" ¿Cuantas desea comprar?");
                        cantidad = sc.nextInt();
                        sc.nextLine();

                        carritoProductos[(int) CantidadCarro] = productos[producto - 1];
                        CarritoCantidad[(int) CantidadCarro] = cantidad;

                        CantidadCarro++;

                        carrito += total((int) precios[producto - 1], IVA((int) precios[producto - 1]), cantidad);

                        System.out.println("Carrito actual: " + carrito);

                        if (cantidad <= 0) {

                            System.out.println("Datos invalidos");

                            continue;

                        }

                        System.out.println("¿Desea comprar algo mas? 1. Si | 2. No: ");
                        respuesta = sc.nextInt();
                        sc.nextLine();

                        if (respuesta == 2) {

                            // Datos de salida

                            System.out.println("\nFACTURA");

                            System.out.println("Total acumulado: " + carrito);
                            System.out.println("Subtotal: " + subtotal((int) precios[producto - 1], cantidad));
                            System.out.println("IVA: " + IVA((int) precios[producto - 1]));
                            System.out.println("Descuento: " + descuentos((int) precios[producto - 1], cantidad));

                            for (int i = 0; i < CantidadCarro; i++) {

                                System.out.println(carritoProductos[i] + " x " + CarritoCantidad[i]);

                            }

                            break;
                        }

                    }

                    else if (producto == 4) {
                        System.out.println("Gracias por elegirnos");

                        break;
                    }

                    else {
                        System.out.println("Producto no encontrado");
                    }

                }
            }

            else if (Usuario == 2) {

                while (true) {

                    System.out.println(
                            "¿Que desea hacer? 1. Ver productos | 2. agregar productos | 3. Editar precio | 4. Eliminar productos | 5. Salir: ");
                    opcionAdmin = sc.nextInt();
                    sc.nextLine();

                    switch (opcionAdmin) {
                        case 1:

                            for (int i = 0; i < cantidadProductos; i++) {
                                System.out.println((i + 1) + ". " + productos[i] + " - $" + precios[i]);

                            }

                            break;

                        case 2:

                            System.out.println("Nombre del producto:");
                            nuevoProducto = sc.nextLine();

                            System.out.println("Precio:");
                            nuevoPrecio = sc.nextDouble();
                            sc.nextLine();

                            productos[cantidadProductos] = nuevoProducto;
                            precios[cantidadProductos] = nuevoPrecio;

                            cantidadProductos++;

                            System.out.println("Producto agregado");

                            break;

                        case 3:

                            for (int i = 0; i < cantidadProductos; i++) {

                                System.out.println((i + 1) + ". " + productos[i] + " - $" + precios[i]);

                            }

                            System.out.println("Seleccione producto:");
                            edicion = sc.nextInt() - 1;
                            sc.nextLine();

                            System.out.println("Nuevo precio:");
                            precios[edicion] = sc.nextDouble();
                            sc.nextLine();

                            System.out.println("Precio actualizado");

                            break;

                        case 4:

                            for (int i = 0; i < cantidadProductos; i++) {

                                System.out.println((i + 1) + ". " + productos[i]);

                            }

                            System.out.println("Seleccione el producto que va a eliminar:");
                            eliminar = sc.nextInt() - 1;

                            for (int i = eliminar; i < cantidadProductos - 1; i++) {

                                productos[i] = productos[i + 1];
                                precios[i] = precios[i + 1];
                            }

                            cantidadProductos--;

                            System.out.println("Producto eliminado");

                            break;

                        case 5:

                            break;

                    }

                    break;

                }

            }

            else {

                System.out.println("Usuario no encontrado");

            }

        } catch (Exception e) {

            System.out.println("Dato invalido");
        }

    }

    // Funciones

    public static double subtotal(int precio, int cantidad) {

        try {

            double subtotal = precio * cantidad;

            return subtotal;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double IVA(int precio) {

        try {

            double iva = subtotal(precio, 1) * 0.19;

            return iva;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double descuentos(int precio, int cantidad) {

        try {

            double descuento = 0;

            if (cantidad >= 5 && cantidad <= 9) {

                descuento = subtotal(precio, cantidad) * 0.05;

            } else if (cantidad >= 10) {

                descuento = subtotal(precio, cantidad) * 0.10;

            }

            return descuento;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double total(int precio, double iva, int cantidad) {

        try {

            double total = subtotal(precio, cantidad) + iva - descuentos(precio, cantidad);

            return total;

        } catch (Exception e) {

            return -1;

        }

    }

}
