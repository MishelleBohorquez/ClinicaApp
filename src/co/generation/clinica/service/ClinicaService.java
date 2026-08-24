package co.generation.clinica.service;

import co.generation.clinica.interfaces.Consultable;
import co.generation.clinica.model.EstadoTurno;
import co.generation.clinica.model.Medico;
import co.generation.clinica.model.Paciente;
import co.generation.clinica.model.Turno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClinicaService implements Consultable {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Turno> turnos;

    public ClinicaService() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void registrarPaciente(Paciente p) {
        if (!p.esValido()) {
            System.out.println("Error: Datos del paciente no validos.");
            return;
        }
        if (pacientes.contains(p)) {
            System.out.println("Error: Ya existe un paciente con esa cedula.");
            return;
        }
        int maxId = 0;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() > maxId) {
                maxId = pacientes.get(i).getId();
            }
        }
        p.setId(maxId + 1);
        pacientes.add(p);
        System.out.println("Paciente registrado con exito: " + p.getDatosRegistro());
    }

    public Paciente buscarPorCedula(String cedula) {
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        List<Paciente> copia = new ArrayList<>(pacientes);
        Collections.sort(copia, new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                int compApellido = p1.getApellido().compareTo(p2.getApellido());
                if (compApellido != 0) {
                    return compApellido;
                }
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });
        for (int i = 0; i < copia.size(); i++) {
            System.out.println(copia.get(i).toString());
        }
    }

    public void registrarMedico(Medico m) {
        if (!m.esValido()) {
            System.out.println("Error: Datos del medico no validos.");
            return;
        }
        if (medicos.contains(m)) {
            System.out.println("Error: Ya existe un medico con ese nombre y apellido.");
            return;
        }
        int maxId = 0;
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId() > maxId) {
                maxId = medicos.get(i).getId();
            }
        }
        m.setId(maxId + 1);
        medicos.add(m);
        System.out.println("Medico registrado con exito: " + m.getDatosRegistro());
    }

    public Medico buscarPorNombreApellido(String nombre, String apellido) {
        for (int i = 0; i < medicos.size(); i++) {
            Medico m = medicos.get(i);
            if (m.getNombre().equalsIgnoreCase(nombre) && m.getApellido().equalsIgnoreCase(apellido)) {
                return m;
            }
        }
        return null;
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("No hay medicos registrados.");
            return;
        }
        List<Medico> copia = new ArrayList<>(medicos);
        Collections.sort(copia, new Comparator<Medico>() {
            @Override
            public int compare(Medico m1, Medico m2) {
                int compEspecialidad = m1.getEspecialidad().compareTo(m2.getEspecialidad());
                if (compEspecialidad != 0) {
                    return compEspecialidad;
                }
                return m1.getApellido().compareTo(m2.getApellido());
            }
        });
        for (int i = 0; i < copia.size(); i++) {
            System.out.println(copia.get(i).toString());
        }
    }

    public void asignarTurno(Turno t) {
        Paciente p = buscarPorCedula(t.getPaciente().getCedula());
        if (p == null) {
            System.out.println("Error: El paciente no existe.");
            return;
        }
        Medico m = buscarPorNombreApellido(t.getMedico().getNombre(), t.getMedico().getApellido());
        if (m == null) {
            System.out.println("Error: El medico no existe.");
            return;
        }
        if (turnos.contains(t)) {
            System.out.println("Error: El medico ya tiene un turno asignado en esa fecha y hora.");
            return;
        }
        int maxId = 0;
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getId() > maxId) {
                maxId = turnos.get(i).getId();
            }
        }
        t.setId(maxId + 1);
        turnos.add(t);
        System.out.println("Turno asignado con exito: " + t.toString());
    }


}