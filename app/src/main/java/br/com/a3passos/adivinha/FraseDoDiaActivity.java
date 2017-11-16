package br.com.a3passos.adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class FraseDoDiaActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button btNovaFrase;

    private String[] frases = {"Desiste","Vai fundo","Pode ser", "Tenta de novo","Vai dar certo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase_do_dia);

        textoNovaFrase = (TextView)findViewById(R.id.txtFrase);
        btNovaFrase = (Button)findViewById(R.id.btNovaFrase);


        // acha nova frase
        btNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoNovaFrase.setText(frases[new Random().nextInt(frases.length)]);
            }
        });

    }



}
