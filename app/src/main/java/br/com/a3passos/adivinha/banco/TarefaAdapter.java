package br.com.a3passos.adivinha.banco;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.a3passos.adivinha.R;

/**
 * Created by Eduardo on 28/11/2017.
 */

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private   ArrayList<Tarefa>tarefas;
    public TarefaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Tarefa> tarefas) {
        super(context, resource, tarefas);
        this.tarefas = tarefas;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Tarefa tarefa = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tarefa_layout, parent, false);
        }
        // Lookup view for data population
        TextView txtTarefa = (TextView) convertView.findViewById(R.id.tarefa);

        // Populate the data into the template view using the data object
        txtTarefa.setText((CharSequence) tarefa.getTarefa());


        ImageButton bt = (ImageButton) convertView.findViewById(R.id.bt_excluir);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clico",tarefa.getTarefa());
                tarefa.excluirTarefa();
                tarefas.remove(position);
                notifyDataSetChanged();


            }
        });


        // Return the completed view to render on screen
        return convertView;

    }




}
