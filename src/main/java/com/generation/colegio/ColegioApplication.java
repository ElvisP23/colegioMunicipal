package com.generation.colegio;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.colegio.models.Alumno;

@SpringBootApplication
public class ColegioApplication {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
	
		String nomCurso;
		Integer cantNotas;
		Integer cantEstudiantes;
		Integer seleccion;

		do {
			System.out.println("--------------------------------------------");
			System.out.println("	MENU DE OPCIONES: Seleccione su opción");
			System.out.println("---------------------------------------------");
			System.out.println(" 1. INGRESAR NOTAS al sistema.");
			System.out.println(" 2. Calcular el Promedio, mejor y peor nota de un Estudiante");
			System.out.println(" 3. Listado de alumnos por cursos");
			System.out.println(" 0. SALIR");

			seleccion = teclado.nextInt();


			
			if(seleccion == 1){
				
				System.out.println("-----------------------------");
				System.out.print("Indica el curso del Estudiante: ");
				nomCurso = teclado.nextLine();
				teclado.nextLine();
				//System.out.println(nomCurso);
		
				do {			
					System.out.println("¿Cuantas NOTAS asignarás al estudiante por Materia?");
					cantNotas = teclado.nextInt();
		
					if(cantNotas <= 0){
						System.out.println("-----------------------------------------------");
						System.out.println("Cantidad invalidad, ingrese un numero correcto");
						System.out.println("-----------------------------------------------");
					}
					
				} while (cantNotas <= 0);
		
				do {
					System.out.println("¿A Cuántos Alumnos del mismo curso les asignarás notas por Materia?");
					cantEstudiantes = teclado.nextInt();
					//System.out.println(cantEstudiantes);
			
					if(cantEstudiantes<= 0){
						System.out.println("-----------------------------------------------");
						System.out.println("Cantidad invalidad, ingrese un numero correcto");
						System.out.println("-----------------------------------------------");
					}
					
				} while (cantEstudiantes<= 0);
			
					//Curso cursoNuevo = new Curso(nomCurso, cantNotas, cantEstudiantes);
			
					//System.out.println(cursoNuevo);
			
					 Alumno alumno = new Alumno();
					 alumno.ingresoDeDatos(cantEstudiantes, cantNotas);
					// System.out.println(alumno);
				
			} 

			if(seleccion ==2){

				Alumno alumno = new Alumno();
				alumno.recepcionNotasUser();
			}

			if(seleccion == 0){

				System.out.println("------------------------------------");
				System.out.println("Gracias, hasta pronto");
				System.out.println("------------------------------------");
			}

			if(seleccion< 0 & seleccion > 2){
				System.out.println("------------------------------------");
				System.out.println("Opción inválidad, vuelva a intentar");
				System.out.println("------------------------------------");

			}






		} while (seleccion != 0); // salida del menu







	}

}
