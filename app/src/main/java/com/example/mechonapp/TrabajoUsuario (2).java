package com.example.mechonapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TrabajoUsuario {
    Context context;
    Usuario usuario;
    ArrayList<Usuario> listaUsuarios;
    SQLiteDatabase sql;
    String bd = "OnePucvBD";
    String tablaUsuarios = "create table if not exists usuarios(Rut text primary key, nombre text, apellido text, email text, sexo text, nUsuario text, password text, fNacimiento text, descripcion text)";

    public TrabajoUsuario(Context c){
        this.context = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        //sql.execSQL("drop table usuarios");
        sql.execSQL(tablaUsuarios);
        usuario = new Usuario();
    }

    public boolean insertUsuario(Usuario usuario){
        if(buscarUsuarioRut(usuario.getRut())==0){
            if(buscarUsuarioNombre(usuario.getnUsuario())==0){
                ContentValues registro = new ContentValues();
                registro.put("Rut", usuario.getRut());
                registro.put("nombre", usuario.getNombre());
                registro.put("apellido", usuario.getApellido());
                registro.put("email", usuario.getEmail());
                registro.put("sexo", usuario.getSexo());
                registro.put("nUsuario", usuario.getnUsuario());
                registro.put("password", usuario.getPassword());
              //  registro.put("fNacimiento", "00/00/0000");
                //   registro.put("descripcion", " ");

                return (sql.insert("usuarios", null, registro) > 0);

            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public int buscarUsuarioRut(String rutUsuario){
        int cont = 0;
        listaUsuarios = selectUsuarios();

        for (Usuario user:listaUsuarios) {
            if(user.getRut().equals(rutUsuario)){
                cont++;
            }
        }

        return cont;
    }

    public int buscarUsuarioNombre(String nombreUsuario){
        int cont = 0;
        listaUsuarios = selectUsuarios();

        for (Usuario user:listaUsuarios) {
            if(user.getnUsuario().equals(nombreUsuario)){
                cont++;
            }
        }

        return cont;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor objCursor = sql.rawQuery("select * from usuarios", null);

        if(objCursor != null && objCursor.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setRut(objCursor.getString(0));
                u.setNombre(objCursor.getString(1));
                u.setApellido(objCursor.getString(2));
                u.setEmail(objCursor.getString(3));
                u.setSexo(objCursor.getString(4));
                u.setnUsuario(objCursor.getString(5));
                u.setPassword(objCursor.getString(6));
                lista.add(u);
            }while (objCursor.moveToNext());
        }

        return lista;
    }

    public int login(String u, String p){
        int i = 0;
        Cursor objCursor = sql.rawQuery("select * from usuarios", null);

        if(objCursor != null && objCursor.moveToFirst()) {
            do {
                if (objCursor.getString(5).equals(u) && objCursor.getString(6).equals(p)) {
                    i++;
                }
            } while (objCursor.moveToNext());
        }

        return i;
    }

    public Usuario obtenerUsuario(String u, String p){
        listaUsuarios = selectUsuarios();

        for (Usuario user:listaUsuarios) {
            if(user.getnUsuario().equals(u) && user.getPassword().equals(p)){
                return user;
            }
        }
        return null;
    }

    public Usuario obtenerUsuario(String rut){
        listaUsuarios = selectUsuarios();

        for (Usuario user:listaUsuarios) {
            if(user.getRut().equals(rut)){
                return user;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(Usuario u){
        ContentValues cv = new ContentValues();

        cv.put("nombre", u.getNombre());
        cv.put("apellido", u.getApellido());
        cv.put("email", u.getEmail());
        cv.put("nUsuario", u.getnUsuario());
        cv.put("password", u.getPassword());
        cv.put("fNacimiento", u.getfNacimiento());
        cv.put("descripcion", u.getDescripcion());

        return (sql.update("usuarios", cv, "Rut = '"+u.getRut()+"'", null)>0);
    }
}
