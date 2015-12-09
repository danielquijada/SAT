package utils;

import instancias.SAT3Instance;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		SAT3Instance ins = new SAT3Instance();
		ReaderWriter rw = new ReaderWriter();
		
		// Prueba lectura
		try {
			rw.read("Entrada.in", ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Prueba escritura
		try {
			rw.write("Salida.out", ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
