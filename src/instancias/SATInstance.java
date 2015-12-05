/**
 * Final.TransformacionPolinomial.instancias.SATInstance.java
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

import java.util.ArrayList;
import java.util.Set;
import modelo.Clause;
import modelo.Variable;


/**
 * Clase que representa una instancia del problema SAT.
 */
public class SATInstance {
   private Set<Variable> variables; // U
   private ArrayList<Clause> clausulas; // C
   
   /**
    * @return the variables
    */
   public Set<Variable> getVariables () {
      return variables;
   }
   
   /**
    * @param variables the variables to set
    */
   public void setVariables (Set<Variable> variables) {
      this.variables = variables;
   }
   
   /**
    * @return the clausulas
    */
   public ArrayList<Clause> getClausulas () {
      return clausulas;
   }
   
   /**
    * @param clausulas the clausulas to set
    */
   public void setClausulas (ArrayList<Clause> clausulas) {
      this.clausulas = clausulas;
   }
}
