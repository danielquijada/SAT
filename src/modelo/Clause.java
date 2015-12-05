/**
 * Final.TransformacionPolinomial.modelo.Clause.java
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

package modelo;

import java.util.Set;
import java.util.TreeSet;


/**
 * Clase que representa una clausula del problema SAT.
 */
public class Clause {

   private Set<Variable> clausula;

   /**
    * Añade una variable a la cláusula.
    * 
    * @param var
    *           variable a añadir.
    */
   public void add (Variable var) {
      getClausula ().add (var);
   }

   /**
    * Constructor por defecto.
    */
   public Clause () {
      setClausula (new TreeSet<Variable> ());
   }

   /**
    * @return the clausula
    */
   public Set<Variable> getClausula () {
      return clausula;
   }


   /**
    * @param clausula
    *           the clausula to set
    */
   public void setClausula (Set<Variable> clausula) {
      this.clausula = clausula;
   }
}
