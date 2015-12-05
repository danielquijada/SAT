/**
 * Final.TransformacionPolinomial.instancias.SAT3Instance.java
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
package instancias;

import java.util.Iterator;
import modelo.Clause;


/**
 * Clase que representa una instancia del problema 3SAT.
 */
public class SAT3Instance extends SATInstance {

   /**
    * Comprueba si la instancia es una instancia válida para el problema 3SAT.
    * @return es valida la instancia.
    */
   public boolean isValido () {
      boolean valido = true;
      
      Iterator<Clause> iter = getClausulas ().iterator ();
      
      while (iter.hasNext ()) {
         valido = valido && iter.next ().getClausula ().size () == 3;
      }
      
      return valido;
   }
}
