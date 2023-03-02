package com.generation.colegio.models;

import java.util.ArrayList;
import java.util.Scanner;


public class Alumno extends Curso {

    
    ArrayList<Double> notasPorMaterias = new ArrayList<Double>();
    ArrayList<Double> notasStatus = new ArrayList<Double>();

    ArrayList<Alumno> Curso = new ArrayList<Alumno>();

    ArrayList<String> nombreAlumnos = new ArrayList<String>();
    ArrayList<String> nombreMaterias = new ArrayList<String>();
    Double notaUser; //Para guardar el valor de las notas ingresadas por teclado
    Double notaUserStatus;

    Scanner entredaTeclado = new Scanner(System.in);

    String nombreAlumno;
    String nombreMateria;
    Double promedioEstudiante;
    Double promedioStatus;

    /*------------------ CONSTRUCTORES ------------------------- */
    public Alumno() {

    }

    public Alumno(String nombreCurso, Integer cantNotas, Integer cantEstudiantes, String nombreAlumno,
            String nombreMateria, Double promedioEstudiante) {
        super(nombreCurso, cantNotas, cantEstudiantes);
        this.nombreAlumno = nombreAlumno;
        this.nombreMateria = nombreMateria;
        this.promedioEstudiante = promedioEstudiante;
    }

    /* ----------------------------------------------------------------------- */
    /*---------------- sETTERS & GETTERS ------------------------------------- */



    

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public Double getPromedioEstudiante() {
        return promedioEstudiante;
    }

    public void setPromedioEstudiante(Double promedioEstudiante) {
        this.promedioEstudiante = promedioEstudiante;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public ArrayList<Alumno> getCurso() {
        return Curso;
    }

    public void setCurso(ArrayList<Alumno> curso) {
        Curso = curso;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

  
    /*--------------- OTROS METODOS --------------------------------------- */

    @Override
    public String toString() {
        return "Alumno [nombreAlumno=" + nombreAlumno + ", nombreMateria=" + nombreMateria
                + ", promedioEstudiante=" + promedioEstudiante + " ]";
    }

    public void ingresoDeDatos(Integer cantEstudiantes, Integer cantNotas) {

        for (int i = 0; i < cantEstudiantes; i++) { /* Primer for para el registro de los estudiantes */

            Alumno alumnoObjeto = new Alumno(); //Creo la instancia 

            System.out.print(" Indique el nombre del Alumno " + (i + 1) + ": ");

            alumnoObjeto.setNombreAlumno(entredaTeclado.nextLine()); /* Seteo el nombre del alumno */
            entredaTeclado.nextLine();     // para limpiar el bufer del Scanner

            System.out.print("indique el nombre de la Materia " + (i + 1) + ": ");
            alumnoObjeto.setNombreMateria(entredaTeclado.nextLine()); // seteo el nombre de la materia

            entredaTeclado.nextLine(); // para limpiar el bufer del Scanner

            for (int z = 0; z < cantNotas; z++) { /* todas las notas de la materia */

                do {
                        System.out.println("Ingrese la NOTA " + (z + 1) + " del alumno " + alumnoObjeto.getNombreAlumno() + ": ");
    
                        notaUser = entredaTeclado.nextDouble();

                        if(notaUser < 0 || notaUser > 7){
                            System.out.println("-----------------------------------------");
                            System.out.println("Nota fuera de Rango, ingrese de nuevo");
                            System.out.println("-----------------------------------------");
                        }
                        
                    } while (notaUser < 0 || notaUser > 7);
                    
                    notasPorMaterias.add(notaUser); // AGREGO NOTA AL ARREGLO DE NOTAS
                    //System.out.println(notasPorMaterias);
            }
            
            /* llamar a funcion de promedio del alumno  y seteo el atributo promedio*/
            alumnoObjeto.setPromedioEstudiante(promedioEstudiante(notasPorMaterias));

            Curso.add(alumnoObjeto); // AGREGO AL ARRAY DE ALUMNOS
            System.out.println(Curso);
            notasPorMaterias.clear(); // LIMPIAMOS EL ARRAY 

        }

    }


/* -------------- FUNCION PARA SACAR EL PROMEDIO/MAYOR/MENOR NOTA DE UN ARREGLO -------------- */
    public void recepcionNotasUser(){

        Double numMayor = 100.0; /* ya que las notas son de 0 a 7 */
        Double numMenor = -1.1;

        System.out.println("------------------------------");
        System.out.println("¿Cuantas notas ingresarás?");
        System.out.println("-------------------------------");

        
        do {
            cantNotas = entredaTeclado.nextInt();
            //entredaTeclado.nextInt();
            
			if(cantNotas <= 0){
				System.out.println("-----------------------------------------------");
				System.out.println("Cantidad invalidad, ingrese un numero correcto");
				System.out.println("-----------------------------------------------");
			}

        } while (cantNotas <= 0);



        for (int i = 0; i < cantNotas; i++) { /* todas las notas de la materia */

            System.out.println("Ingrese la NOTA " + (i + 1) + ": ");

            notaUserStatus = entredaTeclado.nextDouble();

            if(notaUserStatus > numMenor){
                numMenor = notaUserStatus; /* para representa el numero mayor */
            }

            if(notaUserStatus < numMayor){
                numMayor = notaUserStatus; /*para encontrar el menor */
            }
            
            notasStatus.add(notaUserStatus);
            //entredaTeclado.nextLine();
            
            //System.out.println(notasPorMaterias);
            
            
        }
        promedioStatus = promedioEstudiante(notasStatus);
    
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(" Las notas ingresadas son: " + notasStatus + ", La nota mayor es: " + numMenor + ", la nota menor es: " + numMayor + ". El promedio es: " + promedioStatus);
        System.out.println("-----------------------------------------------------------------------------");

    }
/* --------------------------------------------------------------------------------------------------------------- */
    /* ---------------- CALUCLO DE PROMEDIO ----------------- */

    public Double promedioEstudiante (ArrayList<Double> notas){		
        
        Double suma = 0.0;
		
		for (int i = 0; i < notas.size(); i++) {
			suma += notas.get(i);
		}

        promedioEstudiante = suma / notas.size();
        System.out.println(promedioEstudiante);
        
        return promedioEstudiante;
    }

/*------------------------------------------------------------------- */


}
