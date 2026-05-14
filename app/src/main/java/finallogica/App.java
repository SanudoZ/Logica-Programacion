
package finallogica;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Arreglos y global
        String[] productos = new String[9999999];
        String[] carritoProductos = new String[9999999];

        double[] precios = new double[9999999];

        int[] CarritoCantidad = new int[9999999];

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
            int unidades = 0;

            double descuento = 0;

            // Administrador
            int opcionAdmin = 0;
            int edicion = 0;
            int eliminar = 0;

            double nuevoPrecio = 0;

            String nuevoProducto = " ";

            // Datos de entrada

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("¿Que tipo de usuario es?' 1. Cliente | 2. Administrador | 3. Salir: ");
                Usuario = sc.nextInt();
                sc.nextLine();

                if (Usuario == 3) {

                    System.out.println("Vuelva pronto");

                    break;
                }

                // Proceso

                else if (Usuario == 1) {

                    while (true) {

                        System.out.print("¿Que desea comprar? ");

                        for (int i = 0; i < cantidadProductos; i++) {

                            System.out.print((i + 1) + ". " + productos[i] + " | ");
                        }

                        System.out.println((cantidadProductos + 1) + ". Salir: ");
                        producto = sc.nextInt();
                        sc.nextLine();

                        if (producto >= 1 && producto <= cantidadProductos) {

                            System.out.println(" ¿Cuantas desea comprar? | | 0. Salir");
                            cantidad = sc.nextInt();
                            sc.nextLine();

                            carritoProductos[(int) CantidadCarro] = productos[producto - 1];
                            CarritoCantidad[(int) CantidadCarro] = cantidad;

                            CantidadCarro++;
                            unidades += cantidad;

                            descuento += descuentos((int) precios[producto - 1], cantidad, unidades);
                            carrito += total((int) precios[producto - 1], cantidad, unidades);

                            System.out.println("Carrito actual: " + carrito);

                            if (cantidad < 0) {

                                System.out.println("Datos invalidos");

                                continue;

                            }

                            else if (cantidad == 0) {

                                System.out.println("Vuelva pronto");

                                break;

                            }

                            System.out.println("¿Desea comprar algo mas? 1. Si | 2. No: ");
                            respuesta = sc.nextInt();
                            sc.nextLine();

                            if (respuesta == 2) {

                                // Datos de salida

                                System.out.println("\nFACTURA");

                                System.out.println("================================");

                                System.out.println("Total acumulado: " + carrito);

                                for (int i = 0; i < CantidadCarro; i++) {

                                    System.out.println(carritoProductos[i] + " x " + CarritoCantidad[i] + " - "
                                            + subtotal((int) precios[i], CarritoCantidad[i]));

                                }

                                System.out.println("Total unidades compradas: " + unidades);

                                System.out.println("================================");

                                System.out.println("Subtotal: " + subtotal((int) precios[producto - 1], cantidad));

                                System.out.println("IVA: " + IVA((int) precios[producto - 1]));

                                System.out.println(
                                        "Descuento: " + descuentos((int) precios[producto - 1], cantidad, unidades));

                                System.out.println("IVA (19%): " + (carrito - (carrito / 1.19)));

                                System.out.println("Descuento aplicado: " + descuento);

                                System.out.println("Total a pagar: " + carrito);

                                System.out.println("================================");

                                break;
                            }

                        }

                        else if (producto == cantidadProductos + 1) {
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

                                System.out.println("Saliendo del administrador...");
                                opcionAdmin = 5;

                                break;

                        }
                        if (opcionAdmin == 5) {
                            break;
                        }

                    }

                }

            }

        }

        catch (

        Exception e) {

            System.out.println("Error: " + e.getMessage());
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

    public static double descuentos(int precio, int cantidad, int unidades) {

        try {

            double descuento = 0;

            if (unidades >= 5 && unidades <= 9) {

                descuento = subtotal(precio, cantidad) * 0.05;

            } else if (unidades >= 10) {

                descuento = subtotal(precio, cantidad) * 0.10;

            }

            return descuento;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double total(int precio, int cantidad, int unidades) {

        try {

            double iva = IVA(precio);
            double subtotal = subtotal(precio, cantidad);

            double total = subtotal + iva - descuentos(precio, cantidad, unidades);

            return total;

        } catch (Exception e) {

            return -1;

        }

    }

}
