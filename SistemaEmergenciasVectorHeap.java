import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SistemaEmergenciasVectorHeap {
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