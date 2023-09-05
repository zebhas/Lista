/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Scanner;

/**
 *
 * @author Guest
 */
public class ListaMain {

    public static void main(String[] args) {
        Lista<Persona> personas = new Lista<Persona>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Agregar al inicio");
            System.out.println("2. Agregar al intermedio");
            System.out.println("3. Agregar al final");
            System.out.println("4. Eliminar último elemento");
            System.out.println("5. Buscar persona");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    personas.addFirst(new Persona(nombre, edad));
                    break;
                case 2:
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = Integer.parseInt(scanner.nextLine());
                    personas.addEnMedio(new Persona(nombre, edad));
                    break;
                case 3:
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = Integer.parseInt(scanner.nextLine());
                    personas.addLast(new Persona(nombre, edad));
                    break;
                case 4:
                    Persona ultimoEliminado = personas.removeLast();
                    if (ultimoEliminado != null) {
                        System.out.println("Se eliminó: " + ultimoEliminado);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese nombre a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    System.out.print("Ingrese edad a buscar: ");
                    int edadBuscada = Integer.parseInt(scanner.nextLine());
                    Persona personaBuscada = new Persona(nombreBuscado, edadBuscada);
                    if (personas.search(personaBuscada)) {
                        System.out.println("La persona " + nombreBuscado + " con edad " + edadBuscada + " está en la lista.");
                    } else {
                        System.out.println("La persona " + nombreBuscado + " con edad " + edadBuscada + " no está en la lista.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("Lista completa:");
            for (Persona elem : personas) {
                System.out.println(elem);
            }
            System.out.println("Máximo: " + personas.maxItem());
            System.out.println("Tamaño de la lista: " + personas.size());
        }
    }
}
