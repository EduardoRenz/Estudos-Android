package br.com.a3passos.adivinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button numeroRandom,fraseDoDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroRandom = (Button)findViewById(R.id.numeroRandom);
        fraseDoDia = (Button)findViewById(R.id.fraseDoDia);

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
    }


}
