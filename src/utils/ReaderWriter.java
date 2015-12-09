/**
 * Final.TransformacionPolinomial.utils.ReaderWriter.java
 * Practica Final. Transformación Polinomial entre SAT y 3SAT.
 *
 * Asignatura: Complejidad Computacional
 * Universidad de La Laguna.
 * Curso: 2015-2016
 *
 * Autores: 
 * 	Daniel E. Quijada Díaz
 * 		Contacto: daniventf@gmail.com
 * 	José Carlos Rodríguez Cortés
 * 		Contacto: joseka1234@gmail.com
 * 	Manuel Alejandro Rodríguez Santana
 * 		Contacto: manwelanza@gmail.com
 * 	Mauricio Manuel Cavalleri Sergent
 * 		Contacto: maurimanuel92@gmail.com
 */

package utils;

import instancias.SATInstance;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Clause;
import modelo.Variable;


/**
 * Clase que se encarga de la entrada y la salida mediante ficheros.
 */
public class ReaderWriter {

   public static final String SPLITTER = "";

   /**
    * Método que lee del fichero de entrada.
    * 
    * @param filename
    *           nombre del fichero de entrada.
    * @return Instancia del problema SAT.
    * @throws IOException
    */
   public static SATInstance read (String filename) throws IOException {

      SATInstance sati = new SATInstance ();

      BufferedReader br = new BufferedReader (new FileReader (filename));
      String linea;

      while ((linea = br.readLine ()) != null) {
         if (linea.trim ().length () > 0)
            sati.addClause (readLine (linea));
      }

      br.close ();
      sati.rellenaVariables ();

      return sati;
   }

   /**
    * Lee una línea y devuelve la cláusula que le corresponde.
    * 
    * @param linea
    *           linea a leer
    * @return clausula a añadir
    */
   private static Clause readLine (String linea) {

      Clause clausula = new Clause ();

      String[] nombresVariables = linea.split (" ");
      ArrayList<Variable> variables = getVariables (nombresVariables);
      for (Variable var : variables) {
         clausula.add (var);
      }

      return clausula;
   }

   /**
    * Devuelve un ArrayList de variables.
    * 
    * @param nombresVariables
    *           array con los nombres de las variables.
    * @return ArrayList con las variables descritas en nombresVariables.
    */
   private static ArrayList<Variable> getVariables (String[] nombresVariables) {

      ArrayList<Variable> variables = new ArrayList<Variable> ();

      for (String variable : nombresVariables) {
         String nombre;
         boolean negado;

         if (variable.charAt (0) == '$') {
            nombre = variable.substring (1);
            negado = true;
         } else {
            nombre = variable;
            negado = false;
         }

         Variable var = new Variable (nombre);
         var.setNegado (negado);
         variables.add (var);
      }

      return variables;
   }

   /**
    * Método que escribe en el fichero de salida
    * 
    * @param filename
    *           Nombre del fichero de salida
    * @param satInstance
    *           Instancia del SAT
    * @throws IOException
    */
   public static void write (String filename, SATInstance satInstance) throws IOException {
      System.out.println (satInstance);

      PrintWriter pw = new PrintWriter (new File (filename));

      for (Clause clausula : satInstance.getClausulas ()) {
         pw.println (write (clausula));
      }

      pw.close ();
   }

   /**
    * Método para escribir una cláusula.
    * 
    * @param clausula
    * @return cadena en la que se representa una cláusula.
    */
   private static String write (Clause clausula) {
      String cadena = "";

      for (Variable var : clausula.getClausula ()) {
         if (var.isNegado ())
            cadena += "$";
         cadena += var.getNombre () + " ";
      }

      return cadena.trim ();
   }
}