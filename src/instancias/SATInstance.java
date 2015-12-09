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
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import modelo.Clause;
import modelo.Variable;


/**
 * Clase que representa una instancia del problema SAT.
 */
public class SATInstance {

   private Set<Variable>     variables; // U
   private ArrayList<Clause> clausulas; // C


   /**
    * Constructor por defecto.
    */
   public SATInstance () {
      setVariables (new TreeSet<Variable> ());
      setClausulas (new ArrayList<Clause> ());
   }

   /**
    * Método que coge las variables de las clausulas.
    */
   public void rellenaVariables () {
      setVariables (new TreeSet<Variable> ());
      Iterator<Clause> iter = getClausulas ().iterator ();

      while (iter.hasNext ()) {
         Clause aux = iter.next ();
         getVariables ().addAll (aux.getClausula ());
      }
   }

   /**
    * @return the variables
    */
   public Set<Variable> getVariables () {
      return variables;
   }

   /**
    * @param variables
    *           the variables to set
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
    * @param clausulas
    *           the clausulas to set
    */
   public void setClausulas (ArrayList<Clause> clausulas) {
      this.clausulas = clausulas;
   }

   /**
    * Añade una cláusula
    * 
    * @param clause
    * @param object
    */
   public void addClause (Clause clause) {
      getClausulas ().add (clause);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString () {


      String cadena = "V = { ";

      for (Variable var : getVariables ()) {
         cadena += var + ", ";
      }

      cadena = cadena.substring (0, cadena.length () - 2) + " }\n";

      cadena += "C = ";

      for (Clause cl : getClausulas ()) {
         cadena += cl + " ∧ ";
      }

      return cadena.substring (0, cadena.lastIndexOf ("∧"));
   }
}
