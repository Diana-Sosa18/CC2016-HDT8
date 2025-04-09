/**
 * Representa un paciente en un sistema de atención médica,
 * con un nombre, síntoma y un código de emergencia que determina su prioridad.
 * 
 * La clase implementa la interfaz {@code Comparable<Paciente>} para poder
 * comparar pacientes según su código de emergencia.
 * Un código más bajo indica mayor prioridad.
 * 
 * Ejemplo de uso:
 * <pre>{@code
 * Paciente p = new Paciente("Ana", "Fiebre alta", 'A');
 * System.out.println(p); // Ana, Fiebre alta, A
 * }</pre>
 * 
 */
public class Paciente implements Comparable<Paciente> {
    
    /** Nombre del paciente */
    private String nombre;

    /** Síntoma que presenta el paciente */
    private String sintoma;

    /** Código de emergencia del paciente (A-Z), donde A es la mayor prioridad */
    private char codigoEmergencia;

    /**
     * Crea un nuevo paciente con nombre, síntoma y código de emergencia dados.
     * 
     * @param nombre el nombre del paciente
     * @param sintoma el síntoma que presenta el paciente
     * @param codigoEmergencia el código de emergencia (letra) que indica la prioridad
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return el nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     * 
     * @return el síntoma del paciente
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     * 
     * @return el código de emergencia como carácter
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro según su código de emergencia.
     * Los códigos de emergencia con menor valor (por ejemplo, 'A') indican mayor prioridad.
     * 
     * @param otro el otro paciente con el cual se compara
     * @return un número negativo si este paciente tiene mayor prioridad, 
     *         cero si tienen la misma prioridad,
     *         o un número positivo si tiene menor prioridad
     */
    @Override
    public int compareTo(Paciente otro) {
        return this.codigoEmergencia - otro.codigoEmergencia;
    }

    /**
     * Devuelve una representación en texto del paciente.
     * 
     * @return una cadena con el formato: "nombre, síntoma, códigoEmergencia"
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
