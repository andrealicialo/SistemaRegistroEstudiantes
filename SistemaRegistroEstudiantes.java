import java.util.Scanner;

public class SistemaRegistroEstudiantes {
    static String[][] estudiantes = new String[100][4];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de Estudiantes ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Calcular promedio de calificaciones");
            System.out.println("4. Buscar estudiante por ID");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante(scanner);
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    calcularPromedio();
                    break;
                case 4:
                    buscarEstudiante(scanner);
                    break;
                case 5:
                    eliminarEstudiante(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    static void agregarEstudiante(Scanner scanner) {
        System.out.print("Nombre: ");
        estudiantes[contador][0] = scanner.nextLine();
        System.out.print("ID: ");
        estudiantes[contador][1] = scanner.nextLine();
        System.out.print("Edad: ");
        estudiantes[contador][2] = scanner.nextLine();
        System.out.print("Calificación: ");
        estudiantes[contador][3] = scanner.nextLine();
        contador++;
        System.out.println("Estudiante agregado con éxito.");
    }

    static void mostrarEstudiantes() {
        System.out.println("\nLista de Estudiantes:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Nombre: " + estudiantes[i][0] + ", ID: " + estudiantes[i][1] + ", Edad: " + estudiantes[i][2] + ", Calificación: " + estudiantes[i][3]);
        }
    }

    static void calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += Double.parseDouble(estudiantes[i][3]);
        }
        double promedio = (contador > 0) ? suma / contador : 0;
        System.out.println("Promedio de calificaciones: " + promedio);
    }

    static void buscarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante: ");
        String id = scanner.nextLine();
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i][1].equals(id)) {
                System.out.println("Nombre: " + estudiantes[i][0] + ", Edad: " + estudiantes[i][2] + ", Calificación: " + estudiantes[i][3]);
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    static void eliminarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el ID del estudiante a eliminar: ");
        String id = scanner.nextLine();
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i][1].equals(id)) {
                for (int j = i; j < contador - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                contador--;
                System.out.println("Estudiante eliminado.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
}