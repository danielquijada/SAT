/**
 * Final.TransformacionPolinomial.controlador.Main.java
 * Practica Final. Transformación Polinomial entre SAT y 3SAT.
 *
 * Asignatura: Complejidad Computacional
 * Universidad de La Laguna.
 * Curso: 2015-2016
 *
 * Autores: 
 *    Daniel E. Quijada Díaz
 *       Contacto: daniventf@gmail.com
 *    José Carlos Rodríguez Cortés
 *       Contacto: joseka1234@gmail.com
 *    Manuel Alejandro Rodríguez Santana
 *       Contacto: manwelanza@gmail.com
 *    Mauricio Manuel Cavalleri Sergent
 *       Contacto: maurimanuel92@gmail.com
 */
package controlador;

import java.io.IOException;
import utils.ReaderWriter;
import utils.Transformator;


/**
 * Clase Main.
 */
public class Main {
   
   private static final String INPUT_FILE = "res/input.txt";
   private static final String OUTPUT_FILE = "res/output.txt";

   /**
    * Escribe en la salida indicada el resultado de la conversion de la entrada indicada.
    */
   public static void main (String[] args) throws IOException {
      ReaderWriter.write (OUTPUT_FILE, Transformator.trans (ReaderWriter.read (INPUT_FILE)));
   }
}
