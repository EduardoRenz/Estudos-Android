package br.com.a3passos.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class NumeroRandomActivity extends AppCompatActivity {

    private Button botaoJogar;
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_random);

        botaoJogar = (Button)findViewById(R.id.numeroRandom);
        textoResultado = (TextView) findViewById(R.id.lblNumero);



        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randomico = new Random();
                int numeroSorteado = randomico.nextInt(11);
                textoResultado.setText("Texto Alterado: " + numeroSorteado);
            }
        });

    }
}
