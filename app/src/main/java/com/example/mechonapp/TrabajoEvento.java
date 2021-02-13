package com.example.mechonapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TrabajoEvento {
    Context context;
    Evento evento;
    ArrayList<Evento> listaEventos;
    SQLiteDatabase sql;
    String bd = "OnePucvBD";
    String tablaEventos = "Create table if not exists eventos(nEvento int, titulo text, fecha text, descripcion text, RutUsuario text, primary key(titulo, fecha, RutUsuario), foreign key(RutUsuario) references usuario(Rut))";

    public TrabajoEvento(Context c){
        this.context = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        //sql.execSQL("drop table eventos");
        sql.execSQL(tablaEventos);
        evento = new Evento();
    }

    public boolean insertEvento(Evento evento){
        int numero = 0;
        listaEventos = selectEventos();
        if (listaEventos.size()>0)
            numero = listaEventos.size();

        if(buscarEvento(evento.getTituloEvento(), evento.getFechaEvento(), evento.getRutUsuario())==0){
                ContentValues registro = new ContentValues();
                registro.put("nEvento", numero);
                registro.put("titulo", evento.getTituloEvento());
                registro.put("fecha", evento.getFechaEvento());
                registro.put("descripcion", evento.getDescEvento());
                registro.put("RutUsuario", evento.getRutUsuario());

                return (sql.insert("eventos", null, registro) > 0);
        }
        else{
            return false;
        }
    }

    public int buscarEvento(String titulo, String fecha, String rut){
        int cont = 0;
        listaEventos = selectEventos();

        for (Evento evento:listaEventos) {
            if(evento.getTituloEvento().equals(titulo)&&evento.getFechaEvento().equals(fecha)&&evento.getRutUsuario().equals(rut)){
                cont++;
            }
        }

        return cont;
    }

    public ArrayList<Evento> selectEventos(){
        ArrayList<Evento> lista = new ArrayList<Evento>();
        lista.clear();
        Cursor objCursor = sql.rawQuery("select * from eventos", null);

        if(objCursor != null && objCursor.moveToFirst()){
            do {
                Evento e = new Evento();
                e.setnSerieEvento(objCursor.getInt(0));
                e.setTituloEvento(objCursor.getString(1));
                e.setFechaEvento(objCursor.getString(2));
                e.setDescEvento(objCursor.getString(3));
                e.setRutUsuario(objCursor.getString(4));
                lista.add(e);
            }while (objCursor.moveToNext());
        }

        return lista;
    }

}
