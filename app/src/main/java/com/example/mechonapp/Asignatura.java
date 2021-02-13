package com.example.mechonapp;

public class Asignatura {
    String sigla, nombre, dia, clave, rutUsuario;

    public Asignatura() {
    }

    public Asignatura(String sigla, String nombre, String dia, String clave, String rutUsuario) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.dia = dia;
        this.clave = clave;
        this.rutUsuario = rutUsuario;
    }

    public boolean isNull(){
        if(sigla.equals("")||nombre.equals("")||dia.equals("Seleccione...")||clave.equals("Seleccione..."))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "sigla='" + sigla + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dia='" + dia + '\'' +
                ", clave='" + clave + '\'' +
                ", rutUsuario='" + rutUsuario + '\'' +
                '}';
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
}
