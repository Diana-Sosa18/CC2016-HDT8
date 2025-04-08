import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class SistemaEmergenciasJCF {
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