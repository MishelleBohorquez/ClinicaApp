package co.generation.clinica.model;

public class Medico {
    private int id;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    public Medico(String nombre, String apellido,  Especialidad especialidad) {
        setNombre(nombre);
        setApellido(apellido);
        setEspecialidad(especialidad);
    }
    public Medico(int id, String nombre, String apellido, Especialidad especialidad) {
        this.id = id;
        setNombre(nombre);
        setApellido(apellido);
        setEspecialidad(especialidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Campo nombre se encuentra vacio");
        }
            this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if(apellido == null || apellido.trim().isEmpty()){
            throw new IllegalArgumentException("Campo apellido se encuentra vacio");
        }
        this.apellido = apellido.trim();
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        if(especialidad == null){
            throw new IllegalArgumentException("Campo especialidad se encuentra vacio");
        }
        this.especialidad = especialidad;
    }
}