package br.com.a3passos.adivinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button numeroRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroRandom = (Button)findViewById(R.id.numeroRandom);
        //Vai para o Numero Random
        numeroRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNumeroRandom = new Intent(view.getContext(),NumeroRandomActivity.class);
                startActivity(iNumeroRandom);
            }
        });

    }


}
