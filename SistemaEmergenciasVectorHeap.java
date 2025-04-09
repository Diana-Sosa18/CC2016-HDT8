import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que simula un sistema de atención de emergencias utilizando
 * una implementación personalizada de cola de prioridad llamada {@code VectorHeap}.
 * 
 * Los pacientes se leen desde un archivo de texto y se atienden según su prioridad,
 * determinada por el código de emergencia (letras, donde 'A' es la mayor prioridad).
 *
 * El archivo debe tener el siguiente formato:
 * <pre>
 * Nombre, Síntoma, CódigoEmergencia
 * </pre>
 * Ejemplo:
 * <pre>
 * Juan Pérez, Dolor de cabeza, C
 * María López, Fractura, A
 * </pre>
 */
public class SistemaEmergenciasVectorHeap {

    /**
     * Método principal del programa. Carga los pacientes desde un archivo y
     * los atiende en orden de prioridad usando la estructura {@code VectorHeap}.
     * 
     * @param args argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();
        
        try {
            cargarPacientes(colaEmergencias);
    
            System.out.println("Atendiendo pacientes según prioridad (usando VectorHeap):");
            
            while (!colaEmergencias.isEmpty()) {
                Paciente paciente = colaEmergencias.remove();
                System.out.println(paciente);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de pacientes: " + e.getMessage());
        }
    }

    /**
     * Carga pacientes desde un archivo llamado {@code pacientes.txt}
     * y los agrega a la cola de prioridad.
     * 
     * Cada línea del archivo debe contener el nombre, el síntoma
     * y el código de emergencia separados por comas.
     *
     * @param cola la instancia de {@code VectorHeap} donde se almacenan los pacientes
     * @throws IOException si ocurre un error al leer el archivo
     */
    private static void cargarPacientes(VectorHeap<Paciente> cola) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                
                if (campos.length >= 3) {
                    String nombre = campos[0].trim();
                    String sintoma = campos[1].trim();
                    char codigoEmergencia = campos[2].trim().charAt(0);
                    
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    cola.add(paciente);
                }
            }
        }
    }
}
