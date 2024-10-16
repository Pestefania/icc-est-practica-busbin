public class Persona {
    public String nombre; // Atributo público
    public int edad;      // Atributo público

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Con Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Con Setters 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
