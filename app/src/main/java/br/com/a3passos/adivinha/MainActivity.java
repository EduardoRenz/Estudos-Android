package br.com.a3passos.adivinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button numeroRandom,fraseDoDia,idadeCachorro,inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroRandom = (Button)findViewById(R.id.numeroRandom);
        fraseDoDia = (Button)findViewById(R.id.fraseDoDia);
        idadeCachorro = (Button)findViewById(R.id.idadeCachorro);
        inputs = (Button)findViewById(R.id.inputs);

        //Vai para o Numero Random
        numeroRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNumeroRandom = new Intent(view.getContext(),NumeroRandomActivity.class);
                startActivity(iNumeroRandom);
            }
        });

        //Vai para Frase do DIa
        fraseDoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),FraseDoDiaActivity.class);
                startActivity(i);
            }
        });

        //Vai para Idade de cachorro
        idadeCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),IdadeCachorroActivity.class);
                startActivity(i);
            }
        });

        //Vai para inputs

        inputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),InputsActivity.class);
                startActivity(i);
            }
        });

    }


}
