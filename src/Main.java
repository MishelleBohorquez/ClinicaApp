import co.generation.clinica.datos.DatosCSV;
import co.generation.clinica.model.Especialidad;
import co.generation.clinica.model.Medico;
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

            System.out.println("Seleccione una opción");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar medico");
            System.out.println("3. Asignar turno");
            System.out.println("4. Listar turnos del día");
            System.out.println("5. Cancelar turno");
            System.out.println("6. Ver turnos por médico");
            System.out.println("7. Ver turnos por paciente");
            System.out.println("8. Cambiar estado de turno");
            System.out.println("9. Listar pacientes");
            System.out.println("10. Listar médicos");
            System.out.println("0. Salir");
            int opcionMenu = scanner.nextInt();
            scanner.nextLine();
            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el número de cedula: ");
                    String cedula = scanner.nextLine();
                    System.out.println("Ingrese su telefono: ");
                    String telefono = scanner.nextLine();
                    Paciente paciente = new Paciente(nombre, apellido, cedula, telefono);
                    servicio.registrarPaciente(paciente);
                    break;
                case 2:
                    System.out.println("Ingresa el nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido2 = scanner.nextLine();
                    System.out.println("Seleccione la especialidad");
                    System.out.println("Opción 1 - General");
                    System.out.println("Opción 2 - Pediatria");
                    System.out.println("Opción 3 - Cardiologia");
                    System.out.println("Opción 4 - Urgencias");
                    int opcionEspecialidad = scanner.nextInt();
                    Especialidad especialidad = null;
                    switch (opcionEspecialidad){
                        case 1:
                            especialidad = Especialidad.GENERAL;
                            break;
                        case 2:
                            especialidad = Especialidad.PEDIATRIA;
                            break;
                        case 3:
                            especialidad = Especialidad.CARDIOLOGIA;
                            break;
                        case 4:
                            especialidad = Especialidad.URGENCIAS;
                            break;
                        default:
                            System.out.println("No existe la especialidad seleccionada");
                    }
                    if (especialidad!=null){
                        Medico medico = new Medico(nombre2, apellido2,especialidad);
                        servicio.registrarMedico(medico);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el número de cedula: ");
                    String cedula2 = scanner.nextLine();
                    Paciente paciente2 = servicio.buscarPorCedula(cedula2);
                    if (cedula2 == null){
                        System.out.println("El paciente no existe");
                    }
                    System.out.println("Ingresa el nombre: ");
                    String nombre3 = scanner.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido3 = scanner.nextLine();
                    Medico medicoTurno = servicio.buscarPorNombreApellido(nombre3, apellido3);

                    if (medicoTurno == null){
                        System.out.println("El medico no existe");
                    }
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