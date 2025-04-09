import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Clase principal que simula un sistema de atención de emergencias utilizando
 * la clase {@link java.util.PriorityQueue} de Java.
 * 
 * Los pacientes se cargan desde un archivo de texto y se atienden según su
 * código de emergencia, donde un código con menor valor (por ejemplo, 'A') indica mayor prioridad.
 * 
 * El archivo debe tener el formato:
 * <pre>
 * Nombre, Síntoma, CódigoEmergencia
 * </pre>
 * Un ejemplo de línea válida:
 * <pre>
 * Ana López, Fiebre alta, A
 * </pre>
 */
public class SistemaEmergenciasJCF {

    /**
     * Método principal del programa. Carga los pacientes desde un archivo y
     * los atiende en orden de prioridad.
     * 
     * @param args argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();
        
        try {
            cargarPacientes(colaEmergencias);
            
            System.out.println("Atendiendo pacientes según prioridad (usando Java PriorityQueue):");
            
            while (!colaEmergencias.isEmpty()) {
                Paciente paciente = colaEmergencias.poll(); 
                System.out.println(paciente);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de pacientes: " + e.getMessage());
        }
    }

    /**
     * Carga los pacientes desde un archivo llamado {@code pacientes.txt} y los
     * agrega a la cola de prioridad.
     * 
     * Cada línea del archivo debe contener el nombre, el síntoma y el código de emergencia
     * separados por comas.
     * 
     * @param cola la cola de prioridad donde se agregarán los pacientes
     * @throws IOException si ocurre un error al leer el archivo
     */
    private static void cargarPacientes(PriorityQueue<Paciente> cola) throws IOException {
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
