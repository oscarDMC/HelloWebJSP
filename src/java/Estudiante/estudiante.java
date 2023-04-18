package Estudiante;

/**
 *
 * @author ddav_
 */

public class estudiante {
    String nombre;
    String apellido;
    int yearnacimiento;

    public estudiante() {
    }

    public estudiante(String nombre, String apellido, int yearnacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.yearnacimiento = yearnacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getYearnacimiento() {
        return yearnacimiento;
    }

    public void setYearnacimiento(int yearnacimiento) {
        this.yearnacimiento = yearnacimiento;
    }
    

    
}
