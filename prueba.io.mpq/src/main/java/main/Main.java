package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			FileWriter escritor = new FileWriter("./prueba.txt");
			escritor.write("Hola Pepeito");
			escritor.flush();
			System.out.println("Escribe");
			sc.nextLine();
			escritor.close();

			BufferedReader lector = new BufferedReader(new FileReader("./prueba.txt"));
			String linea = lector.readLine();
			String texto = "";
			while (linea != null) {
				texto += linea + "\n";
				linea = lector.readLine();
			}
			lector.close();
			System.out.println(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
