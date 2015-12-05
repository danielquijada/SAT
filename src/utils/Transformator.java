/**
 * Final.TransformacionPolinomial.utils.Transformator.java
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

import instancias.SAT3Instance;
import instancias.SATInstance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import modelo.Clause;
import modelo.Variable;


/**
 * TODO Descripción de la clase.
 */
public class Transformator {

   /**
    * 
    * @param sat
    * @return
    */
   public static SAT3Instance trans (SATInstance sat) {
      ArrayList<Clause> auxClausulas;
      SAT3Instance resultado = new SAT3Instance ();
      
      Iterator<Clause> iter = sat.getClausulas ().iterator ();
      while (iter.hasNext ()) {
         auxClausulas = trans(iter.next ());
         resultado.getClausulas ().addAll (auxClausulas);
      }
      
      resultado.rellenaVariables ();
      return resultado;
   }
   
   /**
    * 
    * @param clausula
    * @return
    */
   private static ArrayList <Clause> trans (Clause clausula) {
      switch (clausula.getClausula ().size ()) {
         case 0:
            return null;
         case 1:
            return case1 (clausula);
         case 2:
            return case2(clausula);
         case 3:
            return case3(clausula);
         default:
            return case4(clausula);
      }
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene más de 3 variables.
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case4 (Clause clausula) {
      
      return null;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 3 variables.
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case3 (Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      resultado.add (clausula);
      return resultado;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 2 variables.
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case2 (Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      Clause clausula1  = new Clause ();
      Clause clausula2  = new Clause ();
      Variable auxVariable = new Variable ("y_1");
      
      Iterator <Variable> iter = clausula.getClausula ().iterator ();
      while (iter.hasNext ()) {
         Variable aux = iter.next ();
         clausula1.add(aux);
         clausula2.add(aux);
      }
      clausula1.add(auxVariable);
      auxVariable.setNegado (true);
      clausula2.add (auxVariable);
      
      resultado.add(clausula1);
      resultado.add(clausula2);
      return resultado;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 1 variables.
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case1 (Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      Clause clausula1  = new Clause ();
      Clause clausula2  = new Clause ();
      Clause clausula3  = new Clause ();
      Clause clausula4  = new Clause ();
      Variable auxVariable1 = new Variable ("y_1");
      Variable auxVariable2 = new Variable ("y_2");
      
      Iterator <Variable> iter = clausula.getClausula ().iterator ();
      while (iter.hasNext ()) {
         Variable aux = iter.next ();
         clausula1.add(aux);
         clausula2.add(aux);
         clausula3.add(aux);
         clausula4.add(aux);
      }
      clausula1.add(auxVariable1);
      clausula1.add(auxVariable2);
      clausula2.add(auxVariable1);
      clausula3.add(auxVariable2);
      
      auxVariable1.setNegado (true);
      auxVariable2.setNegado (true);
      
      clausula2.add (auxVariable2);
      clausula3.add (auxVariable1);
      clausula4.add(auxVariable1);
      clausula4.add(auxVariable2);
      
      resultado.add(clausula1);
      resultado.add(clausula2);
      resultado.add(clausula3);
      resultado.add(clausula4);
      return resultado;
   }
   
}
