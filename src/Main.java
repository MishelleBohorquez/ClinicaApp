import co.generation.clinica.datos.DatosCSV;
import co.generation.clinica.model.Paciente;
import co.generation.clinica.service.ClinicaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClinicaService servicio = new ClinicaService();
        DatosCSV.cargar(servicio);
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.print("Seleccione una opción");
            System.out.print("1. Registrar paciente");
            System.out.print("2. Registrar medico");
            System.out.print("3. Asignar turno");
            System.out.print("4. Listar turnos del día");
            System.out.print("5. Cancelar turno");
            System.out.print("6. Ver turnos por médico");
            System.out.print("7. Ver turnos por paciente");
            System.out.print("8. Cambiar estado de turno");
            System.out.print("9. Listar pacientes");
            System.out.print("10. Listar médicos");
            System.out.println("0. Salir");
            opcion= Integer.parseInt(scanner.nextLine());


            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el número de cedula: ");
                    String cedula = scanner.nextLine();
                    System.out.println("Ingrese su telefono: ");
                    String telefono = scanner.nextLine();
                    Paciente paciente = new Paciente(nombre,apellido,cedula,telefono);
                    servicio.registrarPaciente(paciente);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    DatosCSV.guardar(servicio);
                    System.out.print("Hasta pronto. Datos guardados");
                    break;
                default:
                    System.out.print("Opción no valida");
            }


        }
        scanner.close();
    }

}