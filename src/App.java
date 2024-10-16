import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de personas:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        Persona[] personas = new Persona[n];
        
        // Ingreso de personas
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la edad de la persona " + (i + 1) + ": ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            personas[i] = new Persona(nombre, edad);
        }
        
        // Ordenar las personas por edad
        Arrays.sort(personas, Comparator.comparingInt(p -> p.edad));
        
        // Mostrar el arreglo de personas
        System.out.print("Arreglo de personas: ");
        for (int i = 0; i < personas.length; i++) {
            System.out.print("Persona " + (i + 1) + ": " + personas[i].edad);
            if (i < personas.length - 1) {
                System.out.print(" | "); // Separador para el arreglo ordenado 
            }
        }
        System.out.println(); // Nueva línea después del arreglo

        // Ingreso de la edad a buscar
        System.out.println("Ingrese la edad a buscar:");
        int edadBuscada = scanner.nextInt();
        
        // Método de búsqueda binaria
        Persona encontrada = busquedaBinaria(personas, edadBuscada, 0, personas.length - 1);
        if (encontrada != null) {
            System.out.println("La persona con la edad " + edadBuscada + " es " + encontrada.nombre);
        } else {
            System.out.println("No se encontró ninguna persona con la edad especificada.");
        }

        scanner.close(); // Cerrar el escáner
    }
    
    public static Persona busquedaBinaria(Persona[] personas, int edad, int bajo, int alto) {
        while (bajo <= alto) {
            int centro = bajo + (alto - bajo) / 2;
            System.out.print("Bajo=" + bajo + ", Alto=" + alto + ", Centro=" + centro + ", ");
            System.out.print("ValorCentro=" + personas[centro].edad + " --> ");
            
            if (personas[centro].edad == edad) {
                System.out.println("ENCONTRADO");
                return personas[centro];
            } else if (personas[centro].edad < edad) {
                System.out.println("DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println("IZQUIERDA");
                alto = centro - 1;
            }
        }
        return null;
    }
}

// Clase Persona
class Persona {
    public String nombre; // Atributo público
    public int edad;      // Atributo público

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
