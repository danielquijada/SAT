package controlador;

import instancias.SAT3Instance;
import java.io.IOException;
import utils.ReaderWriter;

public class Main {

	public static void main(String[] args) {
		SAT3Instance ins = new SAT3Instance();
		ReaderWriter rw = new ReaderWriter();
		
		// Prueba lectura
		try {
			rw.read("res/Entrada.in", ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Prueba escritura
		try {
			rw.write("res/Salida.out", ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
