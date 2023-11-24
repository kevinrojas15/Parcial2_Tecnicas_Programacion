/**
 * Programa de registro de estudiantes que utiliza HashMaps para almacenar información sobre los estudiantes, con sus códigos, nombres y el número de asistencias que han tenido.
 * El programa permite al usuario realizar varias acciones a través de un menú.
 *
 * Se crean dos HashMaps:
 * nombres_estudiantes: Almacena los códigos de los estudiantes como claves y sus nombres como valores.
 * asistencias_estudiantes: Almacena los códigos de los estudiantes como claves y el número de asistencias como valores.
 * Se crea un objeto "lector" de la clase Scanner para leer la entrada del usuario.
 *
 * Se inicializa la variable "opcion" a -1 para que el programa entre en un bucle while.
 *
 * Se inicia un bucle while que se ejecuta hasta que el usuario seleccione la opción 0 (Salir).
 *
 * Dentro del bucle while, se muestra un menú de opciones al usuario y se lee la elección del usuario usando el objeto "lector."
 *
 * Se utilizan variables locales para almacenar el código, nombre y número de asistencias de un estudiante según la opción seleccionada por el usuario.
 *
 * Se utiliza una estructura "switch" para manejar las diferentes opciones del menú:
 *
 * Opción 1: Registrar estudiante, donde se pide al usuario ingresar el código y el nombre del estudiante, y se almacenan en los HashMaps.
 * Opción 2: Modificar nombre del estudiante, donde se permite al usuario cambiar el nombre de un estudiante existente.
 * Opción 3: Eliminar estudiante, que permite al usuario eliminar a un estudiante por su código.
 * Opción 4: Consultar estudiante, que muestra el nombre y el número de asistencias de un estudiante dado su código.
 * Opción 5: Consultar todos los estudiantes, que muestra la información de todos los estudiantes registrados.
 * Opción 6: Tomar asistencia, que permite al usuario registrar la asistencia de un estudiante existente, incrementando el contador de asistencias.
 * Opción 0: Salir del programa.
 * El bucle continúa hasta que el usuario selecciona la opción 0 (Salir), momento en el que se muestra un mensaje de despedida y el programa termina.
 *
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class registro {
    public static void main(String[] args) {
        // Parámetros
        HashMap<String, String> nombres_empleados = new HashMap<>();
        HashMap<String, Integer> salario_empleados = new HashMap<>();

        Scanner lector = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0){
            System.out.println("Ingresa la opción:");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Modificar nombre del empleado");
            System.out.println("3. Eliminar empleados");
            System.out.println("4. Consultar empleados");
            System.out.println("5. Consultar todos los empleados");
            System.out.println("6. Saber sueldo");
            System.out.println("7. saber su cargo");
            System.out.println("0. Salir");

            opcion = lector.nextInt();

            String numeroidentificacion;
            String nombre;
            int salario;
            int horasTrabajadas;

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el código del empleado");
                    numeroidentificacion = lector.next();
                    if (!nombres_empleados.containsKey(numeroidentificacion)) {
                        lector.nextLine();
                        System.out.println("Ingrese el nombre del empleado");
                        nombre = lector.nextLine();
                        salario = 0;
                        nombres_empleados.put(numeroidentificacion, nombre);
                        salario_empleados.put(numeroidentificacion, salario);
                    }
                    else
                        System.out.println("El numero de indentificacion" + numeroidentificacion + " ya existe");
                    break;
                case 2:
                    System.out.println("Ingrese el numero de identificacion del empleado");
                    numeroidentificacion = lector.next();
                    if (nombres_empleados.containsKey(numeroidentificacion)) {
                        lector.nextLine();
                        System.out.println("Ingresa el nuevo nombre del estudiante");
                        nombre = lector.nextLine();
                        nombres_empleados.put(numeroidentificacion, nombre);
                    } else {
                        System.out.println("NO existe un estudiante con el código " + numeroidentificacion);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el numero de identificacion del empleado");
                    numeroidentificacion = lector.next();
                    nombres_empleados.remove(numeroidentificacion);
                    salario_empleados.remove(numeroidentificacion);
                    break;
                case 4:
                    System.out.println("Ingrese el numero de identificacion del empleado");
                    numeroidentificacion = lector.next();
                    if (nombres_empleados.containsKey(numeroidentificacion)) {
                        nombre = nombres_empleados.get(numeroidentificacion);
                        salario = salario_empleados.get(numeroidentificacion);
                        System.out.println("Los datos del empleado con código: " + numeroidentificacion);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Salario: " + salario);
                    }
                    else
                        System.out.println("NO existe un empleado con el numero de identificacion " + numeroidentificacion);
                    break;
                case 5:
                    Set<String> codigos = nombres_empleados.keySet();
                    System.out.println();
                    System.out.println("Empleados registrados: " + codigos.size());
                    for(String cod: codigos){
                        nombre = nombres_empleados.get(cod);
                        salario = salario_empleados.get(cod);
                        System.out.println("Empleado con Código: " + cod);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("salario: " + salario);
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el código del empleado");
                    numeroidentificacion = lector.next();
                    if (nombres_empleados.containsKey(numeroidentificacion)) {
                        salario = salario_empleados.get(numeroidentificacion);
                        salario_empleados.put(numeroidentificacion, ++salario);
                    }
                    else
                        System.out.println("NO existe un empleado con el numeroidentificacion " + numeroidentificacion);
                    break;
                case 7:
                    System.out.println("Ingrese el codigo del empleado");
                    numeroidentificacion = lector.next();
                    if (nombres_empleados.containsKey(numeroidentificacion)) {
                        horasTrabajadas = 12;
                        salario = horasTrabajadas;
                        horasTrabajadas = salario;
                        System.out.println("es empleado a tiempo completo y su salario es de 1200.000");
                    }
                    else
                        System.out.println("es gerente y su salario es de 3000.000");
                case 0:
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
