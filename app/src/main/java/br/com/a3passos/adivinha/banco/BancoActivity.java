package br.com.a3passos.adivinha.banco;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.a3passos.adivinha.R;

public class BancoActivity extends AppCompatActivity {
    private EditText pesquisa,nova_tarefa;
    private Button nova;
    private ListView lista;
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>() ;
    @SuppressLint("SQLiteString")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco);

        pesquisa = (EditText) findViewById(R.id.txt_pesquisar);
        nova_tarefa = (EditText) findViewById(R.id.txt_nova_tarefa);
        nova = (Button) findViewById(R.id.bt_nova_tarefa);
        lista = (ListView) findViewById(R.id.lista);


        final SQLiteDatabase bancoDados = openOrCreateDatabase("Advinha",MODE_PRIVATE,null);
        //bancoDados.execSQL("DROP TABLE tarefa_layout");
        //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefa_layout(id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , task VARCHAR)");
        //bancoDados.execSQL("INSERT INTO tarefa_layout(task) VALUES('Primeira tafefa')");

        Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefa",null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
           Log.d("item", cursor.getString(1));
            tarefas.add(new Tarefa(cursor.getInt(0),cursor.getString(1),bancoDados));
        }

        final TarefaAdapter itemsAdapter = new TarefaAdapter(this, R.layout.tarefa_layout, tarefas);

        lista.setAdapter(itemsAdapter);

        nova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa novaT = new Tarefa(tarefas.size(),nova_tarefa.getText().toString(),bancoDados);
                novaT.salvarTarefa();
                tarefas.add(novaT);
                itemsAdapter.notifyDataSetChanged();
            }
        });

    }
}
