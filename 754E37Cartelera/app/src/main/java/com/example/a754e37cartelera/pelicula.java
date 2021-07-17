package com.example.a754e37cartelera;

public class pelicula {
    String duracion;
    String titulo;
    String director;
    String reseña;
    int calificacion;
    int refimagen;

    public pelicula(String titulo, String director, String duracion, String reseña, int calificacion, int refimagen) {
        this.duracion = duracion;
        this.titulo = titulo;
        this.director = director;
        this.reseña = reseña;
        this.calificacion = calificacion;
        this.refimagen = refimagen;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getReseña() {
        return reseña;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public int getRefimagen() {
        return refimagen;
    }
}
