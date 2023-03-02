package com.generation.colegio.models;


public class Curso {

    String nombreCurso;
    //Integer cantidadMateria;
    Integer cantNotas;
    Integer cantEstudiantes;

    public Curso() {
    }

    public Curso(String nombreCurso, Integer cantNotas, Integer cantEstudiantes) {
        this.nombreCurso = nombreCurso;
        this.cantNotas = cantNotas;
        this.cantEstudiantes = cantEstudiantes;
        
    }


/*------------------Setters y Getters ----------------- */

public String getNombreCurso() {
    return nombreCurso;
}

public void setNombreCurso(String nombreCurso) {
    this.nombreCurso = nombreCurso;
}

public Integer getCantNotas() {
    return cantNotas;
}

public void setCantNotas(Integer cantNotas) {
    this.cantNotas = cantNotas;
}

public Integer getCantEstudiantes() {
    return cantEstudiantes;
}

public void setCantEstudiantes(Integer cantEstudiantes) {
    this.cantEstudiantes = cantEstudiantes;
}

@Override
public String toString() {
    return "Curso [nombreCurso=" + nombreCurso + ",  cantNotas=" + cantNotas
            + ", cantEstudiantes=" + cantEstudiantes + "]";
}






}

