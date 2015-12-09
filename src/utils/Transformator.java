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
import modelo.Clause;
import modelo.Variable;


/**
 * Clase para transformar una entrada SAT en una entrada 3SAT.
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
      int i = 1;
      while (iter.hasNext ()) {
         auxClausulas = trans(i++, iter.next ());
         resultado.getClausulas ().addAll (auxClausulas);
      }
      
      resultado.rellenaVariables ();
      return resultado;
   }
   
   /**
    * 
    * @param index 
    * @param clausula
    * @return
    */
   private static ArrayList <Clause> trans (int index, Clause clausula) {
      switch (clausula.getClausula ().size ()) {
         case 0:
            return null;
         case 1:
            return case1 (index,clausula);
         case 2:
            return case2(index,clausula);
         case 3:
            return case3(index,clausula);
         default:
            return case4(index,clausula);
      }
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene más de 3 variables.
    * @param index 
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case4 (int index, Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      Clause nuevaClausula;
      Variable yji = new Variable ("y_" + index + "_1");
      Variable yjk = null;
      
      Variable vari = clausula.getClausula ().get (0);
      Variable varj = clausula.getClausula ().get (1);
      
      // Primera cláusula
      nuevaClausula = new Clause ();
      nuevaClausula.add (vari);
      nuevaClausula.add (varj);
      nuevaClausula.add (yji);
      
      resultado.add (nuevaClausula);
      
      // Cada iteración es una clausula.
      for (int i = 2; i < clausula.getClausula ().size () - 2; i++) {
         yjk = new Variable ("y_" + index + "_" + i);
         nuevaClausula = new Clause ();
         
         nuevaClausula.add (yji.negado ());
         varj = clausula.getClausula ().get (i);
         nuevaClausula.add (varj);
         nuevaClausula.add (yjk);
         
         yji = yjk;
         resultado.add (nuevaClausula);
      }
      
      // Ultima cláusula
      nuevaClausula = new Clause ();
      int tam = clausula.getClausula ().size ();

      vari = clausula.getClausula ().get (tam - 2);
      varj = clausula.getClausula ().get (tam - 1);
      
      nuevaClausula.add (yjk.negado ());
      nuevaClausula.add (vari);
      nuevaClausula.add (varj);
      
      resultado.add (nuevaClausula);

      
      
      return resultado;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 3 variables.
    * @param index 
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case3 (int index, Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      resultado.add (clausula);
      return resultado;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 2 variables.
    * @param index 
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case2 (int index, Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      Clause nuevaClausula;
      Variable yj1 = new Variable ("y_" + index + "_1");
      
      Variable var1 = clausula.getClausula ().get (0);
      Variable var2 = clausula.getClausula ().get (1);
      
      // Primera Clausula:
      nuevaClausula = new Clause ();
      nuevaClausula.add (var1);
      nuevaClausula.add (var2);
      nuevaClausula.add (yj1);
      
      resultado.add (nuevaClausula);
      
      // Primera Clausula:
      nuevaClausula = new Clause ();
      nuevaClausula.add (var1);
      nuevaClausula.add (var2);
      nuevaClausula.add (yj1.negado ());
      
      resultado.add (nuevaClausula);

      return resultado;
   }

   /**
    * Método que resuelve el caso de la transformación SAT-3SAT en el cual la clausula tiene 1 variables.
    * @param index 
    * @param clausula clausula del SAT 
    * @return clasula del 3SAT
    */
   private static ArrayList<Clause> case1 (int index, Clause clausula) {
      ArrayList <Clause> resultado = new ArrayList<Clause> ();
      Clause nuevaClausula;
      Variable yj1 = new Variable ("y_" + index + "_1");
      Variable yj2 = new Variable ("y_" + index + "_2");
      
      Variable var = clausula.getClausula ().get(0);

      // Primera clausula.
      nuevaClausula = new Clause ();
      nuevaClausula.add (var);
      nuevaClausula.add (yj1);
      nuevaClausula.add (yj2);
      
      resultado.add (nuevaClausula);
      
      // Segunda clausula.
      nuevaClausula = new Clause ();
      nuevaClausula.add (var);
      nuevaClausula.add (yj1);
      nuevaClausula.add (yj2.negado ());
      
      resultado.add (nuevaClausula);
      
      // Tercera clausula.
      nuevaClausula = new Clause ();
      nuevaClausula.add (var);
      nuevaClausula.add (yj1.negado ());
      nuevaClausula.add (yj2);
      
      resultado.add (nuevaClausula);
      
      // Cuarta clausula.
      nuevaClausula = new Clause ();
      nuevaClausula.add (var);
      nuevaClausula.add (yj1.negado ());
      nuevaClausula.add (yj2.negado ());
      
      resultado.add (nuevaClausula);

      return resultado;
   }
   
}
