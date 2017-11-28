package br.com.a3passos.adivinha;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class AnotacoesActivity extends AppCompatActivity {
    private static final String NOME_ARQUIVO = "Anotacao.txt";
    private EditText bloco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);
        bloco = (EditText) findViewById(R.id.bloco);
        bloco.setText(lerArquivo());


        bloco.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                gravarNoArquivo(bloco.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                gravarNoArquivo(bloco.getText().toString());
            }
        });
    }

    private  void gravarNoArquivo(String texto){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(NOME_ARQUIVO, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        }
        catch (Exception e){
            Log.e("Erro",e.toString());
        }
    }


    private String lerArquivo(){
        String resultado = "";
        try {
            InputStream arquivo = openFileInput(NOME_ARQUIVO);
            if(arquivo != null){
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);

                //Gerar buffer
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String linhaArquivo = "";
                while((linhaArquivo = bufferedReader.readLine())!= null){
                    resultado += linhaArquivo;
                }

            }
        }catch (Exception e){
            Log.e("Erro",e.toString());
        }
        return  resultado;
    }

}
