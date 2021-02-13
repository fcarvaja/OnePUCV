package com.example.mechonapp;

public class Evento {
    int nSerieEvento;
    String tituloEvento, fechaEvento, descEvento, RutUsuario;

    public Evento() {
    }

    public Evento(String tituloEvento, String fechaEvento, String descEvento, String rutUsuario) {
        this.tituloEvento = tituloEvento;
        this.fechaEvento = fechaEvento;
        this.descEvento = descEvento;
        RutUsuario = rutUsuario;
    }

    public boolean isNull(){
        if(tituloEvento.equals("")&&fechaEvento.equals("")&&descEvento.equals(""))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nSerieEvento=" + nSerieEvento +
                ", tituloEvento='" + tituloEvento + '\'' +
                ", fechaEvento='" + fechaEvento + '\'' +
                ", descEvento='" + descEvento + '\'' +
                ", RutUsuario='" + RutUsuario + '\'' +
                '}';
    }

    public int getnSerieEvento() {
        return nSerieEvento;
    }

    public void setnSerieEvento(int nSerieEvento) {
        this.nSerieEvento = nSerieEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public String getRutUsuario() {
        return RutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        RutUsuario = rutUsuario;
    }
}
