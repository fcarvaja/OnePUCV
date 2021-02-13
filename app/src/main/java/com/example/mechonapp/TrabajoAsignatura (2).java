package com.example.mechonapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TrabajoAsignatura {
    Context context;
    Asignatura asignatura;
    ArrayList<Asignatura> listaAsignaturas;
    SQLiteDatabase sql;
    String bd = "OnePucvBD";
    String tablaAsignaturas = "Create table if not exists asignaturas(sigla text, nombreAsignatura text, dia text, claveHoraria text, RutUsuario text, primary key(sigla, dia, claveHoraria), foreign key(RutUsuario) references usuario(Rut))";

    public TrabajoAsignatura(Context c){
        this.context = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tablaAsignaturas);
        asignatura = new Asignatura();
    }

    public boolean insertAsignatura(Asignatura a){
        if(buscarAsignatura(a.getSigla(), a.getDia(), a.getClave(), a.getRutUsuario())==0){
            if(claveOcupada(a.getDia(), a.getClave(), a.getRutUsuario())){
                return false;
            }
            else{
                ContentValues registro = new ContentValues();

                registro.put("sigla", a.getSigla());
                registro.put("nombreAsignatura", a.getNombre());
                registro.put("dia", a.getDia());
                registro.put("claveHoraria", a.getClave());
                registro.put("RutUsuario", a.getRutUsuario());

                return (sql.insert("asignaturas", null, registro) > 0);
            }
        }
        else{
            return false;
        }
    }

    public int buscarAsignatura(String sigla, String dia, String clave, String rut){
        int contador = 0;
        listaAsignaturas = selectAsignaturas();

        for (Asignatura asig:listaAsignaturas) {
            if(asig.getSigla().equals(sigla)&&asig.getDia().equals(dia)&&asig.getClave().equals(clave)&&asig.getRutUsuario().equals(rut)){
                contador++;
            }
        }
        return contador;
    }

    public boolean claveOcupada(String dia, String clave, String rut){
        listaAsignaturas = selectAsignaturas();

        for (Asignatura asig:listaAsignaturas) {
            if(asig.getDia().equals(dia)&&asig.getClave().equals(clave)&&asig.getRutUsuario().equals(rut)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Asignatura> selectAsignaturas(){
        ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
        lista.clear();
        Cursor objCursor = sql.rawQuery("select * from asignaturas", null);

        if(objCursor != null && objCursor.moveToFirst()){
            do {
                Asignatura a = new Asignatura();
                a.setSigla(objCursor.getString(0));
                a.setNombre(objCursor.getString(1));
                a.setDia(objCursor.getString(2));
                a.setClave(objCursor.getString(3));
                a.setRutUsuario(objCursor.getString(4));
                lista.add(a);
            }while (objCursor.moveToNext());
        }
        return lista;
    }

    public void borrarAsignaturas(String id){
        sql.delete("asignaturas", "RutUsuario='"+id+"'",null);
    }
}