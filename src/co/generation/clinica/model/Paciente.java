package co.generation.clinica.model;

import co.generation.clinica.interfaces.Registrable;

public class Paciente implements Registrable {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor sin ID
    public Paciente(String cedula, String nombre, String apellido, String telefono) {
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
    }

    // Constructor con ID
    public Paciente(int id, String cedula, String nombre, String apellido, String telefono) {
        this(cedula, nombre, apellido, telefono);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía o ser nula.");
        }
        this.cedula = cedula.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío o ser nulo.");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío o ser nulo.");
        }
        this.apellido = apellido.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo.");
        }

        String telefonoLimpio = telefono.trim();

        if (telefonoLimpio.length() < 7 || telefonoLimpio.length() > 10) {
            throw new IllegalArgumentException("El teléfono debe tener entre 7 y 10 dígitos.");
        }

        for (int i = 0; i < telefonoLimpio.length(); i++) {
            char c = telefonoLimpio.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("El teléfono solo debe contener números.");
            }
        }

        this.telefono = telefonoLimpio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paciente)) {
            return false;
        }
        Paciente otroPaciente = (Paciente) obj;
        return cedula != null && cedula.equals(otroPaciente.cedula);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + cedula + " - " + telefono;
    }

    @Override
    public String getDatosRegistro() {
        return toString();
    }

    @Override
    public boolean esValido() {
        return cedula != null && !cedula.trim().isEmpty() &&
                nombre != null && !nombre.trim().isEmpty() &&
                apellido != null && !apellido.trim().isEmpty() &&
                telefono != null && telefono.length() >= 7 && telefono.length() <= 10;
    }
}