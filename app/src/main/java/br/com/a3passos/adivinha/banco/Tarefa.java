package br.com.a3passos.adivinha.banco;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Eduardo on 28/11/2017.
 */

public class Tarefa {
    private int id;
    private String tarefa;
    private SQLiteDatabase banco;

    public Tarefa(int id, String tarefa, SQLiteDatabase banco) {
        this.id = id;
        this.tarefa = tarefa;
        this.banco = banco;
    }


    public void salvarTarefa(){
        banco.execSQL("INSERT INTO tarefa(task) values(:tarefa)", new String[]{tarefa});
    }

    public void excluirTarefa(){
        banco.execSQL("DELETE FROM tarefa WHERE id = " + id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
