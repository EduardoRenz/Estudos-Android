package br.com.a3passos.adivinha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.a3passos.adivinha.banco.BancoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroRandom,fraseDoDia,idadeCachorro,inputs,anotacoes,banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numeroRandom = (Button)findViewById(R.id.numeroRandom);
        fraseDoDia = (Button)findViewById(R.id.fraseDoDia);
        idadeCachorro = (Button)findViewById(R.id.idadeCachorro);
        inputs = (Button)findViewById(R.id.inputs);
        anotacoes = (Button)findViewById(R.id.btAnotacoes);
        banco = (Button) findViewById(R.id.bt_banco);

        // ----------- Listeners ------------
        numeroRandom.setOnClickListener(this);
        fraseDoDia.setOnClickListener(this);
        idadeCachorro.setOnClickListener(this);
        inputs.setOnClickListener(this);
        anotacoes.setOnClickListener(this);
        banco.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.numeroRandom:
                 i = new Intent(view.getContext(),NumeroRandomActivity.class);
                break;
            case R.id.fraseDoDia:
                 i = new Intent(view.getContext(),FraseDoDiaActivity.class);
                break;
            case R.id.idadeCachorro:
                i = new Intent(view.getContext(),IdadeCachorroActivity.class);
                break;
            case R.id.inputs:
                i = new Intent(view.getContext(),InputsActivity.class);
                break;
            case R.id.btAnotacoes:
                i = new Intent(view.getContext(),AnotacoesActivity.class);
                break;
            case R.id.bt_banco:
                i = new Intent(view.getContext(),BancoActivity.class);
                break;
        }
        startActivity(i);

        Log.d("Click", String.valueOf(view.getId()));
    }
}
