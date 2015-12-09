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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	// Lector y escritor
	private BufferedReader lector;
	private PrintWriter escritor;

	/**
	 * Método que lee del fichero de entrada
	 * @param fileIn Nombre del fichero de entrada
	 * @param satins Instancia de SAT
	 * @throws IOException
	 */
	public void read(String fileIn, SATInstance satins) throws IOException {
		String [] clausula;
		ArrayList<Clause> clausulas = new ArrayList<Clause>();
		setLector(new BufferedReader(new FileReader(fileIn)));
		
		// Leer clausulas
		while(getLector().ready()) {
			clausula = getLector().readLine().split(" ");
			// TODO: Mirar si hay problemas con las referencias!!!!
			Clause auxClausula = new Clause();
			for(String name : clausula) {
				if(name.split(SPLITTER).length == 1)
					auxClausula.add(new Variable(name));
				else if (name.split(SPLITTER)[0].equals("$")){
					auxClausula.add(new Variable(name.split(SPLITTER)[1]));
					auxClausula.getClausula().get(auxClausula.getClausula().size() - 1).toggleNegado();
				}
				else {
					System.err.println("Simbolo " + name.split(SPLITTER)[0] + " no identificado. Añadida variable como negada");
					auxClausula.add(new Variable(name.split(SPLITTER)[1]));
					auxClausula.getClausula().get(auxClausula.getClausula().size() - 1).toggleNegado();
				}
			}
			clausulas.add(auxClausula);
		}
		satins.setClausulas(clausulas);
		
		satins.rellenaVariables();
		
		getLector().close();
	}

	/**
	 * Método que escribe en el fichero de salida
	 * @param fileOut  Nombre del fichero de salida
	 * @param satins Instancia del SAT
	 * @throws IOException
	 */
	public void write(String fileOut, SATInstance satins) throws IOException {
		setEscritor(new PrintWriter(new BufferedWriter(new FileWriter(fileOut))));
		
		// Escribir variables
		for(Variable var : satins.getVariables())
			getEscritor().print(var.getNombre() + " ");
		getEscritor().println(SPLITTER);
		
		// Escribir clausulas
		ArrayList<Clause> clausulas = satins.getClausulas();
		for(Clause clausula : clausulas) {
			for(Variable var : clausula.getClausula())
				getEscritor().print(var + " ");
			getEscritor().println(SPLITTER);
		}
		
		getEscritor().close();
	}
	

	// Getters y setters
	public BufferedReader getLector() {
		return lector;
	}

	public void setLector(BufferedReader lector) {
		this.lector = lector;
	}

	public PrintWriter getEscritor() {
		return escritor;
	}

	public void setEscritor(PrintWriter escritor) {
		this.escritor = escritor;
	}
}