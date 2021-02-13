package com.example.mechonapp;


public class Usuario {
    String Rut, nombre, apellido, email, sexo, nUsuario, password, fNacimiento, descripcion;

    public Usuario() {
    }

    public Usuario(String rut, String nombre, String apellido, String email, String sexo, String nUsuario, String password) {
        this.Rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.sexo = sexo;
        this.nUsuario = nUsuario;
        this.password = password;
    }

    public boolean isNull(){
        if(Rut.equals("")&&nombre.equals("")&&apellido.equals("")&&email.equals("")&&nUsuario.equals("")&&password.equals(""))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Rut='" + Rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nUsuario='" + nUsuario + '\'' +
                ", password='" + password + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fNacimiento=" + fNacimiento +
                '}';
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getnUsuario() {
        return nUsuario;
    }

    public void setnUsuario(String nUsuario) {
        this.nUsuario = nUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
}
