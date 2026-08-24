package co.generation.clinica.interfaces;

import co.generation.clinica.model.Turno;
import co.generation.clinica.model.Medico;
import co.generation.clinica.model.Paciente;

import java.time.LocalDate;
import java.util.List;


public interface Consultable {


    List<Turno> listarTurnosDelDia(LocalDate fecha);

    List<Turno> buscarPorMedico(Medico medico);

    List<Turno> buscarPorPaciente(Paciente paciente);
}