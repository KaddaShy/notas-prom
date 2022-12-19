package com.example.calculadoranotas.model;

public class Alumno {
    String nombre,apellido,nota1,nota2,nota3,promresult;
    public Alumno(){}

    public Alumno(String nombre, String apellido, String nota1, String nota2, String nota3, String promresult) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.promresult = promresult;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }

    public String getPromresult() {
        return promresult;
    }

    public void setPromresult(String promresult) {
        this.promresult = promresult;
    }
}
