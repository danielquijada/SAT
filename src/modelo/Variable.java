/**
 * Final.TransformacionPolinomial.modelo.Variable.java
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


/**
 * Clase que representa una variable.
 */
public class Variable {

   private char nombre;
   private boolean negado;
   
   
   /**
    * Constructor por defecto, coloca el nombre recibido.
    * @param nombre nombre de la variable.
    */
   public Variable (char nombre) {
      setNombre (nombre);
      setNegado (false);
   }
   
   /**
    * Cambia el valor de negado.
    */
   public void toggleNegado () {
      setNegado (!isNegado ());
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals (Object obj) {
      Variable otro = (Variable) obj;
      return otro.getNombre () == getNombre () && otro.isNegado () == isNegado ();
   }
   
   /**
    * @return the nombre
    */
   public char getNombre () {
      return nombre;
   }
   
   /**
    * @param nombre the nombre to set
    */
   public void setNombre (char nombre) {
      this.nombre = nombre;
   }
   
   /**
    * @return the negado
    */
   public boolean isNegado () {
      return negado;
   }
   
   /**
    * @param negado the negado to set
    */
   public void setNegado (boolean negado) {
      this.negado = negado;
   }
}
