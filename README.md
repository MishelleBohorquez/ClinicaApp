# ClinicaApp

Sistema de gestión de turnos médicos desarrollado en **Java** aplicando Programación Orientada a Objetos (OOP), con persistencia de datos en archivos **CSV**.

Proyecto realizado en el marco del Hackathon de **Generation Colombia**.

---

## Descripción

ClinicaApp es una aplicación de consola que permite administrar pacientes, médicos y turnos de una clínica. El sistema mantiene los datos en memoria durante la sesión y los guarda automáticamente en archivos CSV al salir, de modo que la información persiste entre ejecuciones.

## Funcionalidades

El sistema ofrece un menú con las siguientes opciones:

1. Registrar paciente
2. Registrar médico
3. Asignar turno
4. Listar turnos del día
5. Cancelar turno
6. Ver turnos por médico
7. Ver turnos por paciente
8. Cambiar estado de turno
9. Listar pacientes
10. Listar médicos
0. Salir (guarda los datos automáticamente)

### Validaciones incluidas

- No se pueden registrar pacientes con cédulas duplicadas.
- No se pueden registrar médicos duplicados (mismo nombre y apellido).
- No se pueden asignar dos turnos al mismo médico en la misma fecha y hora (conflicto de agenda).
- Todos los campos obligatorios se validan antes de guardar cualquier registro.

## Tecnologías

- **Java** (sin frameworks ni Maven)
- **IntelliJ IDEA**
- Persistencia con archivos **CSV** (sin base de datos)
- `java.time` para el manejo de fechas y horas

## Estructura del proyecto

```
clinicaapp/
└── src/
    └── co/generation/clinica/
        ├── model/
        │   ├── Paciente.java
        │   ├── Medico.java
        │   ├── Turno.java
        │   ├── EstadoTurno.java      (enum)
        │   └── Especialidad.java     (enum)
        ├── interfaces/
        │   ├── Registrable.java
        │   └── Consultable.java
        ├── service/
        │   └── ClinicaService.java
        ├── datos/
        │   └── DatosCSV.java
        └── Main.java
```

- **model** → las entidades del negocio (Paciente, Médico, Turno) y sus enumeraciones.
- **interfaces** → los contratos que implementan las clases (`Registrable`, `Consultable`).
- **service** → toda la lógica de negocio y las validaciones.
- **datos** → lectura y escritura de los archivos CSV.
- **Main.java** → punto de entrada: arma el menú y conecta todo.


## 👥 Equipo

**Nombre del equipo:** _[Sala 7]_

Integrantes

° _Samuel Vélez Guzmán_ \n
° _Dylan Puentes_ \n
° _Sneyder Rodriguez_ \n
° _Mishuelle Bohorquez_ \n
° _Jasbleydy Camacho_ \n

---

<p align="center">Desarrollado para el Hackathon de <strong>Generation Colombia</strong> 🚀</p>
